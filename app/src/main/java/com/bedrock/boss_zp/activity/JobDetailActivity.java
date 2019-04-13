package com.bedrock.boss_zp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.bedrock.boss_zp.R;
import com.bedrock.boss_zp.view.ObservableScrollView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import zuo.biao.library.base.BaseActivity;

public class JobDetailActivity extends BaseActivity {

    public static Intent createIntent(Context context){
        return new Intent(context,JobDetailActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        initView();
        initData();
        initEvent();

    }

    private String[] skillTags = new String[]{
            "socket","android sdk","android studio"
    };
    private String[] welfareTags = new String[]{
            "不打卡","不加班","扁平管理","年假","五险一金","领导随和","大牛拉车"
    };

    private MapView mapView;
    private BaiduMap baiduMap;

    private Toolbar toolbar;
    private ImageView ivBack,ivRight;
    private TextView tvTitle;

    @Override
    public void initView() {

        initToolBarLayout();

        initTagFlowLayout();

        mapView = findView(R.id.map_view);
        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);

        initLocation();

    }
    //这里我直接传入了地址，实际上肯定是动态获取的
    //如果需要，可以通过定位系统将地址反编译出 经纬度，在输出到地图定位即可
    private void initLocation(){

        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(new LatLng(39.99338, 116.311496));

        MyLocationData locationData =  new MyLocationData.Builder()
                .accuracy(10)
                .latitude(39.99338)
                .longitude(116.311496)
                .build();
        baiduMap.setMyLocationData(locationData);
        baiduMap.setMapStatus(mapStatusUpdate);

    }

    private void initToolBarLayout(){

        final float toolbarHeight = getResources().getDimension(R.dimen.sixty);
        final float move_distance = getResources().getDimension(R.dimen.one_hundred);

        ObservableScrollView scrollView = findView(R.id.observable_scrollview);
        toolbar = findView(R.id.tool_bar);
        ivBack = findView(R.id.iv_toolbar_back);
        ivRight = findView(R.id.iv_toolbar_right);
        tvTitle = findView(R.id.tv_toolbar_user_name);

        scrollView.setListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScroll(int oldY, int dy, boolean isUp) {

                if (!isUp && dy<= move_distance){
                    toolbar.setBackgroundColor(getResources().getColor(R.color.green_deep));
                    toolbarAlphaChange(dy,move_distance);
                }else if (! isUp && dy > move_distance){
                    toolbarAlphaChange(1, 1);
                    ivBack.setVisibility(View.VISIBLE);
                    ivRight.setVisibility(View.VISIBLE);
                    tvTitle.setVisibility(View.VISIBLE);


                }else if (isUp && dy > move_distance){

                }else if (isUp && dy <= move_distance){
                    toolbarAlphaChange(dy,move_distance );
                    ivBack.setVisibility(View.INVISIBLE);
                    ivRight.setVisibility(View.INVISIBLE);
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

    private void initTagFlowLayout(){
        final TagFlowLayout skillTagFlow = findView(R.id.tag_skill_required);
        skillTagFlow.setAdapter(new TagAdapter<String>(skillTags) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView textView = (TextView) LayoutInflater.from(context)
                        .inflate(R.layout.tag_s_p_company_f, skillTagFlow,false);
                textView.setText(s);

                return textView;
            }
        });

        final TagFlowLayout teamTagFlow = findView(R.id.tag_team_introduce);
        teamTagFlow.setAdapter(new TagAdapter<String>(welfareTags) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView textView = (TextView) LayoutInflater.from(context)
                        .inflate(R.layout.tag_s_p_company_f, skillTagFlow,false);
                textView.setText(s);

                return textView;
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
