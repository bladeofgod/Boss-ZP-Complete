package com.bedrock.boss_zp.view.xpopup.jobs_fragment;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bedrock.boss_zp.R;
import com.lxj.xpopup.impl.PartShadowPopupView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.lang.ref.WeakReference;

public class CompanyPopupView extends PartShadowPopupView {

    WeakReference<Context> reference;

    private String[] financingTags = new String[]{
            "未融资","A轮","B轮","C轮","D轮","E轮","F轮","以上市","不需要融资"
    };
    private String[] sizeTags = new String[]{
            "10人以上","20人以上","50人以上","90人以上","150人以上","1000人以上","5000人以上"
    };

    private String[] professionTags = new String[]{
            "电子商务","游戏","媒体","广告营销","数据服务","医疗健康","O2O","生活服务","旅游","分类信息",
            "社交网络","在线教育"
            ,"信息安全","智能硬件","移动互联网","互联网","计算机软件","汽车生产","工程施工","其他行业"
    };

    public CompanyPopupView(@NonNull Context context) {
        super(context);
        reference = new WeakReference<>(context);
    }


    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_jobs_company;
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initPopupContent() {
        super.initPopupContent();
        final TagFlowLayout tfl1 = findViewById(R.id.tag_fl_1);
        final TagFlowLayout tfl2 = findViewById(R.id.tag_fl_2);
        final TagFlowLayout tfl3 = findViewById(R.id.tag_fl_3);

        tfl1.setAdapter(new TagAdapter<String>(financingTags) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(reference.get())
                        .inflate(R.layout.tag_s_p_company_f,tfl1,false );
                tv.setText(s);
                return tv;
            }

            @Override
            public void onSelected(int position, View view) {
                super.onSelected(position, view);
                view.setBackground(getResources().getDrawable(R.drawable.tag_bg_selected));
            }

            @Override
            public void unSelected(int position, View view) {
                super.unSelected(position, view);
                view.setBackground(getResources().getDrawable(R.drawable.tag_bg ));
            }
        });

        tfl2.setAdapter(new TagAdapter<String>(sizeTags) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(reference.get())
                        .inflate(R.layout.tag_s_p_company_f,tfl1,false );
                tv.setText(s);
                return tv;
            }

            @Override
            public void onSelected(int position, View view) {
                super.onSelected(position, view);
                view.setBackground(getResources().getDrawable(R.drawable.tag_bg_selected));
            }

            @Override
            public void unSelected(int position, View view) {
                super.unSelected(position, view);
                view.setBackground(getResources().getDrawable(R.drawable.tag_bg ));
            }
        });

        tfl3.setAdapter(new TagAdapter<String>(professionTags) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(reference.get())
                        .inflate(R.layout.tag_s_p_company_f,tfl1,false );
                tv.setText(s);
                return tv;
            }

            @Override
            public void onSelected(int position, View view) {
                super.onSelected(position, view);
                view.setBackground(getResources().getDrawable(R.drawable.tag_bg_selected));
            }

            @Override
            public void unSelected(int position, View view) {
                super.unSelected(position, view);
                view.setBackground(getResources().getDrawable(R.drawable.tag_bg ));
            }
        });

    }
}
