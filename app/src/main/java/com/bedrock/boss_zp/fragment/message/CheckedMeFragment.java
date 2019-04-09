package com.bedrock.boss_zp.fragment.message;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.adapter.CompanyAdapter;
import com.bedrock.boss_zp.adapter.jobs.JobsAdapter;
import com.bedrock.boss_zp.model.CompanyBean;
import com.bedrock.boss_zp.model.JobBean;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseHttpRecyclerFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.util.JSON;

public class CheckedMeFragment extends BaseHttpRecyclerFragment<JobBean, BaseViewHolder, JobsAdapter> {

    public static CheckedMeFragment getInstance(){
        return new CheckedMeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_msg_reac_checked);

        initView();
        initData();
        initEvent();

        onRefresh();
        return view;
    }

    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void setList(List<JobBean> list) {
        final JobsAdapter adapter = new JobsAdapter(list);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.isFirstOnly(false);

        setList(new AdapterCallBack<JobsAdapter>() {
            @Override
            public JobsAdapter createAdapter() {
                return adapter;
            }

            @Override
            public void refreshAdapter() {
                adapter.notifyDataSetChanged();

            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                showShortToast("you click item  " + position);
            }
        });

    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void getListAsync(final int page) {
        showProgressDialog(R.string.loading);

        final List<JobBean> list = new ArrayList<>();

        for (int i=0;i<10;i++){
            JobBean bean = new JobBean(
                    "android 工程师",
                    "巨石科技公司",
                    "10-12K",
                    "张经理"
            );

            list.add(bean);

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onHttpResponse(-page,page>=3 ? null:JSON.toJSONString(list),null);
            }
        },1000);
    }

    @Override
    public List<JobBean> parseArray(String json) {
        return JSON.parseArray(json, JobBean.class);
    }

    @Override
    public void initEvent() {
        super.initEvent();
    }


}
