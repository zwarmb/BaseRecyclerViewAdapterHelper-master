package com.example.bilibilidemo1.view.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.base.BaseFragment;

/**
 * Created by yida on 2018/2/3.
 */

public class Home4Fragment extends BaseFragment {

    public static Home4Fragment newInstance() {
        return new Home4Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_li, container, false);


        return view;
    }

}
