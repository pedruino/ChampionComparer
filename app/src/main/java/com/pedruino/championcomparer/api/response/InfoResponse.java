package com.pedruino.championcomparer.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoResponse {
    @JsonProperty("attack")
    private long attack;

    @JsonProperty("defense")
    private long defense;

    @JsonProperty("magic")
    private long magic;

    @JsonProperty("difficulty")
    private long difficulty;

    public InfoResponse() {

    }

    public long getAttack() {
        return attack;
    }

    public void setAttack(long attack) {
        this.attack = attack;
    }

    public long getDefense() {
        return defense;
    }

    public void setDefense(long defense) {
        this.defense = defense;
    }

    public long getMagic() {
        return magic;
    }

    public void setMagic(long magic) {
        this.magic = magic;
    }

    public long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(long difficulty) {
        this.difficulty = difficulty;
    }
}
