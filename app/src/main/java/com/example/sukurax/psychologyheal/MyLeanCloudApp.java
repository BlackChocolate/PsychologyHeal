package com.example.sukurax.psychologyheal;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by sukurax on 2017/1/20.
 */

public class MyLeanCloudApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"JU4XqWNf4BdlWcX9vXloxsXD-gzGzoHsz","EPCErM9HUTSWgyMR8HpFX78b");

//        EaseUI.getInstance().init(this, null);  //初始化EaseUI
//        EMClient.getInstance().setDebugMode(true);  //设置debug模式
    }
}