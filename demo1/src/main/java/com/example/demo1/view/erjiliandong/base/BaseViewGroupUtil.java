package com.example.demo1.view.erjiliandong.base;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by yida on 2018/6/21.
 */

public abstract class BaseViewGroupUtil<T extends ViewGroup> {

    protected T mViewGroup;
    public int beginPos;
    public int endPos;

    public BaseViewGroupUtil(T viewGroup) {
        mViewGroup = viewGroup;
    }

    /**
     * 更新视图边界
     */
    public abstract void updateEdges();

    /**
     * 滑动到pos
     * @param pos
     */
    public abstract void smoothScrollTo(int pos);

    /**
     * 选中了position
     * @param position
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setViewSelected(int position) {
        if (!isVisible(position)) {
            return;
        }

//        Stream.of(mViewGroup.getTouchables()).forEach();
        Stream.of(mViewGroup.getTouchables())     // child 必须是 touchable !!!
                .forEach(view -> setViewSelected(view, false)); // 清空状态
    }

    private void setViewSelected(ArrayList<View> view, boolean b) {

    }

    protected void setViewSelected(View view, boolean b) {
        view.setBackgroundColor(b ? Color.WHITE : Color.LTGRAY);
    }

    private void setViewSelected(int position, boolean b) {
        if (getViewByPosition(position) != null) {
            setViewSelected(getViewByPosition(position), b);
        }
    }


    /**
     * 判断pos项是否可见
     * @param pos
     * @return
     */
    public boolean isVisible(int pos) {
        updateEdges();
        return pos >= beginPos && pos <= endPos;
    }

    /**
     * 获取position处的view
     * @param position
     * @return
     */
    private View getViewByPosition(int position) {
        updateEdges();
        return mViewGroup.getChildAt(position - beginPos);
    }

    /**
     * 返回新的newpos, 用来更新旧的position
     * 需注意边界的处理
     * @param pos
     * @return
     */
    public abstract int updatePosOnScrolled(int pos);
}
