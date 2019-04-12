package com.bedrock.boss_zp.fragment.jobs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.adapter.jobs.BusinessFragmentAdapter;
import com.bedrock.boss_zp.adapter.jobs.VerticalTabAdapter;
import com.bedrock.boss_zp.view.NeverScrollVViewpager;

import java.util.ArrayList;
import java.util.List;

import cn.youngkaaa.yviewpager.YViewPager;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.TabView;
import zuo.biao.library.base.BaseFragment;

public class BusinessFragment extends BaseFragment {

    private static BusinessFragment instance;
    public static BusinessFragment getInstance(){
        if (instance == null){
            instance = new BusinessFragment();
        }
        return  instance;
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
            setContentView(R.layout.fragment_jobs_place_sub);
            originView = view;
            initView();
            initData();
            initEvent();


            return view;

        }
    }
    private List<String> titles;
    private VerticalTabLayout tabLayout;
    private NeverScrollVViewpager viewPager;
    private BusinessFragmentAdapter adapter;

    @Override
    public void initView() {
        titles = new ArrayList<>();
        for (int i=0;i<20;i++){
            titles.add("商圈 -"+i+"-");
        }
        tabLayout = findView(R.id.business_tab_layout);
        tabLayout.setTabAdapter(new VerticalTabAdapter(titles,context ));
        tabLayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                viewPager.setCurrentItem(position);

            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

        viewPager = findView(R.id.business_view_pager);
        adapter = new BusinessFragmentAdapter(
                getChildFragmentManager(), context,titles.toArray(new String[20]) );
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
