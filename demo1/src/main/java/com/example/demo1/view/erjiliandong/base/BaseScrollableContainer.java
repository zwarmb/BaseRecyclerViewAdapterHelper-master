package com.example.demo1.view.erjiliandong.base;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsListView;

/**
 * Created by yida on 2018/6/21.
 */

public abstract class BaseScrollableContainer<T extends ViewGroup> {

    protected Context mContext;
    public T mViewGroup;

    protected RealOnScrollListener mRealOnScrollListener;
    private EventDispather mEventDispather;


    public void setEventDispather(EventDispather eventDispather) {
        mEventDispather = eventDispather;
    }

    public void disPatchItemSelecontEvent(int curPosition) {
        if (mEventDispather != null) {
//            mEventDispather.disPatchItemSelecontEvent();
            // TODO: 2018/6/21 点击条目操作
        }
    }

    public BaseScrollableContainer(Context context, T viewGroup) {
        mContext = context;
        mViewGroup = viewGroup;

        mRealOnScrollListener = new RealOnScrollListener();

    }

    protected abstract BaseViewGroupUtil<T> getViewUtil();
    protected abstract void setOnScrollListener();



    public class RealOnScrollListener implements AbsListView.OnScrollListener {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    }

    public class EventDispather {

    }
}
