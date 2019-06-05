package com.pedruino.championcomparer.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pedruino.championcomparer.R;
import com.pedruino.championcomparer.data.Champion;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ChampionAdapter extends RecyclerView.Adapter<ChampionAdapter.ChampionViewHolder> {
    private List<Champion> dataSource;
    private OnChampionClickListener onChampionClickListener;

    public ChampionAdapter(List<Champion> dataSource, OnChampionClickListener onChampionClickListener) {
        this.dataSource = dataSource;
        this.onChampionClickListener = onChampionClickListener;
    }

    @NonNull
    @Override
    public ChampionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.row_champion, viewGroup, false);
        return new ChampionViewHolder(view, this.onChampionClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final ChampionViewHolder championViewHolder, int i) {
        championViewHolder.fillChampion(this.dataSource.get(i));
    }

    @Override
    public int getItemCount() {
        return this.dataSource.size();
    }

    public final static class ChampionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameTextView;
        private TextView titleTextView;
        private ImageView thumbImageView;
        private OnChampionClickListener onChampionClickListener;

        ChampionViewHolder(@NonNull View itemView, OnChampionClickListener onChampionClickListener) {
            super(itemView);
            this.nameTextView = itemView.findViewById(R.id.row_champion_name_text_view);
            this.titleTextView = itemView.findViewById(R.id.row_champion_title_text_view);
            this.thumbImageView = itemView.findViewById(R.id.row_champion_image_image_view);
            this.onChampionClickListener = onChampionClickListener;
            this.itemView.setOnClickListener(this);
        }

        private void fillChampion(Champion champion) {
            this.nameTextView.setText(champion.getName());
            this.titleTextView.setText(champion.getTitle());
            this.thumbImageView.setImageDrawable(null);
            Picasso.with(this.thumbImageView.getContext()).load(champion.getImagePath()).into(this.thumbImageView);
            //thumbImageView.setImageResource(ResourceHelper.findResourceIdByName(itemView, champion.getImagePath()));
        }

        @Override
        public void onClick(View v) {
            onChampionClickListener.onChampionClick(getAdapterPosition());
        }
    }

    public interface OnChampionClickListener {
        void onChampionClick(int position);
    }
}
