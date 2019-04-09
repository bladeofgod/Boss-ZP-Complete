package com.bedrock.boss_zp.adapter.jobs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.bedrock.boss_zp.fragment.jobs.BusinessChildFragment;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class JobsPlaceFragmentAdapter extends FragmentPagerAdapter {

    private WeakReference<Context> reference;
    private String[] titles;
    private List<Fragment> fragmentList;
    public JobsPlaceFragmentAdapter(FragmentManager fm,Context context,String[] titles) {
        super(fm);
        reference = new WeakReference<>(context);
        this.titles = titles;
        fragmentList = new ArrayList<>();
        for (int i=0;i<titles.length;i++){
            fragmentList.add(i, BusinessChildFragment.getInstance(titles[i]) );
        }
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


}
