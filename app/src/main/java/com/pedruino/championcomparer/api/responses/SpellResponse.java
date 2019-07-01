package com.pedruino.championcomparer.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpellResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tooltip")
    private String tooltip;

    @JsonProperty("cooldownBurn")
    private String cooldownBurn;

    @JsonProperty("costBurn")
    private String costBurn;

    @JsonProperty("costType")
    private String costType;

    @JsonProperty("image")
    private ImageResponse image;

    public SpellResponse(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getCooldownBurn() {
        return cooldownBurn;
    }

    public void setCooldownBurn(String cooldownBurn) {
        this.cooldownBurn = cooldownBurn;
    }

    public String getCostBurn() {
        return costBurn;
    }

    public void setCostBurn(String costBurn) {
        this.costBurn = costBurn;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public ImageResponse getImage() {
        return image;
    }

    public void setImage(ImageResponse image) {
        this.image = image;
    }
}
