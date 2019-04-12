package com.bedrock.boss_zp.adapter.jobs;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bedrock.boss_zp.fragment.jobs.BusinessFragment;
import com.bedrock.boss_zp.fragment.jobs.NearFragment;
import com.bedrock.boss_zp.fragment.jobs.SubwayFragment;
import com.bedrock.boss_zp.fragment.message.CheckedMeFragment;
import com.bedrock.boss_zp.fragment.message.InterestedFragment;
import com.bedrock.boss_zp.fragment.message.NewJobFragment;

import java.util.ArrayList;
import java.util.List;

public class PlaceSelectorAdapter extends FragmentPagerAdapter {

    private List<String> titles;
    public List<Fragment> fragmentList;


    public PlaceSelectorAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        this.titles = titles;
        fragmentList = new ArrayList<>();
        fragmentList.add(NearFragment.getInstance());
        fragmentList.add(BusinessFragment.getInstance());
        fragmentList.add(SubwayFragment.getInstance());
    }

    @Override
    public Fragment getItem(int i) {
        if (i < fragmentList.size()){
            return fragmentList.get(i);
        }else {
            return fragmentList.get(0);
        }
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
