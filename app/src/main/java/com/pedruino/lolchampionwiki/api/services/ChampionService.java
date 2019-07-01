package com.pedruino.lolchampionwiki.api.services;

import com.pedruino.lolchampionwiki.api.responses.ChampionsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ChampionService {
    @GET("{version}/data/{locale}/champion.json")
    Call<ChampionsResponse> getAll(@Path("version") String version, @Path("locale") String locale);

    @GET("{version}/data/{locale}/champion/{name}.json")
    Call<ChampionsResponse> getChampionByName(@Path("version") String version, @Path("locale") String locale, @Path("name") String name);
}
