package com.example.tse.listdirectorio.Network;

import android.app.Application;
import android.content.Context;

/**
 * Created by TSE on 17/09/2015.
 */
public class MyAplication extends Application {
    private static MyAplication mInstance;
    public static final String API_DIPUTADOS ="http://congresorest.appspot.com/diputado/";

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static MyAplication getInstance(){
        return mInstance;
    }

    public static Context getAppContext(){
        return mInstance.getApplicationContext();
    }
}
