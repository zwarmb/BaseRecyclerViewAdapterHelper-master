package com.example.demo2.coordinatorlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.demo2.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yida on 2018/9/25.
 */

public class CoordinatorLayoutActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.main_backdrop)
    ImageView mMainBackdrop;
    @BindView(R.id.main_collapsing)
    CollapsingToolbarLayout mMainCollapsing;
    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.main_appbar)
    AppBarLayout mMainAppbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        ButterKnife.bind(this);


        initFragment();

    }

    private void initFragment() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(CoordinatorLayoutFragment1.newInstance());
        fragments.add(CoordinatorLayoutFragment1.newInstance());

        mTabs.addTab(mTabs.newTab().setText("大王"));
        mTabs.addTab(mTabs.newTab().setText("小王"));
        mTabs.setupWithViewPager(mViewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, new String[]{"大王", "小王"});
        mViewpager.setAdapter(adapter);
        mViewpager.setOffscreenPageLimit(2);
        mViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));

    }
}
