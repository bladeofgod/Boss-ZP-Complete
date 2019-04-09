package com.bedrock.boss_zp.fragment.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;

import zuo.biao.library.base.BaseFragment;

public class InterestedFragment extends BaseFragment {

    public static InterestedFragment getInstance(){
        return new InterestedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_msg_reac_inter);

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
