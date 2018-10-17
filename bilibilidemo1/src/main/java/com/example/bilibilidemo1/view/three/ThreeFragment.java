package com.example.bilibilidemo1.view.three;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends BaseFragment {


    public static ThreeFragment newInstance() {
        return new ThreeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        initToolBar(view, "三");
        return view;
    }

}
