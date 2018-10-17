package com.example.bilibilidemo1.zidingyi;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.example.bilibilidemo1.bean.ArcWerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yida on 2018/6/1.
 */

public class ArcWerView extends View {

    /**
     * 边框的宽度, 字体的颜色和大小
     */
    private int mBorderWith = 2;
    private int mTextColor = Color.GRAY;
    private int mTextSize = 14;

    /**
     * 画笔
     */
    private Paint mPaint;

    /**
     * 每块区域的宽度和高度
     */
    private int mWidth;
    private int mHeight;


    private float[] currentAngle = new float[6]; // 线在动态移动时的角度, 最多支持六个
    private int[] greenX = new int[6]; // 小车动态距离x
    private int[] greenY = new int[6]; // 小车动态距离y

    /**
     * 存储上次的数据, 避免每次移动都是从头开始
     */
    private float[] currentAngleLast = new float[6]; // 记录线在动态移动后的角度, 以便下次在此位置继续
    private int[] greenXLast = new int[6]; // 记录小车移动结束后X的距离;
    private int[] greenYLast = new int[6]; // 记录小车移动结束后Y的距离;
    private int[] mWithLast = new int[6]; // 记录上一个塔吊移动的的距离;
    private int[] prevmoveWith = new int[6]; // 记录上一个塔吊移动的的距离;

    private List<ArcWerBean> mArcWerBeans = new ArrayList<>();

    private int cx, cy, leve;
    // 根据屏幕大小来给每个圆设置大小
    private int width = getContext().getResources().getDisplayMetrics().widthPixels / 6;

    public ArcWerView(Context context) {
        this(context, null);
    }

    public ArcWerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcWerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize= MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthMode;
        } else {
            int desire = (int) (getPaddingTop() + getPaddingRight() + TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics()));
            mWidth = Math.min(desire, widthSize);
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightMode;
        } else {
            int desire = (int) (getPaddingTop() + getPaddingRight() + TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics()));
            mHeight = Math.min(desire, heightSize);
        }

        mWidth = Math.min(mWidth, mHeight); // 取最小的值, 以免绘制的时候数据问题导致绘制出错
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        cx = getPaddingLeft() + (getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) / 2;
        cy = getPaddingTop() + (getMinimumHeight() - getPaddingTop() - getPaddingBottom()) / 2;
        width = Math.min(getWidth() / 6, getHeight() / 6); // 每个圆的半径
        mPaint.setColor(Color.LTGRAY);
        canvas.drawLine(cx, 0, cx, mHeight, mPaint);
        canvas.drawLine(0, cy, mWidth, cy, mPaint);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("0°", cx, 15, mPaint);
        canvas.drawText("90°", mWidth - 15, cy, mPaint);
        canvas.drawText("180°", cx, mWidth - 15, mPaint);
        canvas.drawText("270°", 15, cy, mPaint);

        mPaint.setAntiAlias(true); // 抗锯齿, 去除边缘毛玻璃, 优化绘制

        if (mArcWerBeans != null && mArcWerBeans.size() > 0) {
            for (int i = 0; i < mArcWerBeans.size(); i++) {
                leve = leve != 0 ? mArcWerBeans.get(0).getTwlong() : width; // 获取检测对象的臂长
                int twocx = (int) (cx + (width * mArcWerBeans.get(i).getDistance() / leve* Math.sin(Math.PI * mArcWerBeans.get(i).getAngle() / 180))); // 圆心x
                int twocy = (int) (cy - (width * mArcWerBeans.get(i).getDistance() / leve * Math.cos(Math.PI * mArcWerBeans.get(i).getAngle() / 180))); // 圆心y

                if (i == 0) {

                    mPaint.setColor(Color.BLACK);
                    mPaint.setStyle(Paint.Style.STROKE); // 设置画空心圆
                    mPaint.setStrokeWidth(mBorderWith); // 设置圆环的宽度
                    canvas.drawCircle(cx, cy, width - mBorderWith, mPaint); // 外圆 黑色

                    // 内圆 绿色
                    mPaint.setStyle(Paint.Style.FILL); // 设置实心
                    mPaint.setColor(Color.parseColor("#B2C8F9D2"));
                    canvas.drawCircle(cx, cy, width - mBorderWith, mPaint);
                } else {

                    // 基于圆心的塔机外圆
                    mPaint.setColor(Color.BLACK);
                    mPaint.setStyle(Paint.Style.STROKE); // 设置空心
                    mPaint.setStrokeWidth(mBorderWith); // 设置圆环宽度
                    canvas.drawCircle(twocx, twocy, width * mArcWerBeans.get(i).getTwlong() / leve, mPaint); // 外圆
                    mPaint.setStyle(Paint.Style.FILL); // 实心圆
                }

                // 画塔吊臂
                mPaint.setColor(Color.BLACK);
                canvas.save();
                canvas.rotate(currentAngle[i], twocx, twocy);
                canvas.drawRect(twocx - TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()),
                        twocy - width * mArcWerBeans.get(i).getTwlong() / leve + TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()),
                        twocx + TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics()),
                        twocy + TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()), mPaint);
                canvas.restore();//撤销保存的状态

                // 塔吊红圆心
                mPaint.setColor(Color.RED);
                canvas.drawCircle(twocx, twocy, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,4, getResources().getDisplayMetrics()), mPaint);

                // 塔吊小车
                mPaint.setColor(Color.GREEN);
                canvas.drawCircle(twocx + greenX[i], twocy - greenY[i], TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, getResources().getDisplayMetrics()), mPaint);

                mPaint.setColor(mTextColor);
                mPaint.setTextSize(mTextSize);
                mPaint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(mArcWerBeans.get(i).getName(), twocx, twocy - (width * mArcWerBeans.get(i).getTwlong() / (2 * leve)), mPaint);
            }
        }
    }

    public void setDate(List<ArcWerBean> list) {
        this.mArcWerBeans = list;
        if (mArcWerBeans != null && mArcWerBeans.size() > 0) {
            for (int i = 0; i < mArcWerBeans.size(); i++) {
                currentAngleLast[i] = currentAngle[i];
                greenXLast[i] = greenX[i];
                greenYLast[i] = greenY[i];
                mWithLast[i] = prevmoveWith[i];
                leve = mArcWerBeans.get(0).getTwlong();
                int mMovewidth = width * mArcWerBeans.get(i).getMovewidth() / leve; // 实际值转换为等比例宽度 第一个塔吊的臂长为整个屏幕的1/6
                startCirMotion(mArcWerBeans.get(i).getTwturnAngle(), Math.abs(mMovewidth - mWithLast[i]), i);
            }
        }
    }

    /**
     * 设置塔机字体颜色 要在数据设置之前设置
     * @param color
     */
    public void setmTextColor(int color) {
        mTextColor = color;
    }

    /**
     * 设置塔机字体大小
     * @param size
     */
    public void setmTextSize(int size) {
        mTextSize = size;
    }

    private void startCirMotion(final float angle, final int mwidth, final int i) {
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
        animator.setDuration(3000); // 动画时长3s
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float t = (Float) animation.getAnimatedValue();
                currentAngle[i] = t * angle + currentAngleLast[i];
                float r = t * mwidth + mWithLast[i];
                greenX[i] = (int) (r * Math.sin(Math.PI * currentAngle[i] / 180));
                greenY[i] = (int) (r * Math.cos(Math.PI * currentAngle[i] / 180));
                invalidate();
                prevmoveWith[i] = (int) (t * mwidth);
            }
        });
        animator.setInterpolator(new DecelerateInterpolator()); // 匀速旋转
        animator.start();
    }
}
