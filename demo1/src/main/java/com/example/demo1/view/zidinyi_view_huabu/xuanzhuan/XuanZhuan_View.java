package com.example.demo1.view.zidinyi_view_huabu.xuanzhuan;

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
public class XuanZhuan_View extends View {

    private Paint mPaint = new Paint();
    private int mWidth, mHeight;

    public XuanZhuan_View(Context context) {
        super(context, null);
    }

    public XuanZhuan_View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    // 初始化画笔
    private void init() {
        mPaint.setColor(Color.RED);    // 颜色
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
         *
         * 旋转 180度
         * 以中心点为圆心 从第一象限旋转180度 至 第三象限
         *
         */
        // 将坐标系原点移动到画布正中心
//        canvas.translate(mWidth / 2, mHeight / 2);
//        RectF rectF = new RectF(0, -250, 250, 0);       // 矩形区域
//
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(rectF, mPaint);                         // 绘制黑色矩形
//
//        canvas.rotate(180);         // 旋转180度, 默认旋转中心为原点
//
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF, mPaint);         // 绘制蓝色矩形


        // 将坐标原点移回去
//        canvas.translate(0, 0);
//        canvas.rotate(-180);


//        // 将坐标原点移至3/4处
        canvas.translate(mWidth / 4 * 2, mHeight / 2);
        RectF rectF1 = new RectF(0, -250, 250, 0);      // 原矩形

        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF1, mPaint);

        // 旋转 90度, 到达第二象限并向右平移100dp
        canvas.rotate(90, 100, 0);

        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF1, mPaint);




    }
}
