package com.example.bilibilidemo1.view.home.coordinator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.base.BaseFragment;

/**
 * Created by yida on 2018/5/9.
 */

public class CoordinatorFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coordinator, container, false);

        initView();

        return view;
    }

    //
    private void initView() {


    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
