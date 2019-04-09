package com.bedrock.boss_zp.fragment.company;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.adapter.CompanyAdapter;
import com.bedrock.boss_zp.model.CompanyBean;
import com.bedrock.boss_zp.view.xpopup.company_fragment.FinancingPopupView;
import com.bedrock.boss_zp.view.xpopup.company_fragment.ProfessionPopupView;
import com.bedrock.boss_zp.view.xpopup.company_fragment.SizePopupView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lxj.xpopup.XPopup;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseHttpRecyclerFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.util.JSON;

public class CompanyFragment extends BaseHttpRecyclerFragment<CompanyBean, BaseViewHolder, CompanyAdapter>
implements View.OnClickListener {


    public static CompanyFragment getInstance(){return  new CompanyFragment();}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         setContentView(R.layout.fragment_company);
        initView();
        initData();
        initEvent();

        onRefresh();

        return view;
    }

    @Override
    public void initView() {
        super.initView();
        ((TextView)findView(R.id.tvBaseTitle)).setText("公司");
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initEvent() {
        super.initEvent();
        findView(R.id.tv_financing).setOnClickListener(this);
        findView(R.id.tv_size).setOnClickListener(this);
        findView(R.id.tv_profession).setOnClickListener(this);

    }

    @Override
    public void setList(List<CompanyBean> list) {
        final CompanyAdapter adapter = new CompanyAdapter(list);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.isFirstOnly(false);
        setList(new AdapterCallBack<CompanyAdapter>() {
            @Override
            public CompanyAdapter createAdapter() {
                return adapter;
            }

            @Override
            public void refreshAdapter() {
                adapter.notifyDataSetChanged();

            }
        });


        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                showShortToast("you click item  " + position);
            }
        });

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.iv_com_avatar:
                        showShortToast("you click avatar " + position);
                        break;
                    case R.id.tv_com_name:
                        showShortToast("you click name " + position);
                        break;
                }
            }
        });

    }

    @Override
    public void getListAsync(final int page) {
        showProgressDialog(R.string.loading);

        final List<CompanyBean> beanList = new ArrayList<>();
        for (int i=0;i<20;i++){
            beanList.add(new CompanyBean(
                    "四十大盗 "+i,"",
                    "北京" + i,"",
                    "正在热招 职位："+(i*200)+"位"
            ));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onHttpResponse(-page,
                        page >= 5 ? null : JSON.toJSONString(beanList),null );

            }
        }, 1000);

    }

    @Override
    public List<CompanyBean> parseArray(String json) {
        return JSON.parseArray(json,CompanyBean.class );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_financing:
                XPopup.get(context)
                        .asCustom(new FinancingPopupView(context))
                        .atView(findView(R.id.tv_financing))
                        .show();
                break;
            case R.id.tv_size:
                XPopup.get(context)
                        .asCustom(new SizePopupView(context))
                        .atView(findView(R.id.tv_financing))
                        .show();
                break;
            case R.id.tv_profession:
                XPopup.get(context)
                        .asCustom(new ProfessionPopupView(context))
                        .atView(findView(R.id.tv_financing))
                        .show();
                break;
        }

    }
}
















