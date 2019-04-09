package com.bedrock.boss_zp.application;

import zuo.biao.library.base.BaseApplication;

public class BaseApp extends BaseApplication {

    private static BaseApp context;
    public  static  BaseApp getAppContext(){return context;}


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
