package com.bedrock.boss_zp.fragment.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.boss_zp.R;

import java.security.MessageDigest;

import zuo.biao.library.base.BaseFragment;
import zuo.biao.library.base.BaseTabFragment;
import zuo.biao.library.util.Log;

public class MessageFragment extends BaseTabFragment {

    public static MessageFragment getInstance(){return new MessageFragment();}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState,R.layout.fragment_message);

        initView();
        initData();
        initEvent();

        return view;

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
    public void onHiddenChanged(boolean hidden) {
        Log.i("fragment"," msg hidden " + hidden );
        super.onHiddenChanged(hidden);
        if (hidden){
            if (ReactionFragment.getInstance() != null && ReactionFragment.getInstance().isAdded()){
                Log.i("fragment"," msg hidden remove" + hidden );
                fragmentManager.beginTransaction().hide(ReactionFragment.getInstance()).commit();
            }
        }else {
            if (ReactionFragment.getInstance() != null && (!ReactionFragment.getInstance().isVisible())){
                fragmentManager.beginTransaction().show(ReactionFragment.getInstance()).commit();
            }

        }
    }




    @Override
    protected String[] getTabNames() {
        return new String[]{"聊天","互动"};
    }

    @Override
    protected Fragment getFragment(int position) {
        switch (position){
            default:
                Log.i("fragment","msg chat" );
                return ChatFragment.getInstance();
            case 1:
                Log.i("fragment","reac chat" );
                return ReactionFragment.getInstance();
        }
    }

    @Override
    public void onPause() {
        Log.i("fragment","msg pause" );
        super.onPause();

    }

    @Override
    public void onStop() {
        Log.i("fragment","msg stop" );
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i("fragment","msg destroy" );
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.i("fragment","msg destroy view" );
        super.onDestroyView();
    }
}
