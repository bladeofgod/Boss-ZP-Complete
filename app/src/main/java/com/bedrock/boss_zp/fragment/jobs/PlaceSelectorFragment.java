package com.bedrock.boss_zp.fragment.jobs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;

import java.util.List;

import zuo.biao.library.base.BaseTabFragment;
import zuo.biao.library.util.Log;

public class PlaceSelectorFragment extends BaseTabFragment implements View.OnClickListener {

    private static PlaceSelectorFragment instance;

    public static PlaceSelectorFragment getInstance(){
        if (instance == null){
            instance = new PlaceSelectorFragment();
        }
        return instance;
    }
    private List<Fragment> fragmentList;

    private View originView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState,R.layout.fragment_jobs_place);

        originView = view;
        initView();
        initData();
        initEvent();

        return view;
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.i("fragmentdebug","hidden  " + hidden );
        super.onHiddenChanged(hidden);
        if (hidden){
            if (NearFragment.getInstance() != null && NearFragment.getInstance().isAdded()){
                context.getSupportFragmentManager().beginTransaction().hide(NearFragment.getInstance()).commit();
            }
            if (BusinessFragment.getInstance() != null&& BusinessFragment.getInstance().isAdded()){
                context.getSupportFragmentManager().beginTransaction().hide(BusinessFragment.getInstance()).commit();
            }
            if (SubwayFragment.getInstance()!=null && SubwayFragment.getInstance().isAdded()){
                context.getSupportFragmentManager().beginTransaction().hide(SubwayFragment.getInstance()).commit();
            }
        }else {
            if (NearFragment.getInstance() != null && NearFragment.getInstance().isAdded()){
                context.getSupportFragmentManager().beginTransaction().show(NearFragment.getInstance()).commit();
            }
            if (BusinessFragment.getInstance() != null&& BusinessFragment.getInstance().isAdded()){
                context.getSupportFragmentManager().beginTransaction().show(BusinessFragment.getInstance()).commit();
            }
            if (SubwayFragment.getInstance()!=null && SubwayFragment.getInstance().isAdded()){
                context.getSupportFragmentManager().beginTransaction().show(SubwayFragment.getInstance()).commit();
            }
        }
    }

    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initEvent() {
        super.initEvent();
    }

    @Override
    protected String[] getTabNames() {
        return new String[]{"附近","商圈","地铁"};
    }

    @Override
    protected Fragment getFragment(int position) {
        switch (position){
            default:
                return NearFragment.getInstance();
            case 1:
                return BusinessFragment.getInstance();
            case 2:
                return SubwayFragment.getInstance();

        }
    }
}
