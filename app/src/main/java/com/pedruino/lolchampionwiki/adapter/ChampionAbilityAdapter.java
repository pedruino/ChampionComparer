package com.pedruino.lolchampionwiki.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pedruino.lolchampionwiki.R;
import com.pedruino.lolchampionwiki.data.Champion;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChampionAbilityAdapter extends RecyclerView.Adapter<ChampionAbilityAdapter.ChampionAbilityViewHolder> {
    private static final int VIEW_TYPE_PASSIVE = 1;
    private static final int VIEW_TYPE_SPELL = 2;
    private List<Champion.Ability> dataSource;

    public ChampionAbilityAdapter(List<Champion.Ability> dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public ChampionAbilityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        if (viewType == VIEW_TYPE_PASSIVE) {
            View view = layoutInflater.inflate(R.layout.row_champion_passive, viewGroup, false);
            return new ChampionPassiveViewHolder(view);
        } else {
            View view = layoutInflater.inflate(R.layout.row_champion_spell, viewGroup, false);
            return new ChampionSpellViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ChampionAbilityViewHolder championAbilityViewHolder, int i) {
        championAbilityViewHolder.fillChampionAbility(this.dataSource.get(i));
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_PASSIVE;
        } else {
            return VIEW_TYPE_SPELL;
        }
    }

    @Override
    public int getItemCount() {
        return this.dataSource.size();
    }


    public static abstract class ChampionAbilityViewHolder<Tability extends Champion.Ability> extends RecyclerView.ViewHolder {

        ChampionAbilityViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public abstract void fillChampionAbility(Tability ability);
    }

    public final static class ChampionSpellViewHolder extends ChampionAbilityViewHolder<Champion.Spell> {
        private TextView nameTextView;
        private TextView costTextView;
        private TextView cooldownTextView;
        private TextView descriptionTextView;
        private ImageView imageImageView;

        ChampionSpellViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nameTextView = itemView.findViewById(R.id.row_champion_spell_name_text_view);
            this.costTextView = itemView.findViewById(R.id.row_champion_spell_cost_text_view);
            this.cooldownTextView = itemView.findViewById(R.id.row_champion_spell_cooldown_text_view);
            this.descriptionTextView = itemView.findViewById(R.id.row_champion_spell_description_text_view);
            this.imageImageView = itemView.findViewById(R.id.row_champion_spell_image_image_view);
        }

        @Override
        public void fillChampionAbility(Champion.Spell ability) {
            this.nameTextView.setText(ability.getName());
            this.costTextView.setText(itemView.getResources().getString(R.string.mana_cost, ability.getCost()));
            this.cooldownTextView.setText(itemView.getResources().getString(R.string.cooldown, ability.getCooldown()));
            this.descriptionTextView.setText(ability.getDescription());
            Picasso.with(this.imageImageView.getContext()).load(ability.getImagePath()).into(this.imageImageView);
        }
    }

    public final static class ChampionPassiveViewHolder extends ChampionAbilityViewHolder<Champion.Passive> {
        private TextView nameTextView;
        private TextView descriptionTextView;
        private ImageView imageImageView;

        ChampionPassiveViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nameTextView = itemView.findViewById(R.id.row_champion_passive_name_text_view);
            this.descriptionTextView = itemView.findViewById(R.id.row_champion_passive_description_text_view);
            this.imageImageView = itemView.findViewById(R.id.row_champion_passive_image_image_view);
        }

        @Override
        public void fillChampionAbility(Champion.Passive ability) {
            this.nameTextView.setText(ability.getName());
            this.descriptionTextView.setText(ability.getDescription());
            Picasso.with(this.imageImageView.getContext()).load(ability.getImagePath()).into(this.imageImageView);
        }
    }
}
