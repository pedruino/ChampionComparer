package com.pedruino.championcomparer.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.appl.library.CoverFlowCarousel;
import com.pedruino.championcomparer.ChampionInfoActivity;
import com.pedruino.championcomparer.R;
import com.pedruino.championcomparer.data.Champion;
import com.squareup.picasso.Picasso;


public class TabChampionOverview extends Fragment {
    private TextView nameTextView;
    private TextView titleTextView;
    private TextView loreTextView;
    private Champion champion;
    CoverFlowCarousel skinsCoverFlowCarousel;
    private TextView tagsTextView;
    private ListView allyTipsListView;
    private ListView enemyTipsListView;

    public static TabChampionOverview newInstance(Champion champion) {
        TabChampionOverview fragment = new TabChampionOverview();
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_champion_overview, container, false);
        this.nameTextView = fragmentView.findViewById(R.id.fragment_champion_overview_name_text_view);
        this.titleTextView = fragmentView.findViewById(R.id.fragment_champion_overview_title_text_view);
        this.loreTextView = fragmentView.findViewById(R.id.fragment_champion_overview_lore_text_view);
        this.tagsTextView = fragmentView.findViewById(R.id.fragment_champion_overview_tags_text_view);
        this.allyTipsListView = fragmentView.findViewById(R.id.fragment_champion_overview_ally_tips_list_view);
        this.enemyTipsListView = fragmentView.findViewById(R.id.fragment_champion_overview_enemy_tips_list_view);


        if (this.champion != null) {
            this.nameTextView.setText(this.champion.getName());
            this.titleTextView.setText(this.champion.getTitle());
            this.loreTextView.setText(this.champion.getLore());

            StringBuilder tags = new StringBuilder();
            for (String tag : this.champion.getTags()) {
                tags.append(tag);
                tags.append(", ");
            }

            if (tags.lastIndexOf(", ") == tags.length() - 2) {
                tags.replace(tags.length() - 2, tags.length(), "");
            }

            this.tagsTextView.setText(tags.toString());

            ArrayAdapter<String> allyTipsAdapter = new ArrayAdapter<>(fragmentView.getContext(), R.layout.simple_list_item, this.champion.getAllyTips());
            this.allyTipsListView.setAdapter(allyTipsAdapter);

            ArrayAdapter<String> enemyTipsAdapter = new ArrayAdapter<>(fragmentView.getContext(), R.layout.simple_list_item, this.champion.getEnemyTips());
            this.enemyTipsListView.setAdapter(enemyTipsAdapter);

            int totalSkins = this.champion.getSkins().size();
            String[] resourceUris = new String[totalSkins];
            for (int i = 0; i < totalSkins; i++) {
                resourceUris[i] = this.champion.getSkins().get(i).getImagePath();
            }

            final CarouselAdapter adapter = new CarouselAdapter(resourceUris);
            this.skinsCoverFlowCarousel = fragmentView.findViewById(R.id.fragment_champion_overview_skins_cover_flow_carousel);
            this.skinsCoverFlowCarousel.setAdapter(adapter);
            this.skinsCoverFlowCarousel.setSelection(adapter.getCount() / 2);
            this.skinsCoverFlowCarousel.setSlowDownCoefficient(1);
            this.skinsCoverFlowCarousel.setSpacing(0.5f);
            this.skinsCoverFlowCarousel.setRotationThreshold(0.3f);
            this.skinsCoverFlowCarousel.shouldRepeat(false);
        }

        return fragmentView;
    }


    private class CarouselAdapter extends BaseAdapter {
        private String[] resourceUris;

        private CarouselAdapter(String[] resourceUris) {
            this.resourceUris = resourceUris;
        }

        @Override
        public int getCount() {
            return resourceUris.length;
        }

        @Override
        public Object getItem(int position) {
            return resourceUris[position % resourceUris.length];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            TabChampionOverview.SkinFrameLayout v;
            if (convertView == null) {
                v = new TabChampionOverview.SkinFrameLayout(TabChampionOverview.this.getContext());
            } else {
                v = (TabChampionOverview.SkinFrameLayout) convertView;
            }

            v.setImageResource(resourceUris[position]);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    skinsCoverFlowCarousel.scrollToItemPosition(position);
                    Toast.makeText(v.getContext(), champion.getSkins().get(position).getName(), Toast.LENGTH_SHORT).show();
                }
            });

            return v;
        }
    }

    private static class SkinFrameLayout extends FrameLayout {
        private ImageView imageView;

        public void setImageResource(String resId) {
            Picasso.with(this.imageView.getContext()).load(resId).into(this.imageView);
        }

        public SkinFrameLayout(Context context) {
            super(context);

            this.imageView = new ImageView(context);
            this.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.addView(this.imageView);

            setBackgroundColor(Color.WHITE);
            setSelected(false);
        }

        @Override
        public void setSelected(boolean selected) {
            super.setSelected(selected);

            if (selected) {
                this.imageView.setAlpha(1.0f);
            } else {
                this.imageView.setAlpha(0.5f);
            }
        }
    }
}
