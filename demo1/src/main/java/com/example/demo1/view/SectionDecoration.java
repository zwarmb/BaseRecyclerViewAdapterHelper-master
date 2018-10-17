package com.example.demo1.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;

import com.example.demo1.R;

/**
 * Created by yida on 2018/6/11.
 */

public class SectionDecoration extends RecyclerView.ItemDecoration {

    private DecorationCallback mCallback;
    private TextPaint mTextPaint;
    private Paint.FontMetrics mFontMetrics;
    private int topGap;
    private Paint mPaint;

    public SectionDecoration(DecorationCallback callback, Context context) {
        this.mCallback = callback;
        Resources resources = context.getResources();

        mPaint = new Paint();
        mPaint.setColor(resources.getColor(R.color.colorAccent));

        mFontMetrics = new Paint.FontMetrics();
        mTextPaint = new TextPaint();
        mTextPaint.setColor(Color.BLUE);
        mTextPaint.setTypeface(Typeface.DEFAULT_BOLD); // 设置字体样式为加粗
        mTextPaint.setAntiAlias(true); // 设置抗锯齿
        mTextPaint.getFontMetrics(mFontMetrics);
        mTextPaint.setTextAlign(Paint.Align.LEFT);
        mTextPaint.setTextSize(80);
        topGap = resources.getDimensionPixelSize(R.dimen.dp_40);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos = parent.getChildAdapterPosition(view);
        long groupId = mCallback.getGroupId(pos);
        if (groupId < 0) {
            return;
        }

        if (pos == 0 || isFirstInGroup(pos)) { // 同组的第一个添加padding
            outRect.top = topGap;
        } else {
            outRect.top = 0;
        }

    }
//
//
//    @Override
//    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        super.onDraw(c, parent, state);
//        int left = parent.getPaddingLeft();
//        int right = parent.getWidth() - parent.getPaddingRight();
//        int childCount = parent.getChildCount();
//
//        for (int i = 0; i < childCount; i++) {
//            View view = parent.getChildAt(i);
//            int position = parent.getChildAdapterPosition(view);
//            long groupId = mCallback.getGroupId(position);
//            if (groupId < 0) {
//                return;
//            }
//            String textLine = mCallback.getGroupFirstLine(position).toUpperCase(); // 将字符串转大写
//            if (position == 0 || isFirstInGroup(position)) {
//                float top = view.getTop() - topGap;
//                float bottom = view.getTop();
//                c.drawRect(left, top, right, bottom, mPaint); // 绘制分组头
//                c.drawText(textLine, left, bottom, mTextPaint); // 绘制头文字
//
//            }
//        }
//    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int itemCount = state.getItemCount();
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        float lineHeight = mTextPaint.getTextSize() + mFontMetrics.descent;
        long preGroupId, groupId = -1; for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
            preGroupId = groupId; groupId = mCallback.getGroupId(position);
            if (groupId < 0 || groupId == preGroupId) continue;
            String textLine = mCallback.getGroupFirstLine(position).toUpperCase();
            if (TextUtils.isEmpty(textLine)) continue;
            int viewBottom = view.getBottom();
            float textY = Math.max(topGap, view.getTop());
            if (position + 1 < itemCount) { //下一个和当前不一样移动当前
                long nextGroupId = mCallback.getGroupId(position + 1);
                if (nextGroupId != groupId && viewBottom < textY ) {//组内最后一个view进入了header
                    textY = viewBottom;
                }
            }
            c.drawRect(left, textY - topGap, right, textY, mPaint);

            // 文字居中显示
            float baseLine = textY - (topGap - (mFontMetrics.bottom - mFontMetrics.top)) / 2 + 20;
            c.drawText(textLine, left, baseLine, mTextPaint); // 绘制文字
        }
    }

    private boolean isFirstInGroup(int pos) {
        if (pos == 0) {
            return true;
        } else {
           long prevGroup = mCallback.getGroupId(pos - 1);
           long groupId = mCallback.getGroupId(pos);
            return prevGroup != groupId;
        }
    }

    public interface DecorationCallback {
        long getGroupId(int position);
        String getGroupFirstLine(int position);
    }
}
