package com.bedrock.boss_zp.fragment.jobs;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.adapter.jobs.JobsAdapter;
import com.bedrock.boss_zp.banner.GlideImageLoader;
import com.bedrock.boss_zp.model.JobBean;
import com.bedrock.boss_zp.view.xpopup.jobs_fragment.CompanyPopupView;
import com.bedrock.boss_zp.view.xpopup.jobs_fragment.DemandPopupView;
import com.bedrock.boss_zp.view.xpopup.jobs_fragment.PlacePopupView;
import com.bedrock.boss_zp.view.xpopup.jobs_fragment.RecommendPopupView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lxj.xpopup.XPopup;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseFragment;
import zuo.biao.library.base.BaseHttpRecyclerFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.util.JSON;

public class JobsFragment extends BaseHttpRecyclerFragment<JobBean, BaseViewHolder, JobsAdapter>
 implements View.OnClickListener {

    public static  JobsFragment getInstance(){return new JobsFragment();}

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         setContentView(R.layout.fragment_jobs);

         initView();
         initData();
         initEvent();

         onRefresh();
         return view;

     }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    List<Integer> images;

     @Override
     public void initView() {
         super.initView();

         loadBanner();
     }
     private void loadBanner(){
         images = new ArrayList<>();
         images.add(R.drawable.a1);
         images.add(R.drawable.a2);
         images.add(R.drawable.a3);

         Banner banner =  findView(R.id.banner);
         banner.setImageLoader(new GlideImageLoader());
         banner.setImages(images);
         banner.start();
     }

     @Override
     public void initData() {
         super.initData();
     }

     @Override
     public void initEvent() {
         super.initEvent();
         findView(R.id.tv_recommend).setOnClickListener(this);
         findView(R.id.tv_place).setOnClickListener(this);
         findView(R.id.tv_company).setOnClickListener(this);
         findView(R.id.tv_demand).setOnClickListener(this);
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
                 onHttpResponse(-page,
                         page>=5 ? null : JSON.toJSONString(list),null);
             }
         },1000);

     }

     @Override
     public List<JobBean> parseArray(String json) {
         return JSON.parseArray(json, JobBean.class);
     }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_recommend:
                XPopup.get(context)
                        .asCustom(new RecommendPopupView(context))
                        .atView(findView(R.id.tv_recommend))
                        .show();
                break;
            case R.id.tv_place:
                XPopup.get(context)
                        .asCustom(PlacePopupView.getSingleton(context,context.getSupportFragmentManager()))
                        .atView(findView(R.id.tv_place))
                        .show();
                break;
            case R.id.tv_company:
                XPopup.get(context)
                        .asCustom(new CompanyPopupView(context))
                        .atView(findView(R.id.tv_company))
                        .show();
                break;
            case R.id.tv_demand:
                XPopup.get(context)
                        .asCustom(new DemandPopupView(context))
                        .atView(findView(R.id.tv_demand))
                        .show();
                break;
        }
    }
}
