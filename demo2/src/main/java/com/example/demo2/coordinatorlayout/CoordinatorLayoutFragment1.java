package com.example.demo2.coordinatorlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo2.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yida on 2018/9/25.
 */

public class CoordinatorLayoutFragment1 extends Fragment {


    @BindView(R.id.recycle1)
    RecyclerView mRecycle1;
    Unbinder unbinder;

    public static CoordinatorLayoutFragment1 newInstance() {
        CoordinatorLayoutFragment1 fragment1 = new CoordinatorLayoutFragment1();

        return fragment1;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coor_1, container, false);


        unbinder = ButterKnife.bind(this, view);

        initView();

        return view;
    }

    private void initView() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
