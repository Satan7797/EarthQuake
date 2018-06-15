package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
        Log.i(LOG_TAG, "Test: EarthquakeLoader is called...");
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (mUrl != null)
            return null;

        Log.i(LOG_TAG, "Test: loadInBackground()...");
        List<Earthquake> result = QueryUtils.extractEarthquakes(mUrl);
        return result;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "in onStartLoading()...");
        forceLoad();
    }
}
