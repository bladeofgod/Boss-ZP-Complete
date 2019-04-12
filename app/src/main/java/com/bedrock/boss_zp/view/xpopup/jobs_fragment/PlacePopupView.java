package com.bedrock.boss_zp.view.xpopup.jobs_fragment;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.fragment.jobs.PlaceSelectFragment;
import com.bedrock.boss_zp.fragment.jobs.PlaceSelectorFragment;
import com.lxj.xpopup.impl.PartShadowPopupView;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import zuo.biao.library.base.BaseActivity;
import zuo.biao.library.util.Log;

public class PlacePopupView extends PartShadowPopupView {

    WeakReference<Context> reference;
    //SoftReference<FragmentManager> managerSoftReference;
    FragmentManager fragmentManager;

    private static PlacePopupView singleton;

    public static PlacePopupView getSingleton(@NonNull Context context, FragmentManager fragmentManager){
        if (singleton == null){
            singleton = new PlacePopupView(context, fragmentManager);
        }
        return singleton;
    }

    private PlacePopupView(@NonNull Context context, FragmentManager fragmentManager) {
        super(context);
        reference = new WeakReference<>(context);
        //managerSoftReference = new SoftReference<>(fragmentManager);
        this.fragmentManager = fragmentManager;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_jobs_place;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (!PlaceSelectFragment.getInstance().isAdded()
                && fragmentManager.findFragmentByTag("ps") == null){
            ft.add(R.id.place_fg_container, PlaceSelectFragment.getInstance(),"ps");
        }

        ft.show(PlaceSelectFragment.getInstance());
        ft.commit();
    }

    @Override
    public void dismiss() {
        Log.i("popup","dismiss" );
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (PlaceSelectFragment.getInstance().isAdded()
                || fragmentManager.findFragmentByTag("ps") != null){
            Log.i("fragmentdebug","remove fragment" );
            if (PlaceSelectorFragment.getInstance().isAdded()){
                ft.remove(PlaceSelectFragment.getInstance());
                ft.commit();
            }
        }
        super.dismiss();
    }


}










