package com.example.demo1.view.zidinyi_view_huabu.text;

import android.view.View;

import com.example.demo1.R;
import com.example.demo1.base.BaseFragment;

/**
 * Created by yida on 2019/1/28.
 */
public class TextFragment extends BaseFragment {

    public static TextFragment newInstance() {
        return new TextFragment();
    }


    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.text_fragment;
    }



}
//public class Singleton{
//    private static class SingletonHolder{
//        public static Singleton sSingleton = new Singleton();
//    }
//
//    private static Singleton sSingleton = new Singleton();
//
//    private Singleton() {}
//
//    public Singleton getSingleton() {
//        return SingletonHolder.sSingleton;
//    }
//}
