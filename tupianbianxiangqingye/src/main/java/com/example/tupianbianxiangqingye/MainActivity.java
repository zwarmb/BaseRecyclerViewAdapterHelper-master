package com.example.tupianbianxiangqingye;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ViewPager mViewPager;
    private ZoomHeaderView mZoomHeaderView;
    private boolean isFirst = true;

    private RelativeLayout mRelativeLayout;
    public static int bottomY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mZoomHeaderView = (ZoomHeaderView) findViewById(R.id.zoomHeader);
        mViewPager.setAdapter(new Adapter());
        // 设置viewpager预加载的数量, 默认是一
        mViewPager.setOffscreenPageLimit(4);

        CtrlLinearLayoutManager layoutManager = new CtrlLinearLayoutManager(this);

        // 未展开时禁止滑动
        layoutManager.setScrollEnable(false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new ListAdapter());
        mRecyclerView.setAlpha(0);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rv_bottom);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (isFirst) {
            for (int i = 0; i < mViewPager.getChildCount(); i++) {
                View v = mViewPager.getChildAt(i).findViewById(R.id.ll_bottom);
                v.setY(mViewPager.getChildAt(i).findViewById(R.id.imageView).getHeight());
                v.setX(config.MARGIN_LEFT_RIGHT);
                // 触发一次, 让按钮归位
                mZoomHeaderView.setY(mZoomHeaderView.getY() - 1);
                isFirst = false;
            }
        }

        bottomY = (int) mRelativeLayout.getY();
        mRelativeLayout.setTranslationY(mRelativeLayout.getY() + mRelativeLayout.getHeight());
        mZoomHeaderView.setBottomView(mRelativeLayout, bottomY);
    }

    class Adapter extends PagerAdapter {
        private ArrayList<View> mViews;
        private int[] imgs = {R.mipmap.pic2, R.mipmap.pic3, R.mipmap.pizza};
        public Adapter() {
            mViews = new ArrayList<>();
            mViews.add(View.inflate(getApplicationContext(), R.layout.item_img, null));
            mViews.get(0).findViewById(R.id.btn_buy).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "买买买", Toast.LENGTH_SHORT).show();
                }
            });
            mViews.add(View.inflate(getApplicationContext(), R.layout.item_img, null));
            mViews.add(View.inflate(getApplicationContext(), R.layout.item_img, null));
        }

        @Override
        public int getCount() {
            return mViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            mViews.get(position).findViewById(R.id.imageView).setBackgroundResource(imgs[position]);
            container.addView(mViews.get(position));
            return mViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViews.get(position));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if (mZoomHeaderView.isExpand()) {
            mZoomHeaderView.restore(mZoomHeaderView.getY());
        } else {
            finish();
        }
    }
}
