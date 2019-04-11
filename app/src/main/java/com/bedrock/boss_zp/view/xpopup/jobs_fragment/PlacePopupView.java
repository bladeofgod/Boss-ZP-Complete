package com.bedrock.boss_zp.view.xpopup.jobs_fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.fragment.jobs.PlaceSelectorFragment;
import com.lxj.xpopup.impl.PartShadowPopupView;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class PlacePopupView extends PartShadowPopupView {

    WeakReference<Context> reference;
    SoftReference<FragmentManager> managerSoftReference;

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
        managerSoftReference = new SoftReference<>(fragmentManager);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_jobs_place;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();

        FragmentTransaction ft = managerSoftReference.get().beginTransaction();
        ft.add(R.id.place_fg_container, PlaceSelectorFragment.getInstance());
        ft.show(PlaceSelectorFragment.getInstance());
        ft.commit();
    }

}










