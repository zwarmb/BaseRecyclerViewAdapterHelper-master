package com.example.demo1;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.demo1.adapter.Recycleview1Adapter;
import com.example.demo1.view.SectionDecoration;
import com.example.demo1.view.SimpleDraweeView.SimpleDraweeViewActivity;
import com.example.demo1.view.fang_qq_space.ShadeActivity;
import com.example.demo1.view.glide.GlideTestActivity;
import com.example.demo1.view.huaweishichang_search.HuaWeiActivity;
import com.example.demo1.view.leida.LeidaActivity;
import com.example.demo1.view.pai_xu.PaiXuActivity;
import com.example.demo1.view.viewpager.ViewPagerActivity;
import com.example.demo1.view.zhe_die_lan.ZhedieActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<rvBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        if (Build.VERSION.SDK_INT >= 21) {
//            View view = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
//            view.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//        }
//        // 去掉toolbar
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        setContentView(R.layout.main3);

        init1();

        initRightLinear();

    }

    // 处理右边的操作
    private void initRightLinear() {
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GlideTestActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init1() {
        RecyclerView recyclerView = findViewById(R.id.rv_demo1_1);
        initData1();

        final Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
        Recycleview1Adapter recycleview1Adapter = new Recycleview1Adapter(R.layout.rv_demo1_item1, mList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
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

        recyclerView.addItemDecoration(new SectionDecoration(new SectionDecoration.DecorationCallback() {
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
                        // 点击进入main2
                        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), Fragment1.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), LeidaActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getApplicationContext(), SimpleDraweeViewActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getApplicationContext(), ViewPagerActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getApplicationContext(), ShadeActivity.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getApplicationContext(), PaiXuActivity.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(getApplicationContext(), HuaWeiActivity.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(getApplicationContext(), ZhedieActivity.class);
                        startActivity(intent8);
                        break;
                }
            }
        });
        recyclerView.setAdapter(recycleview1Adapter);
    }

    private void initData1() {
        mList = new ArrayList<>();
        String[] strings = {"仿网易广告滚动显示", "条目滚动", "雷达属性", "glide", "轮播图", "仿QQ空间广告显示", "排序", "仿华为应用市场搜索", "折叠栏"};

        for (int i = 0; i < /*strings.length*/ 100; i++) {
            rvBean rvBean = new rvBean();
//            for (int j = 0; j < strings.length; j++) {
//                rvBean.setStr(strings[j]);
//
//            }
            if (strings.length > i) {
                rvBean.setName(strings[i]);
            } else {
                rvBean.setName("大爷的");
            }
            rvBean.setStr(i + "");
            rvBean.setContent(99 - i + "");
            mList.add(rvBean);
        }


//        mList.addAll(rvBean.setStr(""), rvBean.setContent(""));
//        mList.addAll(new rvBean("", ""));
    }


    public static class rvBean {
        String str;
        String content;
        String name;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
