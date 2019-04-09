package com.bedrock.boss_zp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import cn.youngkaaa.yviewpager.YViewPager;

public class NeverScrollVViewpager extends YViewPager {
    public NeverScrollVViewpager(Context context) {
        super(context);
    }

    public NeverScrollVViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }


}
