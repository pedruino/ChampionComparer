package com.pedruino.lolchampionwiki.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChampionResponse {
    @JsonProperty("version")
    private String version;

    @JsonProperty("id")
    private String id;

    @JsonProperty("key")
    private String key;

    @JsonProperty("name")
    private String name;

    @JsonProperty("title")
    private String title;

    @JsonProperty("blurb")
    private String blurb;

    @JsonProperty("lore")
    private String lore;

    @JsonProperty("allytips")
    private List<String> allytips;

    @JsonProperty("enemytips")
    private List<String> enemytips;

    @JsonProperty("info")
    private InfoResponse info;

    @JsonProperty("image")
    private ImageResponse image;

    @JsonProperty("skins")
    private List<SkinResponse> skins;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("partype")
    private String partype;

    @JsonProperty("stats")
    private StatsResponse stats;

    @JsonProperty("spells")
    private List<SpellResponse> spells;

    @JsonProperty("passive")
    private PassiveResponse passive;

    public ChampionResponse() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public InfoResponse getInfo() {
        return info;
    }

    public void setInfo(InfoResponse info) {
        this.info = info;
    }

    public ImageResponse getImage() {
        return image;
    }

    public void setImage(ImageResponse image) {
        this.image = image;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getPartype() {
        return partype;
    }

    public void setPartype(String partype) {
        this.partype = partype;
    }

    public StatsResponse getStats() {
        return stats;
    }

    public void setStats(StatsResponse stats) {
        this.stats = stats;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public List<String> getAllytips() {
        return allytips;
    }

    public void setAllytips(List<String> allytips) {
        this.allytips = allytips;
    }

    public List<String> getEnemytips() {
        return enemytips;
    }

    public void setEnemytips(List<String> enemytips) {
        this.enemytips = enemytips;
    }

    public List<SpellResponse> getSpells() {
        return spells;
    }

    public void setSpells(List<SpellResponse> spells) {
        this.spells = spells;
    }

    public PassiveResponse getPassive() {
        return passive;
    }

    public void setPassive(PassiveResponse passive) {
        this.passive = passive;
    }

    public List<SkinResponse> getSkins() {
        return skins;
    }

    public void setSkins(List<SkinResponse> skins) {
        this.skins = skins;
    }
}
