package com.pedruino.championcomparer.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsResponse {
    @JsonProperty("hp")
    private long hp;

    @JsonProperty("hpperlevel")
    private long hpperlevel;

    @JsonProperty("mp")
    private long mp;

    @JsonProperty("mpperlevel")
    private long mpperlevel;

    @JsonProperty("movespeed")
    private long movespeed;

    @JsonProperty("armor")
    private long armor;

    @JsonProperty("armorperlevel")
    private double armorperlevel;

    @JsonProperty("spellblock")
    private double spellblock;

    @JsonProperty("spellblockperlevel")
    private double spellblockperlevel;

    @JsonProperty("attackrange")
    private long attackrange;

    @JsonProperty("hpregen")
    private long hpregen;

    @JsonProperty("hpregenperlevel")
    private double hpregenperlevel;

    @JsonProperty("mpregen")
    private long mpregen;

    @JsonProperty("mpregenperlevel")
    private long mpregenperlevel;

    @JsonProperty("crit")
    private long crit;

    @JsonProperty("critperlevel")
    private long critperlevel;

    @JsonProperty("attackdamage")
    private long attackdamage;

    @JsonProperty("attackdamageperlevel")
    private long attackdamageperlevel;

    @JsonProperty("attackspeedperlevel")
    private double attackspeedperlevel;

    @JsonProperty("attackspeed")
    private double attackspeed;

    public StatsResponse() {
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getHpperlevel() {
        return hpperlevel;
    }

    public void setHpperlevel(long hpperlevel) {
        this.hpperlevel = hpperlevel;
    }

    public long getMp() {
        return mp;
    }

    public void setMp(long mp) {
        this.mp = mp;
    }

    public long getMpperlevel() {
        return mpperlevel;
    }

    public void setMpperlevel(long mpperlevel) {
        this.mpperlevel = mpperlevel;
    }

    public long getMovespeed() {
        return movespeed;
    }

    public void setMovespeed(long movespeed) {
        this.movespeed = movespeed;
    }

    public long getArmor() {
        return armor;
    }

    public void setArmor(long armor) {
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

    public long getAttackrange() {
        return attackrange;
    }

    public void setAttackrange(long attackrange) {
        this.attackrange = attackrange;
    }

    public long getHpregen() {
        return hpregen;
    }

    public void setHpregen(long hpregen) {
        this.hpregen = hpregen;
    }

    public double getHpregenperlevel() {
        return hpregenperlevel;
    }

    public void setHpregenperlevel(double hpregenperlevel) {
        this.hpregenperlevel = hpregenperlevel;
    }

    public long getMpregen() {
        return mpregen;
    }

    public void setMpregen(long mpregen) {
        this.mpregen = mpregen;
    }

    public long getMpregenperlevel() {
        return mpregenperlevel;
    }

    public void setMpregenperlevel(long mpregenperlevel) {
        this.mpregenperlevel = mpregenperlevel;
    }

    public long getCrit() {
        return crit;
    }

    public void setCrit(long crit) {
        this.crit = crit;
    }

    public long getCritperlevel() {
        return critperlevel;
    }

    public void setCritperlevel(long critperlevel) {
        this.critperlevel = critperlevel;
    }

    public long getAttackdamage() {
        return attackdamage;
    }

    public void setAttackdamage(long attackdamage) {
        this.attackdamage = attackdamage;
    }

    public long getAttackdamageperlevel() {
        return attackdamageperlevel;
    }

    public void setAttackdamageperlevel(long attackdamageperlevel) {
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
