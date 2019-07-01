package com.pedruino.lolchampionwiki.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedruino.lolchampionwiki.ChampionInfoActivity;
import com.pedruino.lolchampionwiki.R;
import com.pedruino.lolchampionwiki.adapter.ChampionAbilityAdapter;
import com.pedruino.lolchampionwiki.data.Champion;


public class TabChampionAbilities extends Fragment {
    private Champion champion;
    private RecyclerView abilitiesRecyclerView;
    private ChampionAbilityAdapter championAbilityAdapter;

    public static TabChampionAbilities newInstance(Champion champion) {
        TabChampionAbilities fragment = new TabChampionAbilities();
        Bundle args = new Bundle();
        args.putSerializable(ChampionInfoActivity.PARAM_CHAMPION, champion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.champion = (Champion) getArguments().getSerializable(ChampionInfoActivity.PARAM_CHAMPION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_champion_abilities, container, false);
        this.abilitiesRecyclerView = fragmentView.findViewById(R.id.fragment_champion_abilities_recycler_view);

        if (this.champion != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(fragmentView.getContext());

            this.championAbilityAdapter = new ChampionAbilityAdapter(this.champion.getAbilities());
            this.abilitiesRecyclerView.setAdapter(this.championAbilityAdapter);
            this.abilitiesRecyclerView.setLayoutManager(linearLayoutManager);
        }

        return fragmentView;
    }
}
