package com.pedruino.championcomparer;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.pedruino.championcomparer.adapter.TabsAdapter;
import com.pedruino.championcomparer.data.Champion;
import com.pedruino.championcomparer.fragments.TabChampionOverview;
import com.pedruino.championcomparer.fragments.TabChampionAbilities;
import com.pedruino.championcomparer.fragments.TabChampionStats;

import java.util.ArrayList;

public class ChampionInfoActivity extends AppCompatActivity {
    public static final String PARAM_CHAMPION = "champion";
    public static final String PARAM_CHAMPIONS = "champions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_info);

        Intent intent = getIntent();
        Champion champion = (Champion) intent.getSerializableExtra(PARAM_CHAMPION);
        ArrayList<Champion> champions = (ArrayList<Champion>) intent.getSerializableExtra(PARAM_CHAMPIONS);

        Resources resources = getResources();
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());

        adapter.add(TabChampionOverview.newInstance(champion), resources.getString(R.string.overview));
        adapter.add(TabChampionStats.newInstance(champion, champions), resources.getString(R.string.stats));
        adapter.add(TabChampionAbilities.newInstance(champion), resources.getString(R.string.skills));

        final ViewPager viewPager = findViewById(R.id.activity_champion_info_viewpager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.activity_champion_info_tab_layout);
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
    }
}
