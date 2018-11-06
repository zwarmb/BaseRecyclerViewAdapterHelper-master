package com.example.yida.demo3.ui.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yida.demo3.R;

/**
 * Created by yida on 2018/10/24.
 */
public class MainFragment extends Fragment {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        initData();


        return view;
    }


    private void initData() {


    }
}
