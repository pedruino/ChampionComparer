package com.pedruino.championcomparer.data;

import java.io.Serializable;
import java.util.List;

public class Champion implements Serializable {
    private String name;
    private String title;
    private String lore;
    private String image;
    private Info info;
    private List<Skin> skins;
    private List<Ability> abilities;


    public Champion(String name, String title, String lore, String image, Info info, List<Ability> abilities, List<Skin> skins) {
        this.name = name;
        this.title = title;
        this.lore = lore;
        this.image = image;
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

    public String getImage() {
        return image;
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
        private String image;

        protected Ability(String name, String description, String image) {
            this.name = name;
            this.description = description;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getImage() {
            return image;
        }
    }

    public static final class Passive extends Ability {

        protected Passive(String name, String description, String image) {
            super(name, description, image);
        }
    }

    public static final class Spell extends Ability {
        private String cost;
        private String cooldown;
        private String tooltip;

        public Spell(String name, String cost, String cooldown, String description, String tooltip, String image) {
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
        private String name;

        public Skin(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static final class Info implements Serializable {
        private int mobility;
        private int attack;
        private int defense;
        private int magic;
        private int difficulty;

        public Info(int attack, int defense, int magic, int difficulty, int mobility) {
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
}
