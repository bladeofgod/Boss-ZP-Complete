package com.bedrock.boss_zp.view.xpopup.company_fragment;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bedrock.boss_zp.R;
import com.lxj.xpopup.impl.PartShadowPopupView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.lang.ref.WeakReference;

public class SizePopupView extends PartShadowPopupView {

    WeakReference<Context> reference;

    private String[] tags = new String[]{
            "10人以上","20人以上","50人以上","90人以上","150人以上","1000人以上","5000人以上"
    };

    public SizePopupView(@NonNull Context context) {
        super(context);
        reference = new WeakReference<>(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_company_size;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();

        final TagFlowLayout flowLayout = findViewById(R.id.tag_fl);
        flowLayout.setAdapter(new TagAdapter<String>(tags) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(reference.get())
                        .inflate(R.layout.tag_s_p_company_f,flowLayout,false);
                tv.setText(s);
                return tv;
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onSelected(int position, View view) {
                super.onSelected(position, view);
                Toast.makeText(reference.get(),"select " +tags[position],Toast.LENGTH_SHORT).show();
                view.setBackground(getResources().getDrawable(R.drawable.tag_bg_selected));
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void unSelected(int position, View view) {
                super.unSelected(position, view);
                view.setBackground(getResources().getDrawable(R.drawable.tag_bg ));
            }
        });
    }
}
















