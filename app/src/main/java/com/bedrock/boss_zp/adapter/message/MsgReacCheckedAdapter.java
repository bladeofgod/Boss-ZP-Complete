package com.bedrock.boss_zp.adapter.message;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.model.JobBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zuo.biao.library.util.Log;

public class MsgReacCheckedAdapter extends BaseQuickAdapter<JobBean, BaseViewHolder> {
    public MsgReacCheckedAdapter(@Nullable List<JobBean> data) {
        super(R.layout.rv_item_msg_reac,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JobBean item) {
        final JobBean data = item != null ? item : new JobBean();
        Log.i("jobs",data.getCompanyName() );
        ((TextView)helper.getView(R.id.tv_salary)).setText(data.getSalary());
        ((TextView)helper.getView(R.id.tv_job_name)).setText(data.getJobName());
        ((TextView)helper.getView(R.id.tv_company_name)).setText(data.getCompanyName());
        ((TextView)helper.getView(R.id.tv_recruiter)).setText(data.getRecruiter());


    }
}
