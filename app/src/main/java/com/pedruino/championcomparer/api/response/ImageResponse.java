package com.pedruino.championcomparer.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageResponse {
    @JsonProperty("full")
    private String full;

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }
}
