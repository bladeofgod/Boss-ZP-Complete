package com.bedrock.boss_zp.fragment.jobs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.adapter.jobs.BusinessFragmentAdapter;
import com.bedrock.boss_zp.adapter.jobs.JobsPlaceFragmentAdapter;
import com.bedrock.boss_zp.adapter.jobs.VerticalTabAdapter;
import com.bedrock.boss_zp.view.NeverScrollVViewpager;

import java.util.ArrayList;
import java.util.List;

import cn.youngkaaa.yviewpager.YViewPager;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.TabView;
import zuo.biao.library.base.BaseFragment;

public class SubwayFragment extends BaseFragment {


    public static SubwayFragment getInstance(){
        return new SubwayFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        setContentView(R.layout.fragment_jobs_place_sub);

        initView();
        initData();
        initEvent();

        return view;
    }

    private List<String> titles;
    private VerticalTabLayout tabLayout;
    private NeverScrollVViewpager viewPager;
    private JobsPlaceFragmentAdapter adapter;

    @Override
    public void initView() {

        titles = new ArrayList<>();
        for (int i=0;i<15;i++){
            titles.add("地铁 -"+i+"-");
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
        adapter = new JobsPlaceFragmentAdapter(
                getChildFragmentManager(), context,titles.toArray(new String[15]) );
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
