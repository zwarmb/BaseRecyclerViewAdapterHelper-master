package com.example.bilibilidemo1.view.home.home2;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

/**
 * Created by yida on 2018/2/8.
 *
 * 该类工作与ItemTouchHelper和你的app之间，起一个桥梁的作用
 * 主要负责，定义用户drag和swipe的方向，以及当户产生了指定手势会收到相应的回调方法
 */

public class ItemTouchHelperCallBack extends ItemTouchHelper.Callback {
    private OnItemPositionChangeListener mOnItemPositionChangeListener;

    public ItemTouchHelperCallBack(OnItemPositionChangeListener onItemPositionChangeListener) {
        mOnItemPositionChangeListener = onItemPositionChangeListener;
    }

    public interface OnItemPositionChangeListener {
        boolean onItemMove(int fromPos, int toPos);
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Log.e("111", "移动事件");
        final int dragFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN;

        return makeMovementFlags(dragFlags, 0);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Log.e("111", "onMove");
        if (mOnItemPositionChangeListener != null) {
            return mOnItemPositionChangeListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        }
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Log.e("111", "onSwiped");
    }
}
