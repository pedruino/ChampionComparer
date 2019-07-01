package com.pedruino.lolchampionwiki.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsResponse {
    @JsonProperty("hp")
    private int hp;

    @JsonProperty("hpperlevel")
    private int hpperlevel;

    @JsonProperty("mp")
    private int mp;

    @JsonProperty("mpperlevel")
    private int mpperlevel;

    @JsonProperty("movespeed")
    private int movespeed;

    @JsonProperty("armor")
    private int armor;

    @JsonProperty("armorperlevel")
    private double armorperlevel;

    @JsonProperty("spellblock")
    private double spellblock;

    @JsonProperty("spellblockperlevel")
    private double spellblockperlevel;

    @JsonProperty("attackrange")
    private int attackrange;

    @JsonProperty("hpregen")
    private int hpregen;

    @JsonProperty("hpregenperlevel")
    private double hpregenperlevel;

    @JsonProperty("mpregen")
    private int mpregen;

    @JsonProperty("mpregenperlevel")
    private int mpregenperlevel;

    @JsonProperty("crit")
    private int crit;

    @JsonProperty("critperlevel")
    private int critperlevel;

    @JsonProperty("attackdamage")
    private int attackdamage;

    @JsonProperty("attackdamageperlevel")
    private int attackdamageperlevel;

    @JsonProperty("attackspeedperlevel")
    private double attackspeedperlevel;

    @JsonProperty("attackspeed")
    private double attackspeed;

    public StatsResponse() {
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpperlevel() {
        return hpperlevel;
    }

    public void setHpperlevel(int hpperlevel) {
        this.hpperlevel = hpperlevel;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMpperlevel() {
        return mpperlevel;
    }

    public void setMpperlevel(int mpperlevel) {
        this.mpperlevel = mpperlevel;
    }

    public int getMovespeed() {
        return movespeed;
    }

    public void setMovespeed(int movespeed) {
        this.movespeed = movespeed;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public double getArmorperlevel() {
        return armorperlevel;
    }

    public void setArmorperlevel(double armorperlevel) {
        this.armorperlevel = armorperlevel;
    }

    public double getSpellblock() {
        return spellblock;
    }

    public void setSpellblock(double spellblock) {
        this.spellblock = spellblock;
    }

    public double getSpellblockperlevel() {
        return spellblockperlevel;
    }

    public void setSpellblockperlevel(double spellblockperlevel) {
        this.spellblockperlevel = spellblockperlevel;
    }

    public int getAttackrange() {
        return attackrange;
    }

    public void setAttackrange(int attackrange) {
        this.attackrange = attackrange;
    }

    public int getHpregen() {
        return hpregen;
    }

    public void setHpregen(int hpregen) {
        this.hpregen = hpregen;
    }

    public double getHpregenperlevel() {
        return hpregenperlevel;
    }

    public void setHpregenperlevel(double hpregenperlevel) {
        this.hpregenperlevel = hpregenperlevel;
    }

    public int getMpregen() {
        return mpregen;
    }

    public void setMpregen(int mpregen) {
        this.mpregen = mpregen;
    }

    public int getMpregenperlevel() {
        return mpregenperlevel;
    }

    public void setMpregenperlevel(int mpregenperlevel) {
        this.mpregenperlevel = mpregenperlevel;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getCritperlevel() {
        return critperlevel;
    }

    public void setCritperlevel(int critperlevel) {
        this.critperlevel = critperlevel;
    }

    public int getAttackdamage() {
        return attackdamage;
    }

    public void setAttackdamage(int attackdamage) {
        this.attackdamage = attackdamage;
    }

    public int getAttackdamageperlevel() {
        return attackdamageperlevel;
    }

    public void setAttackdamageperlevel(int attackdamageperlevel) {
        this.attackdamageperlevel = attackdamageperlevel;
    }

    public double getAttackspeedperlevel() {
        return attackspeedperlevel;
    }

    public void setAttackspeedperlevel(double attackspeedperlevel) {
        this.attackspeedperlevel = attackspeedperlevel;
    }

    public double getAttackspeed() {
        return attackspeed;
    }

    public void setAttackspeed(double attackspeed) {
        this.attackspeed = attackspeed;
    }
}
