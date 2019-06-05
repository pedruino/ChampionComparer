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
import android.widget.Toast;

import com.pedruino.championcomparer.adapter.ChampionAdapter;
import com.pedruino.championcomparer.api.ApiClient;
import com.pedruino.championcomparer.api.response.ChampionResponse;
import com.pedruino.championcomparer.api.response.ChampionsResponse;
import com.pedruino.championcomparer.data.Champion;
import com.pedruino.championcomparer.task.LoadAllChampionsTask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ChampionAdapter.OnChampionClickListener, LoadAllChampionsTask.LoadAllChampionsTaskDelegate {
    private List<Champion> dataSource;
    private ChampionAdapter championAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView championRecyclerView = this.findViewById(R.id.activity_main_champion_recycler_view);
        this.dataSource = new ArrayList<>();
        this.championAdapter = new ChampionAdapter(this.dataSource, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        championRecyclerView.setAdapter(this.championAdapter);
        championRecyclerView.setLayoutManager(linearLayoutManager);

        LoadAllChampionsTask task = new LoadAllChampionsTask(this);
        task.execute();

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

        intent.putExtra(ChampionInfoActivity.PARAM_CHAMPION_ID, this.dataSource.get(position).getName());
        intent.putExtra(ChampionInfoActivity.PARAM_CHAMPIONS, (Serializable) this.dataSource);
        startActivity(intent);
    }

    @Override
    public void onSuccess(ChampionsResponse response) {
        this.progressDialog.dismiss();

        Toast.makeText(this, getString(R.string.toast_total_loaded_items, response.getData().size()), Toast.LENGTH_SHORT).show();

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
}