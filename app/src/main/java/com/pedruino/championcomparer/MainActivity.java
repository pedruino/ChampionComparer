package com.pedruino.championcomparer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.pedruino.championcomparer.adapter.ChampionAdapter;
import com.pedruino.championcomparer.api.ApiClient;
import com.pedruino.championcomparer.api.responses.ChampionResponse;
import com.pedruino.championcomparer.api.responses.ChampionsResponse;
import com.pedruino.championcomparer.data.Champion;
import com.pedruino.championcomparer.task.LoadAllChampionsTask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ChampionAdapter.OnChampionClickListener, LoadAllChampionsTask.LoadAllChampionsTaskDelegate, SearchView.OnQueryTextListener {
    private List<Champion> dataSource;
    private ChampionAdapter championAdapter;
    private ProgressDialog progressDialog;
    private SearchView filterSearchView;
    private LoadAllChampionsTask loadAllChampionsTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.filterSearchView = findViewById(R.id.activity_main_filter_search_view);
        RecyclerView championRecyclerView = this.findViewById(R.id.activity_main_champion_recycler_view);

        this.dataSource = new ArrayList<>();
        this.championAdapter = new ChampionAdapter(this.dataSource, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        championRecyclerView.setAdapter(this.championAdapter);
        championRecyclerView.setLayoutManager(linearLayoutManager);

        this.loadAllChampionsTask = new LoadAllChampionsTask(this);
        this.loadAllChampionsTask.execute();

        this.filterSearchView.setOnQueryTextListener(this);
        this.progressDialog = ProgressDialog.show(this, getString(R.string.wait), getResources().getString(R.string.loading));
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onChampionClick(int position) {
        Intent intent = new Intent(this, ChampionInfoActivity.class);

        intent.putExtra(ChampionInfoActivity.PARAM_CHAMPION_ID, this.championAdapter.getDataSource().get(position).getName());
        intent.putExtra(ChampionInfoActivity.PARAM_CHAMPIONS, (Serializable) this.dataSource);
        startActivity(intent);
    }

    @Override
    public void onSuccess(ChampionsResponse response) {
        this.progressDialog.dismiss();

        Toast.makeText(this, getString(R.string.toast_total_loaded_champions, response.getData().size()), Toast.LENGTH_SHORT).show();

        this.dataSource.clear();

        for (ChampionResponse cr : response.getData().values()) {
            Champion champion = new Champion.Builder()
                    .withChampionResponse(cr)
                    .withBaseImageUrl(ApiClient.BASE_URL_IMAGE)
                    .build();

            this.dataSource.add(champion);
        }

        this.championAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(@StringRes int resourceId) {
        Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show();
        this.progressDialog.dismiss();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        List<Champion> filteredChampions = new ArrayList<>();

        for (Champion champion : this.dataSource) {
            if (champion.getName().toLowerCase().startsWith(query.toLowerCase())) {
                filteredChampions.add(champion);
            }
        }

        this.championAdapter.updateDataSource(filteredChampions);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.isEmpty()) {
            this.championAdapter.updateDataSource(this.dataSource);
            return true;
        }
        return false;
    }
}