package com.pedruino.lolchampionwiki.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoResponse {
    @JsonProperty("attack")
    private int attack;

    @JsonProperty("defense")
    private int defense;

    @JsonProperty("magic")
    private int magic;

    @JsonProperty("difficulty")
    private int difficulty;

    public InfoResponse() {
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
