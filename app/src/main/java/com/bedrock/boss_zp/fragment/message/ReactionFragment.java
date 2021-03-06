package com.bedrock.boss_zp.fragment.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.adapter.message.MsgPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseFragment;
import zuo.biao.library.util.Log;

public class ReactionFragment extends BaseFragment {

    private static ReactionFragment instance;
    public static ReactionFragment getInstance(){
        if (instance == null){
            instance = new ReactionFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_message_reaction);

        initView();
        initData();
        initEvent();

        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i("fragment","  hidden " + hidden );
        if (hidden){
            if (adapter != null){
                adapter.removeFragment();
            }
        }else {
            if (adapter != null){

            }
        }
    }


    private TabLayout tabLayout;
    private MsgPagerAdapter adapter;
    private ViewPager viewPager;

    @Override
    public void initView() {

        List<String> titles= new ArrayList<>();
        titles.add("对我感兴趣的");
        titles.add("看过我的");
        titles.add("新职位");


        adapter = new MsgPagerAdapter(context.getSupportFragmentManager(), titles);
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
