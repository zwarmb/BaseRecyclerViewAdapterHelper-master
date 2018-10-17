package com.example.viewpagerdemo1;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.viewpagerdemo1.transformer.GalleryTransformer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    @butterknife.BindView(R.id.main_vp)
//    ViewPager mMainVp;
//    private int[] mImages = {R.mipmap.b, R.mipmap.d, R.mipmap.e, R.mipmap.f, R.mipmap.g, R.mipmap.h};
//    private ViewPagerDemo1Adapter mViewPagerDemo1Adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        RelativeLayout constraintLayout = findViewById(R.id.cl_main);
//        butterknife.ButterKnife.bind(this);
//        if (mViewPagerDemo1Adapter == null) {
//            mViewPagerDemo1Adapter = new ViewPagerDemo1Adapter(mImages, this);
//        }else {
//            Log.e("111", "不为空");
//            mMainVp.setAdapter(mViewPagerDemo1Adapter);
//            mMainVp.setOffscreenPageLimit(3);
//            mMainVp.setPageMargin(30);
//            mMainVp.setPageTransformer(false, new GalleryTransformer());
//        }
//        // 事件分发, 处理页面的滑动事件
//        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });
//    }

    private RelativeLayout mRelativeLayout;
    private ViewPager mViewPager;
    private int[] mImages = {R.mipmap.b, R.mipmap.d, R.mipmap.e, R.mipmap.f, R.mipmap.g, R.mipmap.h};
    private ViewPagerDemo1Adapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.cl_main);
        mViewPager = (ViewPager) findViewById(R.id.main_vp);
        mViewPagerAdapter = new ViewPagerDemo1Adapter(mImages, this);
        // 设置数量
        mViewPager.setOffscreenPageLimit(3);
        // 设置两边的间距
        mViewPager.setPageMargin(10);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOnClickListener(this);
        mViewPager.setPageTransformer(false, new GalleryTransformer());


        //事件分发，处理页面滑动问题
        mRelativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_vp:
                Toast.makeText(getApplication(), "   ", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
