package com.bedrock.boss_zp.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bedrock.boss_zp.MainActivity;
import com.bedrock.boss_zp.R;
import com.gyf.barlibrary.ImmersionBar;

import zuo.biao.library.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImmersionBar.with(this).init();

        initView();
        initData();
        initEvent();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toActivity(MainActivity.createIntent(context));
                finish();
            }
        }, 1500);

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
