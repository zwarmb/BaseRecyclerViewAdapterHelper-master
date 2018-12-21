package com.example.yida.qq.common.ui.recyclerview.listener;

import android.view.View;

import com.example.yida.qq.common.ui.recyclerview.adapter.IRecyclerView;


public abstract class OnItemLongClickListener<T extends IRecyclerView> extends SimpleClickListener<T> {

    @Override
    public void onItemClick(T adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(T adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(T adapter, View view, int position) {
    }
}
