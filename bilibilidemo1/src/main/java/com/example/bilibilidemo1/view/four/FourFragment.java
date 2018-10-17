package com.example.bilibilidemo1.view.four;


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
public class FourFragment extends BaseFragment {


    public static FourFragment newInstance() {
        return new FourFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        initToolBar(view, "四");
        return view;
    }

}
