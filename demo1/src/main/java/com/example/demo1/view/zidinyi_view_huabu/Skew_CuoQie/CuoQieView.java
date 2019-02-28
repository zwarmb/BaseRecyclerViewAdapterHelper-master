package com.example.demo1.view.zidinyi_view_huabu.Skew_CuoQie;

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
public class CuoQieView extends View {

    private Paint mPaint = new Paint();
    private int mWidth, mHeight;

    public CuoQieView(Context context) {
        super(context, null);
    }

    public CuoQieView(Context context, @Nullable AttributeSet attrs) {
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


        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rectF = new RectF(0, 0, 200, 200);    // 边长两百的矩形, 在右下角, 因为手机上的坐标轴y 轴是相反的
        mPaint.setColor(Color.LTGRAY);
        canvas.drawRect(rectF, mPaint);                 // 矩形

        /**
         * 错切提供了一个方法
         *
         * public void skew(float sx, float sy)
         */

        /**
         *  sx 将画布在 x 轴方向上倾斜相应的角度, sx 倾斜角度的 tan 值
         *  tan 正切  是∠的对边与临边的比
         *  sy 将画布在 y 轴方向上倾斜相应的角度, sy 为倾斜角度的 tan 值
         */

        /**
         * 根据上面的矩形数据变换后的位置为
         *
         * X = x + sx * y
         * Y = y + sy * x
         */

        /**
         *
         * 矩形的四个点:
         * 一: 0, 0
         * 二: 200, 0
         * 三: 0 + sx * -200,     -200 + sy * 0
         * 四: -200 + sx * -200,  -200 + sy * -200
         *
         * 四点绘制就是一个平行四边形
         */


//        canvas.skew(1, 0);                     // 错切
        canvas.skew(0, 1);                     // 错切

//        mPaint.setColor(Color.RED);
//        canvas.drawRect(rectF, mPaint);


        /**
         * 错切是可以叠加的, 不过需要注意, 调用次序不同绘制结果也不同
         */

        canvas.skew(0.6f, 0);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rectF, mPaint);

    }
}
