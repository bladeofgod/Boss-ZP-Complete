package com.bedrock.boss_zp.view.xpopup.jobs_fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.bedrock.boss_zp.R;
import com.lxj.xpopup.impl.PartShadowPopupView;

public class RecommendPopupView extends PartShadowPopupView {
    public RecommendPopupView(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_jobs_recommend;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();
        findViewById(R.id.btnClose).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
