package com.pedruino.championcomparer.data;

import com.pedruino.championcomparer.api.ApiClient;
import com.pedruino.championcomparer.api.response.ChampionResponse;
import com.pedruino.championcomparer.api.response.PassiveResponse;
import com.pedruino.championcomparer.api.response.SkinResponse;
import com.pedruino.championcomparer.api.response.SpellResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Champion implements Serializable {
    private String name;
    private String title;
    private String lore;
    private String imagePath;
    private Info info;
    private List<Skin> skins;
    private List<Ability> abilities;


    public Champion(String name, String title, String lore, String image, Info info, List<Ability> abilities, List<Skin> skins) {
        this.name = name;
        this.title = title;
        this.lore = lore;
        this.imagePath = image;
        this.info = info;
        this.abilities = abilities;
        this.skins = skins;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getLore() {
        return lore;
    }

    public Info getInfo() {
        return info;
    }

    public List<Ability> getAbilities() {
        return this.abilities;
    }

    public List<Skin> getSkins() {
        return skins;
    }

    public static abstract class Ability implements Serializable {
        private String name;
        private String description;
        private String imagePath;

        Ability(String name, String description, String image) {
            this.name = name;
            this.description = description;
            this.imagePath = image;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getImagePath() {
            return imagePath;
        }
    }

    public static final class Passive extends Ability {

        Passive(String name, String description, String image) {
            super(name, description, image);
        }
    }

    public static final class Spell extends Ability {
        private String cost;
        private String cooldown;
        private String tooltip;

        Spell(String name, String cost, String cooldown, String description, String tooltip, String image) {
            super(name, description, image);
            this.cost = cost;
            this.cooldown = cooldown;
            this.tooltip = tooltip;
        }

        public String getCost() {
            return cost;
        }

        public String getCooldown() {
            return cooldown;
        }

        public String getTooltip() {
            return tooltip;
        }
    }

    public static final class Skin implements Serializable {
        private String id;
        private String name;
        private String num;
        private String imagePath;

        public Skin(String id, String name, String num, String imagePath) {
            this.id = id;
            this.name = name;
            this.num = num;
            this.imagePath = imagePath;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getNum() {
            return num;
        }

        public String getImagePath() {
            return this.imagePath;
        }
    }

    public static final class Info implements Serializable {
        private int mobility;
        private int attack;
        private int defense;
        private int magic;
        private int difficulty;

        Info(int attack, int defense, int magic, int difficulty, int mobility) {
            this.attack = attack;
            this.defense = defense;
            this.magic = magic;
            this.difficulty = difficulty;
            this.mobility = mobility;
        }

        public int getAttack() {
            return attack;
        }

        public int getDefense() {
            return defense;
        }

        public int getMagic() {
            return magic;
        }

        public int getDifficulty() {
            return difficulty;
        }

        public int getMobility() {
            return mobility;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this.getName().equals(((Champion) obj).getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public static final class Builder {
        private static final float MAX_SPEED = 400.0f;
        private ChampionResponse championResponse;
        private String baseUrlImage;
        private Info info;
        private List<Skin> skins = new ArrayList<>();
        private List<Ability> abilities = new ArrayList<>();

        public Builder() {
        }

        public Builder withChampionResponse(ChampionResponse championResponse) {
            this.championResponse = championResponse;
            return this;
        }

        public Builder withBaseImageUrl(String baseUrlImage) {
            this.baseUrlImage = baseUrlImage;
            return this;
        }

        public Champion build() {

            if (this.championResponse.getInfo() != null) {
                this.info = new Info(this.championResponse.getInfo().getAttack(),
                        this.championResponse.getInfo().getDefense(),
                        this.championResponse.getInfo().getMagic(),
                        this.championResponse.getInfo().getDifficulty(),
                        Math.round(this.championResponse.getStats().getMovespeed() / MAX_SPEED * 10));
            } else {
                this.info = new Info(0, 0, 0, 0, 0);
            }

            if (this.championResponse.getPassive() != null) {
                String path = String.format("%s/img/passive/", ApiClient.VERSION);
                PassiveResponse pr = this.championResponse.getPassive();
                this.abilities.add(
                        new Champion.Passive(
                                pr.getName(),
                                pr.getDescription(),
                                this.baseUrlImage + path + pr.getImage().getFull()));
            }

            if (this.championResponse.getSpells() != null) {
                String path = String.format("%s/img/spell/", ApiClient.VERSION);
                for (SpellResponse sr : this.championResponse.getSpells()) {

                    this.abilities.add(
                            new Champion.Spell(
                                    sr.getName(),
                                    sr.getCostBurn(),
                                    sr.getCooldownBurn(),
                                    sr.getDescription(),
                                    sr.getTooltip(),
                                    this.baseUrlImage + path + sr.getImage().getFull()));
                }
            }

            if (this.championResponse.getSkins() != null) {
                String path = "img/champion/loading/";
                for (SkinResponse sr : this.championResponse.getSkins()) {

                    this.skins.add(new Champion.Skin(sr.getId(), sr.getName(), sr.getNum(),
                            this.baseUrlImage + path + this.championResponse.getId() + "_" + sr.getNum() + ".jpg"));
                }
            }

            return new Champion(this.championResponse.getName(),
                    this.championResponse.getTitle(),
                    this.championResponse.getLore(),
                    String.format("%s%s", this.baseUrlImage, this.championResponse.getImage().getFull()),
                    this.info,
                    this.abilities,
                    this.skins);
        }
    }
}
