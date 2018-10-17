package com.example.demo1.view.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.demo1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yida on 2018/7/24.
 */

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPagerAdapter mViewPagerAdapter;
    private CycleViewPager mCycleViewPager;
    private List<Integer> mIntegers = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置
        setContentView(R.layout.activity_view_pager);

        initData();
        initView();
    }

    private void initData() {
        mIntegers.add(R.mipmap.sdv_failure);
        mIntegers.add(R.mipmap.ic_launcher);
        mIntegers.add(R.mipmap.sdv_place_holder);
        mIntegers.add(R.mipmap.sdv_progress_bar);
        mIntegers.add(R.mipmap.sdv_retry);

    }

    private void initView() {
        mCycleViewPager = findViewById(R.id.cvp);
        mViewPagerAdapter = new ViewPagerAdapter(this, mIntegers);
        mCycleViewPager.setAdapter(mViewPagerAdapter);
    }

    @Override
    protected void onResume() {
        mCycleViewPager.startPlay(2000);
        super.onResume();
    }

    @Override
    protected void onPause() {
        mCycleViewPager.stopPlay();
        super.onPause();
    }
}
