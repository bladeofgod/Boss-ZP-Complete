package com.bedrock.boss_zp.fragment.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.view.ObservableScrollView;
import com.bumptech.glide.util.Util;
import com.gyf.barlibrary.ImmersionBar;

import java.security.interfaces.ECKey;

import zuo.biao.library.base.BaseFragment;
import zuo.biao.library.util.Log;

public class UserFragment extends BaseFragment {


    public static UserFragment getInstance(){return new UserFragment();}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_user);

        ImmersionBar.with(this)
                .statusBarColor(R.color.green_deep)
                .init();

        initView();
        initData();
        initEvent();

        return view;

    }

    private Toolbar toolbar;
    private ImageView ivBack,ivRigth;
    private TextView tvTitle;

    @Override
    public void initView() {

        final float toolbarHeight = getResources().getDimension(R.dimen.sixty);
        final float move_distance = getResources().getDimension(R.dimen.one_hundred);

        ObservableScrollView scrollView = findView(R.id.scroll_view_content);
        toolbar = findView(R.id.tool_bar);
        ivBack = findView(R.id.iv_toolbar_back);
        ivRigth = findView(R.id.iv_toolbar_right);
        tvTitle = findView(R.id.tv_toolbar_user_name);

        scrollView.setListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScroll(int oldY, int dy, boolean isUp) {
                //Log.i("scrollview","dy :" + dy + "old y :" + oldY  + "is up :" + isUp);
                if (!isUp && dy<= move_distance){
                    toolbar.setBackgroundColor(getResources().getColor(R.color.green_deep));
                    toolbarAlphaChange(dy,move_distance);
                }else if (! isUp && dy > move_distance){
                    toolbarAlphaChange(1, 1);
                    ivBack.setVisibility(View.VISIBLE);
                    ivRigth.setVisibility(View.VISIBLE);
                    tvTitle.setVisibility(View.VISIBLE);


                }else if (isUp && dy > move_distance){

                }else if (isUp && dy <= move_distance){
                    toolbarAlphaChange(dy,move_distance );
                    ivBack.setVisibility(View.INVISIBLE);
                    ivRigth.setVisibility(View.INVISIBLE);
                    tvTitle.setVisibility(View.INVISIBLE);
                }

            }
        });

    }

    private void toolbarAlphaChange(int dy,float moveDistance){
        float percent =  (float) Math.abs(dy) / Math.abs(moveDistance);
        //如果是设置背景透明度，则传入的参数是int类型，取值范围0-255
        //如果是设置控件透明度，传入的参数是float类型，取值范围0.0-1.0
        int alpha = (int)(percent * 255);
        toolbar.getBackground().setAlpha(alpha);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
