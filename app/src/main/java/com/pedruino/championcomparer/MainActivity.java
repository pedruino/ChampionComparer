package com.pedruino.championcomparer;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pedruino.championcomparer.adapter.ChampionAdapter;
import com.pedruino.championcomparer.data.Champion;
import com.pedruino.championcomparer.data.ChampionDataSourceHelper;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ChampionAdapter.OnChampionClickListener {
    private RecyclerView championRecyclerView;
    private List<Champion> dataSource;
    private ChampionAdapter championAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        championRecyclerView = this.findViewById(R.id.activity_main_champion_recycler_view);
        ChampionDataSourceHelper helper = new ChampionDataSourceHelper();
        this.dataSource = helper.getDataSource();
        this.championAdapter = new ChampionAdapter(this.dataSource, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        this.championRecyclerView.setAdapter(this.championAdapter);
        this.championRecyclerView.setLayoutManager(linearLayoutManager);
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
        intent.putExtra(ChampionInfoActivity.PARAM_CHAMPION, this.dataSource.get(position));
        intent.putExtra(ChampionInfoActivity.PARAM_CHAMPIONS, (Serializable) this.dataSource);
        startActivity(intent);
    }
}