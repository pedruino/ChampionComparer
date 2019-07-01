package com.pedruino.championcomparer.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkinResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("num")
    private String num;

    public SkinResponse(){
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}

