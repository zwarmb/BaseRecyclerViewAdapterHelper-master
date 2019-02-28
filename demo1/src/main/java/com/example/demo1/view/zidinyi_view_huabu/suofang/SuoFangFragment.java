package com.example.demo1.view.zidinyi_view_huabu.suofang;

import android.view.View;

import com.example.demo1.R;
import com.example.demo1.base.BaseFragment;

/**
 * Created by yida on 2018/12/26.
 */
public class SuoFangFragment extends BaseFragment {

    public static SuoFangFragment newInstance() {
        return new SuoFangFragment();
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
        return R.layout.fragment_sf1;
    }
}
