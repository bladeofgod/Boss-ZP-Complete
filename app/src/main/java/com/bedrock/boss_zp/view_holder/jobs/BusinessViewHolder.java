package com.bedrock.boss_zp.view_holder.jobs;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bedrock.boss_zp.R;

import zuo.biao.library.base.BaseView;
import zuo.biao.library.model.Entry;
import zuo.biao.library.util.StringUtil;

public class BusinessViewHolder extends BaseView<Entry<String,String>> implements View.OnClickListener {
    public BusinessViewHolder(Activity context, ViewGroup viewGroup) {
        super(context, R.layout.rv_item_jobs_popup_busi,viewGroup);
    }
    private TextView textView;

    @Override
    public View createView() {
        textView = findView(R.id.tv_item,this);
        return super.createView();
    }

    @Override
    public void bindView(Entry<String, String> data_) {
        super.bindView(data_ != null ? data_ : new Entry<String, String>("null key","null value"));
        textView.setText(StringUtil.getTrimedString(data.getValue()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_item:
                showShortToast(data.getValue());
                break;
        }

    }
}
