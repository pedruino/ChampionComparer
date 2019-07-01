package com.pedruino.championcomparer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.pedruino.championcomparer.adapter.TabsAdapter;
import com.pedruino.championcomparer.api.ApiClient;
import com.pedruino.championcomparer.api.responses.ChampionsResponse;
import com.pedruino.championcomparer.data.Champion;
import com.pedruino.championcomparer.fragments.TabChampionOverview;
import com.pedruino.championcomparer.fragments.TabChampionAbilities;
import com.pedruino.championcomparer.fragments.TabChampionStats;
import com.pedruino.championcomparer.task.LoadChampionTask;

import java.util.ArrayList;

import static com.pedruino.championcomparer.R.*;

public class ChampionInfoActivity extends AppCompatActivity implements LoadChampionTask.LoadChampionsTaskDelegate {
    public static final String PARAM_CHAMPION = "champion";
    public static final String PARAM_CHAMPION_ID = "champion_id";
    public static final String PARAM_CHAMPIONS = "champions";
    private ProgressDialog progressDialog;
    private ArrayList<Champion> champions;
    private String selectedChampionId;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_champion_info);

        this.toolbar = findViewById(id.activity_champion_info_toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setNavigationIcon(drawable.ic_arrow_back_black_24dp);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setResult(RESULT_CANCELED);
                    finish();
                }
            });
        }

        Intent intent = getIntent();
        this.selectedChampionId = intent.getStringExtra(PARAM_CHAMPION_ID);

        this.champions = (ArrayList<Champion>) intent.getSerializableExtra(PARAM_CHAMPIONS);

        LoadChampionTask task = new LoadChampionTask(this);
        task.execute(this.selectedChampionId);

        this.progressDialog = ProgressDialog.show(this, getResources().getString(string.wait), getResources().getString(string.loading));
    }

    @Override
    public void onSuccess(ChampionsResponse response) {
        Champion champion = new Champion.Builder()
                .withChampionResponse(response.getData().get(this.selectedChampionId))
                .withBaseImageUrl(ApiClient.BASE_URL)
                .build();

        Resources resources = getResources();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.toolbar.setTitle(String.format("%s: %s", champion.getName(), champion.getTitle()));
        }

        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());

        adapter.add(TabChampionOverview.newInstance(champion), resources.getString(string.overview));
        adapter.add(TabChampionStats.newInstance(champion, this.champions), resources.getString(string.stats));
        adapter.add(TabChampionAbilities.newInstance(champion), resources.getString(string.skills));

        final ViewPager viewPager = findViewById(id.activity_champion_info_viewpager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(id.activity_champion_info_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        this.progressDialog.dismiss();
    }

    @Override
    public void onFailure(int resourceId) {
        Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show();
        this.progressDialog.dismiss();
    }
}
