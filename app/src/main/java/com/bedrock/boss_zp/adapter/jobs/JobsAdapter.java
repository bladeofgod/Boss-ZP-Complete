package com.bedrock.boss_zp.adapter.jobs;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.model.JobBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zuo.biao.library.util.Log;

public class JobsAdapter extends BaseQuickAdapter<JobBean, BaseViewHolder>
implements BaseQuickAdapter.OnItemClickListener{
    public JobsAdapter(@Nullable List<JobBean> data) {
        super(R.layout.rv_item_jobs_card,data);
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

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
