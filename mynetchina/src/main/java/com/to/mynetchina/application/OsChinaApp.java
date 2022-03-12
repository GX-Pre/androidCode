package com.to.mynetchina.application;

import android.app.Application;

import com.itheima.retrofitutils.ItheimaHttp;

public class OsChinaApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ItheimaHttp.init(this, "https://www.oschina.net/");
    }
}
