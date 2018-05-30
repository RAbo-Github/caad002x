package com.example.ratech.asynctaskloader;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by aboro on 09/05/2018.
 */

public class NamesAsyncTaskLoader extends AsyncTaskLoader<ArrayList<String>> {

    public NamesAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public ArrayList<String> loadInBackground() {
        return loadNamesFromDB();
    }

    //This method simulates a call to a local database
    private ArrayList<String> loadNamesFromDB() {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.add("Emma");
        names.add("Emma");
        names.add("Noah");

        return names;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
