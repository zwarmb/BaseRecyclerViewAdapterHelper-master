package com.example.demo1.view.zidinyi_view_huabu.suofang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yida on 2018/12/25.
 */
public class SuoFang_View extends View {

    private Paint mPaint = new Paint();
    private int mWidth, mHeight;

    public SuoFang_View(Context context) {
        super(context, null);
    }

    public SuoFang_View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    // 初始化画笔
    private void init() {
        mPaint.setColor(Color.BLUE);    // 颜色
        mPaint.setAntiAlias(true);      // 抗锯齿
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        // 绘制十字线
        canvas.drawLines(new float[]{
                0, mHeight / 2, mWidth, mHeight / 2,
                mWidth / 2, 0, mWidth / 2, mHeight
        }, mPaint);

        /**
         * 缩放
         * 以原点为中心来缩放
         */

//        // 恢复原点
//        canvas.translate(0, 0);
//        canvas.scale(1f, 1f, 0, 0);

        // 将画布平移至界面中心
        canvas.translate(mWidth / 2, mHeight / 2);
        mPaint.setColor(Color.BLACK);
        RectF rectF1 = new RectF(0, -150, 150, 0);   // 矩形区域
        canvas.drawRect(rectF1, mPaint);

        canvas.scale(0.5f, 0.5f);           // 画布缩放
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rectF1, mPaint);              // 绘制蓝色矩形


    }
}
