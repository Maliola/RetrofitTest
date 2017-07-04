package com.example.ios007.retrofittest.app.config;

import android.app.Application;

import com.example.ios007.retrofittest.model.entry.User;
import com.example.ios007.retrofittest.util.Utils;

/**
 * Created by ios007 on 2017/7/4.
 */

public class AppApplication extends Application{
    private static AppApplication instance;
    private AppSetting settings;
    public static AppApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.initialize(this);
        instance=this;
    }
    public AppSetting getAppSettings() {
        if (settings == null) {
            settings = new AppSetting(instance);
        }
        return settings;
    }
    public User getUser() {
        return getAppSettings().getUser();
    }

}
