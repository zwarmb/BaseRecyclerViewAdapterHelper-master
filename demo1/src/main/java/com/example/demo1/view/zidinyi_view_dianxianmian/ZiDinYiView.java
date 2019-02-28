package com.example.demo1.view.zidinyi_view_dianxianmian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

/**
 * Created by yida on 2018/12/24.
 */
public class ZiDinYiView extends android.view.View {


    // 画笔
    private Paint mPaint = new Paint();
    // 宽高
    private int mWidth, mHeight;



    public ZiDinYiView(Context context) {
        super(context, null);

        initPaint();
    }

    public ZiDinYiView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initPaint();

    }

    private void initPaint() {

        mPaint.setColor(Color.BLACK);       // 设置画笔颜色
        mPaint.setStrokeWidth(6);           // 设置画笔宽度


//        Paint.Style.FILL 设置为填充
        // Paint.Style.STROKE 设置只绘制图形的边
        // Paint.Style.FILL_AND_STROKE 设置都绘制
        mPaint.setStyle(Paint.Style.FILL);  // 设置画笔模式为填充

        mPaint.setAntiAlias(true);          // 设置消除锯齿


    }


//    /**
//     * 第三个方法是自定义view的style 忽略不用
//     * @param context
//     * @param attrs
//     * @param defStyleAttr
//     */
//    public ZiDinYiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }


    // 测量View的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    // 确定View的大小
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        mWidth = w;
//        mHeight = h;
    }

    // 确定子View的大小
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    // 绘制内容
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制一个点
        canvas.drawPoint(100, 100, mPaint);
        // 绘制一组点
        canvas.drawPoints(new float[]{300, 100, 300, 200, 200, 80}, mPaint);




        /**
         *  绘制一条直线
         */
        canvas.drawLine(0, 0, 420, 66, mPaint);
        // 绘制一组直线( 没四个数字{ 两个点的坐标 } 确定一条线)
        canvas.drawLines(new float[]{
                20, 20, 20, 100,
        50, 80, 80, 120
        }, mPaint);


        /**
         * 绘制一个三角形
         *
         * close 闭环可以把起始点和最终点做一个连线闭环操作
         */
        Path path = new Path();
        path.moveTo(300, 500);
        path.lineTo(500, 500);
        path.lineTo(500, 650);
        path.close();
        canvas.drawPath(path, mPaint);



        /**
         * 方法二和方法三的区别在于 精度不同, Rect 是int(整型)的, 而RectF 是 float(单精度浮点型) 的,
         * 除了精度不同, 两种提供的方法也稍微有些不同
         */
        // 绘制矩形( 方法一 )
        canvas.drawRect(500, 20, 600, 200, mPaint);
        // 方法二
        Rect rect = new Rect(610, 20, 710, 200);
        canvas.drawRect(rect, mPaint);
        // 方法三
        RectF rectF = new RectF(490, 100, 350, 150);
        canvas.drawRect(rectF, mPaint);





        /**
         * 绘制圆角矩形
         *
         * rx, ry
         * 圆角矩形的角实际上不是一个正圆的圆弧, 而是椭圆的圆弧, 这里的两个参数实际上是椭圆的两个半径
         */
        // 方法一
        RectF rectF1 = new RectF(20, 150, 220, 200);
        canvas.drawRoundRect(rectF1, 20, 20, mPaint);
        // 方法二
        canvas.drawRoundRect(20, 220, 220, 300, 20, 20, mPaint);





        /**
         * 绘制圆角矩形的方法绘制椭圆
         *
         * 当rx大于宽度的一半, ry大于高度的一半时, 实际上是无法计算出圆弧的, 所以drawRoundRect对大于该数值的参数进行了限制( 修正 )
         * 凡是大于一半的参数都会按照一半来处理
         */
        // 绘制矩形背景
        RectF rectF2 = new RectF(20, 320, 220, 400);
        canvas.drawRect(rectF2, mPaint);
        mPaint.setColor(Color.RED);
        // 绘制圆角矩形
        canvas.drawRoundRect(rectF2, 400, 160, mPaint);





        /**
         * 绘制椭圆
         */
        RectF rectF3 = new RectF(250, 220, 350, 300);
        canvas.drawOval(rectF3, mPaint);
        // 第二种
        canvas.drawOval(250, 320, 350, 400, mPaint);




        /**
         * 绘制圆
         */
        canvas.drawCircle(400, 270, 50, mPaint);


        /**
         * 绘制圆弧
         *
         * 相比于绘制椭圆, 绘制圆弧还多了三个参数
         *
         * startAngle     开始角度
         * sweepAngle     扫过的角度
         * userCenter     是否使用中心
         */
        RectF rectF4 = new RectF(20, 420, 220, 520);
        // 绘制背景矩形
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rectF4, mPaint);

        // 绘制圆弧   不使用中心
        mPaint.setColor(Color.GRAY);
        canvas.drawArc(rectF4, 0, 90, false, mPaint);

        //////////////////////////////
        RectF rectF5 = new RectF(20, 540, 220, 640);
        // 绘制背景矩形
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rectF5, mPaint);

        // 绘制圆弧   使用中心
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF5, 0, 90, true, mPaint);




        mPaint.setStyle(Paint.Style.STROKE);
        Path path1 = new Path();
        path1.moveTo(600, 250);
        path1.quadTo(700, 400, 600, 600);
        canvas.drawPath(path1, mPaint);


    }


}
