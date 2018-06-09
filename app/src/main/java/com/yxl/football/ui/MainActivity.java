package com.yxl.football.ui;

import android.graphics.Color;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.yxl.football.view.FixedIndicatorView;
import com.yxl.football.view.IndicatorViewPager;
import com.yxl.football.view.OnTransitionTextListener;
import com.yxl.football.view.SViewPager;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;
    private ArrayList<Tab> mTabs = new ArrayList<Tab>(5);
    private FixedIndicatorView indicator;
    private IndicatorViewPager indicatorViewPager;
    private ArrayList<Fragment> mFragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SViewPager viewPager = (SViewPager) findViewById(R.id.tabmain_viewPager);
        indicator = (FixedIndicatorView) findViewById(R.id.tabmain_indicator);
//        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.RED,
//                Color.GRAY));
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        // 禁止viewpager的滑动事件
        viewPager.setCanScroll(false);
        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(4);
        mFragments.clear();
        mFragments.add(new HomeFragment());
        mFragments.add(new GameFragment());
        mFragments.add(new NewsFragment());
        mFragments.add(new MyFragment());
    }


    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private String[] tabNames = {"首页", "比分", "资讯", "我的"};
        private int[] tabIcons = {R.drawable.tab_home, R.drawable.tab_score, R.drawable.tab_news,
                R.drawable.tab_my};
        private LayoutInflater inflater;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            inflater = LayoutInflater.from(getApplicationContext());
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.tab_item, container, false);
            }
            TextView title = (TextView) convertView.findViewById(R.id.title);
            ImageView image = (ImageView) convertView.findViewById(R.id.image);
            title.setText(tabNames[position]);
            image.setImageResource(tabIcons[position]);
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {

            return mFragments.get(position);
        }
    }

}
