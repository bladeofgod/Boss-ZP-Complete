package com.bedrock.boss_zp.adapter.jobs;

import android.content.Context;
import android.graphics.Color;

import java.util.List;

import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import zuo.biao.library.util.Log;

public class VerticalTabAdapter implements TabAdapter {

    private List<String> titles;
    public VerticalTabAdapter(List<String> titleList, Context context) {
        titles = titleList;
        Log.i("tablayout", "size"     + titles.size());

    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public ITabView.TabBadge getBadge(int position) {
        return null;
    }

    @Override
    public ITabView.TabIcon getIcon(int position) {
        return null;
    }

    @Override
    public ITabView.TabTitle getTitle(int position) {
        return new ITabView.TabTitle.Builder()
                .setContent(titles.get(position))
                .setTextColor(Color.BLUE,Color.BLACK)
                .build();
    }

    @Override
    public int getBackground(int position) {
        return 0;
    }
}
