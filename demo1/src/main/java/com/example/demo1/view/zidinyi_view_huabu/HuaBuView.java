package com.example.demo1.view.zidinyi_view_huabu;

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
public class HuaBuView extends View {

    private Paint mPaint = new Paint();
    private int mWidth, mHeight;

    public HuaBuView(Context context) {
        super(context, null);
    }

    public HuaBuView(Context context, @Nullable AttributeSet attrs) {
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
         * 平移
         */
//        // 蓝色圆形
//        canvas.translate(200, 200);
//        canvas.drawCircle(0, 0, 100, mPaint);
//
//        mPaint.setColor(Color.BLACK);
//        canvas.translate(200, 200);
//        canvas.drawCircle(0, 0, 100, mPaint);


        /**
         * 缩放加平移
         */
//        // 将画布平移至界面中心
//        canvas.translate(mWidth / 2, mHeight / 2);
//        mPaint.setColor(Color.BLACK);
//        RectF rectF = new RectF(0, -200, 200, 0);   // 矩形区域
//        canvas.drawRect(rectF, mPaint);
//
//        canvas.scale(0.5f, 0.5f, 100, 0);                   // 画布缩放    缩放中心向右偏移100个单位
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF, mPaint);
        /**
         * 缩放
         * 以原点为中心来缩放
         */
        // 将画布平移至界面中心
//        canvas.translate(mWidth / 2, mHeight / 2);
//        mPaint.setColor(Color.BLACK);
//        RectF rectF = new RectF(0, -200, 200, 0);   // 矩形区域
//        canvas.drawRect(rectF, mPaint);
//
//        canvas.scale(0.5f, 0.5f);           // 画布缩放
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF, mPaint);              // 绘制蓝色矩形





        /**
         * 翻转
         */
        // 将坐标系原点移动到画布中心
//        canvas.translate(mWidth / 2, mHeight / 2);
//
//        RectF rectF = new RectF(0, -200, 200, 0);   // 矩形区域
//        mPaint.setColor(Color.BLACK);               // 绘制黑色区域
//        canvas.drawRect(rectF, mPaint);
//
//        canvas.scale(-0.5f, -0.5f);         // 画布缩放
//
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF, mPaint);


        /**
         * 翻转
         *
         * 默认的缩放中心是坐标原点, 现在是移入中心点为坐标原点
         * 本次缩放可以看做是先根据缩放中心( 坐标原点 ) 缩放到原来的0.5 倍, 然后分别按照 x 轴和 y 轴进行翻转
         */
        // 将坐标系原点移动到画布中心
//        canvas.translate(mWidth / 2, mHeight / 2);
//        RectF rectF = new RectF(0, -200, 200, 0);   // 矩形区域
//        mPaint.setColor(Color.BLACK);       // 绘制黑色区域
//        canvas.drawRect(rectF, mPaint);
//
//        canvas.scale(-0.5f, -0.5f, 100, 0);     // 画布缩放     缩放中心向右平移100单位
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF, mPaint);


        /**
         * 连续缩放 + 旋转
         */
        // 将坐标原点移动到画布中心
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rectF1 = new RectF(-200, -200, 200, 200);                     // 矩形区域
        for (int i = 0; i < 30; i++) {
            // 缩放
            canvas.scale(0.9f, 0.9f);
            // 绘制矩形
            canvas.drawRect(rectF1, mPaint);
            // 旋转
//            canvas.drawRect(rectF1, mPaint);
            canvas.rotate(5f);
        }
    }
}
