package com.example.demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.demo1.adapter.Main2Adapter;
import com.example.demo1.view.AdImageViewService1;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<MainActivity.rvBean> mList;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        VideoView videoView = findViewById(R.id.vv_video);
//        videoView.setVideoPath(Environment.getExternalStorageDirectory().);


        mRecyclerView = findViewById(R.id.rv_demo1_main2);
        List<String> mockDatas = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            mockDatas.add(i + "");
//        }
        initData1();
        Main2Adapter main2Adapter = new Main2Adapter(R.layout.item_main2, mList);
        mRecyclerView.setLayoutManager(mLinearLayoutManager = new LinearLayoutManager(this));

        mRecyclerView.setAdapter(main2Adapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int fPos = mLinearLayoutManager.findFirstVisibleItemPosition();
                int lPos = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                for (int i = fPos; i < lPos; i++) {
                    View view = mLinearLayoutManager.findViewByPosition(i);
                    AdImageViewService1 adImageViewService1 = view.findViewById(R.id.id_iv_ad);
                    if (adImageViewService1.getVisibility() == View.VISIBLE) {
                        adImageViewService1.setDy(mLinearLayoutManager.getHeight() - view.getTop() - 100);
                    }
                }
            }
        });
    }

    private void initData1() {
        mList = new ArrayList<>();
        for (int i = 10; i < 99; i++) {
            MainActivity.rvBean rvBean = new MainActivity.rvBean();
            rvBean.setStr(i + "");
            rvBean.setContent(99 - i + "");
            mList.add(rvBean);
        }
    }
}
