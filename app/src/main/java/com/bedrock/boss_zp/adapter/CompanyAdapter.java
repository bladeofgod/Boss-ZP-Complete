package com.bedrock.boss_zp.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.model.CompanyBean;
import com.bedrock.boss_zp.view_holder.CompanyViewHolder;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class CompanyAdapter extends BaseQuickAdapter<CompanyBean, BaseViewHolder>
    implements BaseQuickAdapter.OnItemClickListener{

    public CompanyAdapter(@Nullable List<CompanyBean> data) {
        super(R.layout.rv_item_company_card,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CompanyBean item) {
        final CompanyBean data = item != null ? item : new CompanyBean();

        helper.addOnClickListener(R.id.iv_com_avatar);
        helper.addOnClickListener(R.id.tv_com_name);

        ((TextView)helper.getView(R.id.tv_com_name)).setText(data.getName());
        ((TextView)helper.getView(R.id.tv_com_location)).setText(data.getLocation());
        ((TextView)helper.getView(R.id.tv_wanted_detail)).setText(data.getWantedDetail());
        Glide.with(mContext).load(R.mipmap.ic_launcher).into((ImageView) helper.getView(R.id.iv_com_avatar));

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
