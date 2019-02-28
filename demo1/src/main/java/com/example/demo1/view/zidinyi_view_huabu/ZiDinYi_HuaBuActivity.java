package com.example.demo1.view.zidinyi_view_huabu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.demo1.MainActivity;
import com.example.demo1.R;
import com.example.demo1.adapter.Recycleview1Adapter;
import com.example.demo1.view.SectionDecoration;
import com.example.demo1.view.zidinyi_view_huabu.PingYi.PingYiFragment;
import com.example.demo1.view.zidinyi_view_huabu.Skew_CuoQie.CuoQieFragment;
import com.example.demo1.view.zidinyi_view_huabu.bitmap.BitmapFragment;
import com.example.demo1.view.zidinyi_view_huabu.bitmap.OKAnimationFragment;
import com.example.demo1.view.zidinyi_view_huabu.picture_text.PictureOrTextFragment;
import com.example.demo1.view.zidinyi_view_huabu.suofang.SuoFangFragment;
import com.example.demo1.view.zidinyi_view_huabu.text.TextFragment;
import com.example.demo1.view.zidinyi_view_huabu.xuanzhuan.XuanZhuanFragment;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by yida on 2018/12/25.
 */
public class ZiDinYi_HuaBuActivity extends SupportActivity {
    private List<MainActivity.rvBean> mList;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);

        mRecyclerView = findViewById(R.id.rv_demo1_1);

        initRecycleView();

    }

    private void initRecycleView() {
        initData1();

        final Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));

        Recycleview1Adapter recycleview1Adapter = new Recycleview1Adapter(R.layout.rv_demo1_item1, mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = 2;
            }

            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                int childCount = parent.getChildCount();
                int left = parent.getLeft();
                int right = parent.getRight();

                for (int i = 0; i < childCount - 1; i++) {
                    View view = parent.getChildAt(i);
                    float top = view.getBottom();
                    float bottom = view.getBottom() + 2;
                    c.drawRect(left, top, right, bottom, paint);
                }
            }
        });

        mRecyclerView.addItemDecoration(new SectionDecoration(new SectionDecoration.DecorationCallback() {
            @Override
            public long getGroupId(int position) {
                return Character.toUpperCase(mList.get(position).getStr().charAt(0));
            }

            @Override
            public String getGroupFirstLine(int position) {
                return mList.get(position).getStr().substring(0, 1).toUpperCase();
            }
        }, this));

        recycleview1Adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                switch (position) {
                    case 0:
                        Log.e("huabu", "平移");
                        loadRootFragment(R.id.fm, PingYiFragment.newInstance());
                        break;
                    case 1:
                        Log.e("huabu", "缩放");
                        loadRootFragment(R.id.fm, SuoFangFragment.newInstance());
                        break;
                    case 2:
                        Log.e("huabu", "点击了0");
                        loadRootFragment(R.id.fm, XuanZhuanFragment.newInstance());
                        break;
                    case 3:
                        Log.e("huabu", "点击了0");
                        loadRootFragment(R.id.fm, CuoQieFragment.newInstance());
                        break;
                    case 4:
                        loadRootFragment(R.id.fm, PictureOrTextFragment.newInstance());
                        break;
                    case 5:
                        loadRootFragment(R.id.fm, BitmapFragment.newInstance());
                        break;
                    case 6:
                        loadRootFragment(R.id.fm, OKAnimationFragment.newInstance());
                        break;
                    case 7:
                        loadRootFragment(R.id.fm, TextFragment.newInstance());
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(recycleview1Adapter);
    }


    @Override
    public void onBackPressedSupport() {

        if (getSupportFragmentManager().getBackStackEntryCount() >= 1) {
            super.onBackPressedSupport();
        } else {
//            if ((System.currentTimeMillis() - mExitTime) > 2000) {
//                Toasty.normal(this, "再按一次退出程序").show();
//                mExitTime = System.currentTimeMillis();
//            } else {
                finish();
                //System.exit(0);
//            }
        }
    }

    private void initData1() {
        mList = new ArrayList<>();
        String[] strings = {"平移( translate )", "缩放( scale )", "旋转( rotate )", "错切( skew )", "图片与文字( picture or text )", "Bitmap", "对",
        "文字"};

        for (int i = 0; i < /*strings.length*/ 100; i++) {
            MainActivity.rvBean rvBean = new MainActivity.rvBean();
            if (strings.length > i) {
                rvBean.setName(strings[i]);
            } else {
                rvBean.setName("大爷的");
            }
            rvBean.setStr(i + "");
            rvBean.setContent(99 - i + "");
            mList.add(rvBean);
        }
    }
}
