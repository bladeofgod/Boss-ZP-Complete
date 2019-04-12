package com.bedrock.boss_zp.fragment.jobs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;

import zuo.biao.library.base.BaseFragment;

public class NearFragment extends BaseFragment {

    private static NearFragment instance;
    public static NearFragment getInstance(){
        if (instance == null){
            instance = new NearFragment();
        }
        return instance;
    }

    private View originView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (originView != null){
            ViewGroup viewGroup = (ViewGroup)originView.getParent();
            if (viewGroup != null){
                viewGroup.removeView(originView);
            }
            initView();
            initData();
            initEvent();

            return originView;
        }else {
            setContentView(R.layout.fragment_jobs_place_near);
            originView = view;
            initView();
            initData();
            initEvent();


            return view;

        }



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
