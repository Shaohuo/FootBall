package com.yxl.football.ui;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.yxl.football.R;
import com.yxl.football.entiy.Tab;
import com.yxl.football.ui.GameFragment;
import com.yxl.football.ui.HomeFragment;
import com.yxl.football.ui.MyFragment;
import com.yxl.football.ui.NewsFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;
    private ArrayList<Tab> mTabs = new ArrayList<Tab>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
    }

    private void initTab() {
        //实例化5个Tab类的对象
        Tab Tab_home = new Tab(R.drawable.tab_home, R.string.home, HomeFragment.class);
        Tab Tab_score = new Tab(R.drawable.tab_score, R.string.score, GameFragment.class);
        Tab Tab_news = new Tab(R.drawable.tab_news, R.string.news, NewsFragment.class);
        Tab Tab_my = new Tab(R.drawable.tab_my, R.string.my, MyFragment.class);

        //将这5个对象加到一个List中
        mTabs.add(Tab_home);
        mTabs.add(Tab_score);
        mTabs.add(Tab_news);
        mTabs.add(Tab_my);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realcontent);
        mInflater = LayoutInflater.from(this);

        //通过循环实例化一个个TabSpec
        //并调用其中setIndicator方法
        //然后将TabSpec加到TabHost中
        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(String.valueOf(tab.getText()));
            tabSpec.setIndicator(buildView(tab));
            mTabHost.addTab(tabSpec, tab.getFragment(), null);
        }

        //通过这行代码可以去除掉底部菜单5个图表之间的分割线
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
    }

    //设置Indicator中的View
    private View buildView(Tab tab) {
        View view = mInflater.inflate(R.layout.tab_item, null);
        ImageView Tab_img = (ImageView) view.findViewById(R.id.image);
        TextView Tab_txt = (TextView) view.findViewById(R.id.title);

        Tab_img.setBackgroundResource(tab.getImage());
        Tab_txt.setText(tab.getText());
        return view;
    }

}
