package com.bedrock.boss_zp.adapter.message;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.model.ContactsBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MsgContactsAdapter extends BaseQuickAdapter<ContactsBean, BaseViewHolder> {
    public MsgContactsAdapter(@Nullable List<ContactsBean> data) {
        super(R.layout.rv_item_msg_chat,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsBean item) {

        final  ContactsBean data = item == null ? new ContactsBean():item;

        Glide.with(mContext).load(R.mipmap.ic_launcher)
                .into(((ImageView)helper.getView(R.id.iv_chat_avatar)));

        ((TextView)helper.getView(R.id.tv_mgr_name)).setText(data.getName());
        ((TextView)helper.getView(R.id.tv_mgr_msg)).setText(data.getMgrMsg());
        ((TextView)helper.getView(R.id.tv_msg_time)).setText(data.getChatDate());

    }
}
















