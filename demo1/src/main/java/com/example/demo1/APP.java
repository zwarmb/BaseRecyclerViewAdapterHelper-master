package com.example.demo1;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshInitializer;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

/**
 * Created by yida on 2018/7/26.
 */

public class APP extends Application {

    static {

        SmartRefreshLayout.setDefaultRefreshInitializer(new DefaultRefreshInitializer() {
            @Override
            public void initialize(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setDragRate(0.3f); // 显示下拉高度 / 手指真实下拉高度 = 阻尼效果
                layout.setReboundDuration(300); // 拉完回弹效果动画时长
                layout.setHeaderHeight(60); //设置下拉高度



            }
        });

    }

}
