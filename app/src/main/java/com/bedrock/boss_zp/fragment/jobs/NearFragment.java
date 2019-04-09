package com.bedrock.boss_zp.fragment.jobs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;

import zuo.biao.library.base.BaseFragment;

public class NearFragment extends BaseFragment {

    public static NearFragment getInstance(){
        return new NearFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_jobs_place_near);

        initView();
        initData();
        initEvent();

        return view;

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
