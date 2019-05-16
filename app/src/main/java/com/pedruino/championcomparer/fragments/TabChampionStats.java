package com.pedruino.championcomparer.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.pedruino.championcomparer.ChampionInfoActivity;
import com.pedruino.championcomparer.R;
import com.pedruino.championcomparer.data.Champion;

import java.util.ArrayList;
import java.util.List;

public class TabChampionStats extends Fragment {
    private Champion champion;
    private RadarChart championInfoRadarChart;
    private Spinner championSpinner;
    private List<Champion> champions;
    private ArrayList<IRadarDataSet> dataSets;

    public static TabChampionStats newInstance(Champion champion, ArrayList<Champion> champions) {
        TabChampionStats fragment = new TabChampionStats();
        Bundle args = new Bundle();
        args.putSerializable(ChampionInfoActivity.PARAM_CHAMPION, champion);
        args.putSerializable(ChampionInfoActivity.PARAM_CHAMPIONS, champions);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.champion = (Champion) getArguments().getSerializable(ChampionInfoActivity.PARAM_CHAMPION);

            this.champions = (List<Champion>) getArguments().getSerializable(ChampionInfoActivity.PARAM_CHAMPIONS);
            this.champions.remove(this.champion);

            this.dataSets = new ArrayList<>();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_champion_stats, container, false);

        this.championSpinner = fragmentView.findViewById(R.id.fragment_champion_stats_champion_spinner);
        this.championSpinner.setAdapter(new ArrayAdapter<>(fragmentView.getContext(), android.R.layout.simple_spinner_dropdown_item, this.champions));


        this.championSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (selectedItemView != null) {
                    if (dataSets.size() > 1) {
                        dataSets.remove(1);
                    }

                    dataSets.add(createDataSetFromChampion(champions.get(position), Color.CYAN, Color.CYAN));
                    championInfoRadarChart.animateXY(1400, 1400, Easing.EaseInOutQuad);
                    championInfoRadarChart.getYAxis().setAxisMaximum(8f);
                    championInfoRadarChart.getData().setDrawValues(false);
                    championInfoRadarChart.notifyDataSetChanged();
                    championInfoRadarChart.invalidate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        this.championSpinner.setEnabled(false);

        this.championInfoRadarChart = fragmentView.findViewById(R.id.fragment_champion_stats_info_radar_chart);
        this.championInfoRadarChart.getDescription().setEnabled(false);
        this.championInfoRadarChart.setWebLineWidth(1f);
        this.championInfoRadarChart.setWebColor(Color.LTGRAY);
        this.championInfoRadarChart.setWebLineWidthInner(1f);
        this.championInfoRadarChart.setWebColorInner(Color.LTGRAY);
        this.championInfoRadarChart.setWebAlpha(100);

        if (this.champion != null) {
            this.dataSets.add(createDataSetFromChampion(this.champion, Color.rgb(121, 162, 175), Color.rgb(121, 162, 175)));

            RadarData data = new RadarData(this.dataSets);
            data.setValueTextSize(8f);
            data.setDrawValues(false);
            data.setValueTextColor(Color.DKGRAY);

            this.championInfoRadarChart.setData(data);
            this.championInfoRadarChart.invalidate();
        }

        this.championInfoRadarChart.animateXY(1400, 1400, Easing.EaseInOutQuad);

        XAxis xAxis = this.championInfoRadarChart.getXAxis();
        xAxis.setTextSize(9f);
        xAxis.setYOffset(0f);
        xAxis.setXOffset(0f);
        xAxis.setValueFormatter(new ValueFormatter() {

            private final String[] attributes = new String[]{"Attack", "Defense", "Magic", "Difficulty", "Mobility"};

            @Override
            public String getFormattedValue(float value) {
                return attributes[(int) value % attributes.length];
            }
        });

        xAxis.setTextColor(Color.DKGRAY);

        YAxis yAxis = this.championInfoRadarChart.getYAxis();
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(9f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(8f);
        yAxis.setDrawLabels(false);

        Legend l = this.championInfoRadarChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        //l.setTypeface(tfLight);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setTextColor(Color.DKGRAY);

        this.championSpinner.setEnabled(true);
        return fragmentView;
    }

    private IRadarDataSet createDataSetFromChampion(Champion champion, int edgeColor, int fillColor) {
        ArrayList<RadarEntry> entries = new ArrayList<>();
        entries.add(new RadarEntry(champion.getInfo().getAttack()));
        entries.add(new RadarEntry(champion.getInfo().getDefense()));
        entries.add(new RadarEntry(champion.getInfo().getMagic()));
        entries.add(new RadarEntry(champion.getInfo().getDifficulty()));
        entries.add(new RadarEntry(champion.getInfo().getMobility()));

        RadarDataSet set = new RadarDataSet(entries, champion.getName());
        set.setColor(edgeColor);
        set.setFillColor(fillColor);
        set.setDrawFilled(true);
        set.setFillAlpha(180);
        set.setLineWidth(2f);
        set.setDrawHighlightCircleEnabled(true);
        set.setDrawHighlightIndicators(false);

        return set;
    }
}
