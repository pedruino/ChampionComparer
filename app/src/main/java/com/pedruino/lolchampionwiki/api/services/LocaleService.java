package com.pedruino.lolchampionwiki.api.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocaleService {

    @GET("languages.json")
    Call<List<String>> getLocales();
}
