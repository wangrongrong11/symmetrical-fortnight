package com.example.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.Window;

public class LocalApplication extends Application {
    public static SharedPreferences sharedPreferences = null;
    public final static String sharedPreferencesName = "user_info";
    private Context context;
    private static LocalApplication localApplication;

    public static LocalApplication getInstance(){
        return localApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        localApplication = this;
        init();
    }

    private void init() {
        context = getApplicationContext();
        sharedPreferences = getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);


    }



    public static String getString(String key, String defaultValue){
        return sharedPreferences.getString(key, defaultValue);
    }

    public static void putString(String key, String value){
        if (key != null && value != null) {
            sharedPreferences.edit().putString(key, value).commit();
        }
    }

    public static boolean getBoolean(String key, boolean value){
        return  sharedPreferences.getBoolean(key, value);
    }

    public static void putBoolean(String key, boolean value){
        if (key != null) {
            sharedPreferences.edit().putBoolean(key, value).commit();
        }
    }
}
