package com.pedruino.championcomparer.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pedruino.championcomparer.api.services.ChampionService;
import com.pedruino.championcomparer.api.services.LocaleService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://ddragon.leagueoflegends.com/cdn/";
    public static final String VERSION = "9.10.1";
    public static final String BASE_URL_IMAGE = String.format("%s%s/img/champion/", BASE_URL, VERSION);
    private static final String DEFAULT_LANGUAGE = "en_US";
    private static ApiClient instance;
    private static List<String> supportedLocales;
    private Retrofit retrofit;
    private ChampionService championService;
    private LocaleService localeService;

    private ApiClient() {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();

        this.localeService = retrofit.create(LocaleService.class);
        this.championService = retrofit.create(ChampionService.class);

        supportedLocales = Collections.unmodifiableList(getSupportedLocales());
    }

    private List<String> getSupportedLocales() {
        Call<List<String>> call = this.localeService.getLocales();

        try {
            Response<List<String>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.asList("en_US", "pt_BR");
    }

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    public static String getLocale() {
        String displayLanguage = Locale.getDefault().toString();
        if (supportedLocales.contains(displayLanguage)) {
            return displayLanguage;
        }
        return DEFAULT_LANGUAGE;
    }

    public ChampionService getChampionService() {
        return this.championService;
    }
}
