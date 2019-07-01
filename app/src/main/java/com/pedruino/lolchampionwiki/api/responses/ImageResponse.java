package com.pedruino.lolchampionwiki.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageResponse {
    @JsonProperty("full")
    private String full;

    @JsonProperty("group")
    private String group;

    public ImageResponse() {
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
