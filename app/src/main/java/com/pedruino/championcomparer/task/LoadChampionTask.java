package com.pedruino.championcomparer.task;

import android.os.AsyncTask;
import android.support.annotation.StringRes;

import com.pedruino.championcomparer.R;
import com.pedruino.championcomparer.api.ApiClient;
import com.pedruino.championcomparer.api.response.ChampionsResponse;
import com.pedruino.championcomparer.api.services.ChampionService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoadChampionTask extends AsyncTask<String, Void, ChampionsResponse> {
    private LoadChampionsTaskDelegate delegate;

    public LoadChampionTask(LoadChampionsTaskDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected ChampionsResponse doInBackground(String... strings) {
        ChampionService service = ApiClient.getInstance().getChampionService();
        Call<ChampionsResponse> call = service.getChampionByName(ApiClient.VERSION, ApiClient.getLocale(), strings[0]);

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
            this.delegate.onSuccess(response);
        } else {
            this.delegate.onFailure(R.string.toast_error_loading);
        }
    }

    public interface LoadChampionsTaskDelegate {
        void onSuccess(ChampionsResponse response);

        void onFailure(@StringRes int resourceId);
    }
}