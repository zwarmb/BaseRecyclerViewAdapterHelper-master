package com.example.demo1.view.zidinyi_view_huabu.Skew_CuoQie;

import android.view.View;

import com.example.demo1.R;
import com.example.demo1.base.BaseFragment;

/**
 * Created by yida on 2018/12/26.
 */
public class CuoQieFragment extends BaseFragment {

    public static CuoQieFragment newInstance() {
        return new CuoQieFragment();
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
        return R.layout.fragment_cuoqie1;
    }
}
