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

public class DemandPopupView extends PartShadowPopupView {

    WeakReference<Context> reference;
    String[] educationTags = new String[]{
            "初中以下","中专","大专","高中","大学","硕士","博士",
    };
    String[] experienceTags = new String[]{
            "应届生","1年以内","1-3年","3-5年","5-10年","10年以上",
    };
    String[] salaryTags = new String[]{
            "3k以下","3-5k","5-8k","8-10k","10-20k","20-50k",
    };


    public DemandPopupView(@NonNull Context context) {
        super(context);
        reference = new WeakReference<>(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_jobs_demand;
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initPopupContent() {
        super.initPopupContent();
        final TagFlowLayout tfl1 = findViewById(R.id.tag_fl_1);
        final TagFlowLayout tfl2 = findViewById(R.id.tag_fl_2);
        final TagFlowLayout tfl3 = findViewById(R.id.tag_fl_3);

        tfl1.setAdapter(new TagAdapter<String>(educationTags) {

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

        tfl2.setAdapter(new TagAdapter<String>(experienceTags) {

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

        tfl3.setAdapter(new TagAdapter<String>(salaryTags) {

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


















