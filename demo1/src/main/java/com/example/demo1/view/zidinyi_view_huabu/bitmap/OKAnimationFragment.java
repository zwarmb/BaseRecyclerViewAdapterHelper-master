package com.example.demo1.view.zidinyi_view_huabu.bitmap;

import android.view.View;
import android.widget.Button;

import com.example.demo1.R;
import com.example.demo1.base.BaseFragment;

/**
 * Created by yida on 2019/1/22.
 */
public class OKAnimationFragment extends BaseFragment {

    public static OKAnimationFragment newInstance() {
        return new OKAnimationFragment();
    }


    @Override
    protected void initView(View view) {
        OkAnimationView view1 = view.findViewById(R.id.okanimationview);
        Button check = view.findViewById(R.id.btn_check);
        Button unCheck = view.findViewById(R.id.btn_uncheck);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.check();
            }
        });
        unCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.unCheck();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ok_amt;
    }
}
