package com.bedrock.boss_zp.adapter.message;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.bedrock.boss_zp.fragment.message.CheckedMeFragment;
import com.bedrock.boss_zp.fragment.message.InterestedFragment;
import com.bedrock.boss_zp.fragment.message.NewJobFragment;

import java.util.ArrayList;
import java.util.List;

public class MsgPagerAdapter extends FragmentPagerAdapter {

    private List<String> titles;
    public List<Fragment> fragmentList;

    private FragmentManager fragmentManager;

    public MsgPagerAdapter(FragmentManager fm,List<String> titles) {
        super(fm);
        this.fragmentManager = fm;
        this.titles = titles;
        fragmentList = new ArrayList<>();
        fragmentList.add(InterestedFragment.getInstance());
        fragmentList.add(CheckedMeFragment.getInstance());
        fragmentList.add(NewJobFragment.getInstance());
    }


    public void removeFragment(){

        for (Fragment fragment : fragmentList){
            fragment = null;
        }

    }





    public int curIndex;
    @Override
    public Fragment getItem(int i) {
        curIndex = i;
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
