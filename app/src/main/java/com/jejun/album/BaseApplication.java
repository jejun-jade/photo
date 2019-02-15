package com.jejun.album;

import android.app.Activity;
import android.app.Application;

import com.jejun.album.user.KakaoSDKAdapter;
import com.kakao.auth.KakaoSDK;

public class BaseApplication extends Application {

    private static volatile BaseApplication obj = null;
    private static volatile Activity currentActivity = null;

    @Override
    public void onCreate() {
        super.onCreate();
        obj = this;
        KakaoSDK.init(new KakaoSDKAdapter());
    }

    public static BaseApplication getBaseApplicationContext() {
        return obj;
    }

    public static Activity getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(Activity currentActivity) {
        BaseApplication.currentActivity = currentActivity;
    }
}
