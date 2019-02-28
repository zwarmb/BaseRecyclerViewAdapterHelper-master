package com.example.demo1.view.zidinyi_view_huabu.bitmap;

import android.view.View;
import android.widget.Button;

import com.example.demo1.R;
import com.example.demo1.base.BaseFragment;

/**
 * Created by yida on 2019/1/4.
 *
 *
 * 该界面展示drawBitmap 方法  drawPicture 不做展示
 */
public class BitmapFragment extends BaseFragment {


    @Override
    protected boolean isSupportSwipeBack() {
        return true;
    }

    public static BitmapFragment newInstance() {
        return new BitmapFragment();
    }



    @Override
    protected void initView(View view) {
//        Button button = view.findViewById(R.id.btn);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadRootFragment(R.id.fm, OKAnimationFragment.newInstance());
//            }
//        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bitmap1;
    }

}
