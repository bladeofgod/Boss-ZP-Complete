package com.bedrock.boss_zp.adapter.jobs;

import android.app.Activity;
import android.view.ViewGroup;

import com.bedrock.boss_zp.view_holder.jobs.BusinessViewHolder;

import zuo.biao.library.base.BaseAdapter;
import zuo.biao.library.model.Entry;

public class BusinessLVAdapter extends BaseAdapter<Entry<String,String>, BusinessViewHolder> {
    public BusinessLVAdapter(Activity context) {
        super(context);
    }

    @Override
    public BusinessViewHolder createView(int viewType, ViewGroup parent) {
        return new BusinessViewHolder(context, parent);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
