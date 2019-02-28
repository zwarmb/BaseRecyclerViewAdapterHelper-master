package com.example.demo1.view.zidinyi_view_huabu.PingYi;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.demo1.R;
import com.example.demo1.base.BaseFragment;

/**
 * Created by yida on 2018/12/26.
 */
public class PingYiFragment extends BaseFragment {

    public static PingYiFragment newInstance() {
        return new PingYiFragment();
    }

    @Override
    protected boolean isSupportSwipeBack() {
        return true;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_1;
    }
}
