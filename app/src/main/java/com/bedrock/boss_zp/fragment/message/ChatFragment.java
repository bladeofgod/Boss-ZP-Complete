package com.bedrock.boss_zp.fragment.message;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.adapter.message.MsgContactsAdapter;
import com.bedrock.boss_zp.model.ContactsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseHttpRecyclerFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.util.JSON;
import zuo.biao.library.util.TimeUtil;

public class ChatFragment extends BaseHttpRecyclerFragment<ContactsBean, BaseViewHolder, MsgContactsAdapter> {

    private static ChatFragment instance;

    public static ChatFragment getInstance(){
        if (instance == null){
            instance = new ChatFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_message_chat);

        initView();
        initData();
        initEvent();

        onRefresh();
        return view;
    }

    @Override
    public void setList(final List<ContactsBean> list) {
        final MsgContactsAdapter adapter = new MsgContactsAdapter(list);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.isFirstOnly(false);

        setList(new AdapterCallBack<MsgContactsAdapter>() {
            @Override
            public MsgContactsAdapter createAdapter() {
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
                showShortToast("you click item " + list.get(position).getName());
            }
        });

    }

    @Override
    public void getListAsync(final int page) {

        showProgressDialog(R.string.loading);

        final List<ContactsBean> list = new ArrayList<>();
        for (int i=0;i<15;i++){
            list.add(new ContactsBean(
                    "张亮 "+i,
                    "最近给你发送了 " + (i+2)+"条信息",
                    TimeUtil.getWholeTime(System.currentTimeMillis())
            ));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onHttpResponse(-page,
                        page>=3 ?null: JSON.toJSONString(list),null);
            }
        },1000);

    }

    @Override
    public List<ContactsBean> parseArray(String json) {
        return JSON.parseArray(json, ContactsBean.class);
    }
}
