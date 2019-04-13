package com.bedrock.boss_zp.activity;

import android.Manifest;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bedrock.boss_zp.MainActivity;
import com.bedrock.boss_zp.R;
import com.gyf.barlibrary.ImmersionBar;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;
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

        checkAndRequestPermissions();

    }

    private void checkAndRequestPermissions(){
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.requestEachCombined(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
        ).subscribe(new Consumer<Permission>() {
            @Override
            public void accept(Permission permission) throws Exception {
                if (permission.granted){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toActivity(MainActivity.createIntent(context));
                            finish();
                        }
                    }, 1500);
                }

            }
        });
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
