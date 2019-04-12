package com.bedrock.boss_zp.fragment.jobs;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.adapter.jobs.PlaceSelectorAdapter;
import com.bedrock.boss_zp.adapter.message.MsgPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseFragment;

/*
*
* 另一个，测试解决fragment重叠问题
* */
public class PlaceSelectFragment extends BaseFragment {

    private static PlaceSelectFragment instance;

    public static PlaceSelectFragment getInstance(){
        if (instance == null){
            instance = new PlaceSelectFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.popup_jobs_place_anther);

        initView();
        initData();
        initEvent();

        return view;
    }

    private TabLayout tabLayout;
    private ViewPager viewPager;
    PlaceSelectorAdapter adapter;

    @Override
    public void initView() {

        List<String> titles= new ArrayList<>();
        titles.add("附近");
        titles.add("商圈");
        titles.add("地铁");


        adapter = new PlaceSelectorAdapter(getChildFragmentManager(), titles);
        viewPager = findView(R.id.viewpager);
        tabLayout = findView(R.id.msg_tab_layout);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
