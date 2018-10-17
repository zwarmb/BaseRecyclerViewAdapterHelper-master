package com.example.yida.zidinyiview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yida.zidinyiview.R;

/**
 * Created by yida on 2018/9/13.
 */

public class TitleFragment extends Fragment {


    public static Fragment newInstance() {
        TitleFragment titleFragment = new TitleFragment();
        return titleFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title1, container, false);

        return view;

    }
}
