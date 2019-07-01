package com.pedruino.lolchampionwiki.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ChampionsResponse {
    @JsonProperty("version")
    private String version;

    @JsonProperty("data")
    private Map<String, ChampionResponse> data;

    public ChampionsResponse() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

    public Map<String, ChampionResponse> getData() {
        return data;
    }

    public void setData(Map<String, ChampionResponse> value) {
        this.data = value;
    }
}

