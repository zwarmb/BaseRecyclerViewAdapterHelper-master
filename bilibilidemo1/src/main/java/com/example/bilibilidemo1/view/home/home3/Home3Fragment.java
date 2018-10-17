package com.example.bilibilidemo1.view.home.home3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bilibilidemo1.R;
import com.example.bilibilidemo1.base.BaseFragment;
import com.example.bilibilidemo1.zidingyi.MyText;

/**
 * Created by yida on 2018/2/3.
 */

public class Home3Fragment extends /*SimpleFragment<Home3Presenter> implements Home3Contract.View*/BaseFragment {

//    @BindView(R.id.mytext)
//    MyText mMytext;

    public static Home3Fragment newInstance() {
        return new Home3Fragment();
    }


//    @Override
//    protected void initView(View view) {
//        unbinder = ButterKnife.bind(this, view);
//        MyText myText = new MyText(getContext());
//        myText.setAlpha(0.5f);
//    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.fragment_home_three_canvas;
//    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
//        return new myView(getContext());
        return new MyText(getContext());
    }

    class myView extends View {
        Paint mPaint;

        public myView(Context context) {
            super(context);
            initPaint();
        }

        public myView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        private void initPaint() {
            // 初始化画笔
            mPaint = new Paint();
            mPaint.setColor(getResources().getColor(R.color.bleak_text)); // 设置画笔的颜色
            /**
             * Paint.Style.STROKE 只绘制图形轮廓（描边）
               Paint.Style.FILL 只绘制图形内容
               Paint.Style.FILL_AND_STROKE 既绘制轮廓也绘制内容
             */
            mPaint.setStyle(Paint.Style.FILL); // 设置画笔的样式
            mPaint.setStrokeWidth(5); // 设置画笔的宽度
            mPaint.setAntiAlias(true); // 设置抗锯齿, 去除边角毛刺
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawPoint(100, 100, mPaint); // 绘制一点
            canvas.drawPoints(new float[]{200, 200, 300, 300, 400, 400}, mPaint); // 绘制多个点
            canvas.drawLine(200, 200, 200, 500, mPaint); // 绘制一条直线
            canvas.drawLines(new float[]{120, 120, 120, 520, 220, 220, 220, 620, 120, 550, 220, 650}, mPaint); // 绘制多条直线
            canvas.drawRect(20, 20, 200, 80, mPaint); // 绘制矩形

            // 绘制圆角矩形
                // 方法一
//            canvas.drawRoundRect(220, 20, 420, 80, 20, 20, mPaint);  // api 21 加入
                // 方法二
            RectF rectF = new RectF(220, 20, 420, 80);
            canvas.drawRoundRect(rectF, 25, 25, mPaint);

            // 绘制椭圆一种笨拙的方法, 当你设置的圆弧的x, y 大于等于该矩形的一半时, 矩形会变成椭圆
            mPaint.setColor(getResources().getColor(R.color.colorAccent));
            canvas.drawRoundRect(rectF, 100, 60, mPaint);

            // 绘制椭圆
//            canvas.drawOval(450, 20, 650, 80, mPaint);
            RectF rectF1 = new RectF(450, 20, 650, 80);
            canvas.drawOval(rectF1, mPaint);

            // 绘制圆
            canvas.drawCircle(420, 220, 50, mPaint); // x, y 是圆的圆心, radios是半径

            // 绘制圆弧
            RectF rectF2 = new RectF(300, 550, 600, 650);
            canvas.drawArc(rectF2, 0, 90, false, mPaint); // startAngle 起始角度, sweepAngle 扫过的角度
            canvas.drawArc(rectF2, 90, 90, false, mPaint); // startAngle 起始角度, sweepAngle 扫过的角度

            RectF rectF3 = new RectF(300, 650, 600, 750);
            canvas.drawArc(rectF3, 180, 90, false, mPaint); // startAngle 起始角度, sweepAngle 扫过的角度
            canvas.drawArc(rectF3, 270, 90, false, mPaint); // startAngle 起始角度, sweepAngle 扫过的角度

            RectF rectF4 = new RectF(450, 500, 550, 800);
            canvas.drawArc(rectF4, 90, 90, false, mPaint); // startAngle 起始角度, sweepAngle 扫过的角度
            canvas.drawArc(rectF4, 180, 90, false, mPaint); // startAngle 起始角度, sweepAngle 扫过的角度

            RectF rectF5 = new RectF(350, 500, 450, 800);
            canvas.drawArc(rectF5, 0, 90, false, mPaint); // startAngle 起始角度, sweepAngle 扫过的角度
            canvas.drawArc(rectF5, 270, 90, false, mPaint); // startAngle 起始角度, sweepAngle 扫过的角度


        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
