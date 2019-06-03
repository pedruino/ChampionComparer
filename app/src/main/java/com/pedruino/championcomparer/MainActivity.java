package com.pedruino.championcomparer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.pedruino.championcomparer.adapter.ChampionAdapter;
import com.pedruino.championcomparer.api.response.ChampionResponse;
import com.pedruino.championcomparer.api.response.ChampionsResponse;
import com.pedruino.championcomparer.data.ChampionDataSourceHelper;
import com.pedruino.championcomparer.task.LoadChampionsTask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ChampionAdapter.OnChampionClickListener, LoadChampionsTask.LoadChampionsTaskDelegate {
    private RecyclerView championRecyclerView;
    private List<ChampionResponse> dataSource;
    private ChampionAdapter championAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        championRecyclerView = this.findViewById(R.id.activity_main_champion_recycler_view);
        ChampionDataSourceHelper helper = new ChampionDataSourceHelper();
        this.dataSource = new ArrayList<>();//helper.getDataSource();
        this.championAdapter = new ChampionAdapter(this.dataSource, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        this.championRecyclerView.setAdapter(this.championAdapter);
        this.championRecyclerView.setLayoutManager(linearLayoutManager);

        LoadChampionsTask task = new LoadChampionsTask(this);
        task.execute();

        this.progressDialog = ProgressDialog.show(this, getResources().getString(R.string.wait), getResources().getString(R.string.loading));
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

        //TODO: Implement api call

        //intent.putExtra(ChampionInfoActivity.PARAM_CHAMPION, this.dataSource.get(position));
        intent.putExtra(ChampionInfoActivity.PARAM_CHAMPIONS, (Serializable) this.dataSource);
        startActivity(intent);
    }

    @Override
    public void onSuccess(ChampionsResponse response) {
        progressDialog.dismiss();

        Toast.makeText(this, "Foram carregados " + response.getData().size(), Toast.LENGTH_SHORT).show();

        this.dataSource.clear();

        this.dataSource.addAll(response.getData().values());
        this.championAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String message) {
        this.progressDialog.dismiss();
    }
}