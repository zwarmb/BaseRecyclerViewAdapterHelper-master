package com.example.demo1.view.jingdong1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.demo1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yida on 2018/6/22.
 */

public class JingDongActivity extends AppCompatActivity {

    private ListView mLeftView;
    private ListView mRightView;

    private List<String> menuList = new ArrayList<>();
    private List<JingDongBean.DataBean> mDataBeans = new ArrayList<>();
    private List<Integer> mIntegers;

//    private ListView list_menu;
//    private ListView list_home;

    private MenuAdapter mMenuAdapter;
    private HomeAdapter mHomeAdapter;
    private int currentItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jingdong1);


        initView();
        initData();

//        mMenuAdapter = new MenuAdapter(getApplicationContext(), menuList);

    }

    private void initView() {
        mLeftView = findViewById(R.id.rv_left_jingdong1);
        mRightView = findViewById(R.id.rv_right_jingdong1);

        mMenuAdapter = new MenuAdapter(getApplicationContext(), menuList);
        mLeftView.setAdapter(mMenuAdapter);
        mHomeAdapter = new HomeAdapter(getApplicationContext(), mDataBeans);
        mRightView.setAdapter(mHomeAdapter);

        mLeftView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        mRightView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    private void initData() {
        String json = getJson(this, "category.json");
    }

    private String getJson(Context context, String s) {
        StringBuilder sb = new StringBuilder();

        return null;
    }
}
