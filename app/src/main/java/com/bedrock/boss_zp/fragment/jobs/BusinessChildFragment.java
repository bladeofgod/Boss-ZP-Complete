package com.bedrock.boss_zp.fragment.jobs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.adapter.jobs.BusinessLVAdapter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseListFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.model.Entry;

public class BusinessChildFragment extends BaseListFragment<Entry<String,String>, ListView, BusinessLVAdapter> {

    public static BusinessChildFragment getInstance(String keyWord){
        BusinessChildFragment fragment = new BusinessChildFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",keyWord );
        fragment.setArguments(bundle);
        return fragment;
    }

    private String keyWord;
    private View originView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        argument = getArguments();
        if (argument == null){
            keyWord = "null";
        }else {
            keyWord = argument.getString("key");
        }

        if (originView != null){
            ViewGroup viewGroup = (ViewGroup)originView.getParent();
            if (viewGroup != null){
                viewGroup.removeView(originView);
            }
            initView();
            initData();
            initEvent();
            onRefresh();
            return originView;
        }else {
            setContentView(R.layout.fragment_jobs_place_busi_child);
            originView = view;
            initView();
            initData();
            initEvent();
            onRefresh();

            return view;

        }


    }



    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initEvent() {
        super.initEvent();
    }

    @Override
    public void setList(final List<Entry<String, String>> list) {
        setList(new AdapterCallBack<BusinessLVAdapter>() {
            @Override
            public BusinessLVAdapter createAdapter() {
                return new BusinessLVAdapter(context);
            }

            @Override
            public void refreshAdapter() {
                adapter.refresh(list);
            }
        });

    }

    @Override
    public void getListAsync(int page) {
        List<Entry<String,String>> list = new ArrayList<>();
        for (int i=0 ;i<15;i++){
            list.add(new Entry<String, String>("key " +i,keyWord + "__" + i));
        }
        onLoadSucceed(page,list );

    }
}
