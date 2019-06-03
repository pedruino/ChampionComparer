package com.pedruino.championcomparer.task;

import android.os.AsyncTask;

import com.pedruino.championcomparer.api.ApiClient;
import com.pedruino.championcomparer.api.response.ChampionsResponse;
import com.pedruino.championcomparer.api.services.ChampionService;

import java.io.IOException;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Response;

public class LoadChampionsTask extends AsyncTask<Void, Void, ChampionsResponse> {
    private LoadChampionsTaskDelegate delegate;

    public LoadChampionsTask(LoadChampionsTaskDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected ChampionsResponse doInBackground(Void... voids) {
        ChampionService service = ApiClient.getInstance().getChampionService();
        Call<ChampionsResponse> call = service.getAll(ApiClient.VERSION, ApiClient.getLocale());

        try {
            Response<ChampionsResponse> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ChampionsResponse response) {
        if (response != null) {
            delegate.onSuccess(response);
        } else {
            delegate.onFailure("Ocorreu um erro ao carregar .");
        }
    }

    public interface LoadChampionsTaskDelegate {
        void onSuccess(ChampionsResponse response);

        void onFailure(String message);
    }
}
