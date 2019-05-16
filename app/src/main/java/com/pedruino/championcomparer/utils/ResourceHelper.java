package com.pedruino.championcomparer.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pedruino.championcomparer.R;

public final class ResourceHelper {

    public static final int findResourceIdByName(AppCompatActivity activity, String resourceName) {
        return findResourceIdByName(activity.getResources(), resourceName, activity.getApplicationContext());
    }

    public static final int findResourceIdByName(View view, String resourceName) {
        return findResourceIdByName(view.getResources(), resourceName, view.getContext());
    }

    private static final int findResourceIdByName(Resources resources, String resourceName, Context context) {
        int resourceId = resources.getIdentifier(resourceName, "drawable", context.getPackageName());
        if (resourceId == 0) {
            resourceId = R.drawable.champion_not_found;
        }
        return resourceId;
    }
}
