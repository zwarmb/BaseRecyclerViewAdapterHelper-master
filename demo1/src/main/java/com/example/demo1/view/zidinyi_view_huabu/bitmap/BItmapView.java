package com.example.demo1.view.zidinyi_view_huabu.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.demo1.R;

/**
 * Created by yida on 2019/1/4.
 */
public class BItmapView extends View {
    private Paint mPaint;
    private int mWidth, mHeight;


    public BItmapView(Context context) {
        super(context, null);
    }

    public BItmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化工具
     */
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);

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

        // 绘制一组点 做对比
        canvas.drawPoints(new float[]{100, 20, 200, 20, 300, 20, 400, 20, 500, 20, 600, 20, 700, 20}, mPaint);
        canvas.drawPoints(new float[]{20, 100, 20, 200, 20, 300, 20, 400, 20, 500, 20, 600, 20, 700, 20, 800, 20, 900}, mPaint);


        /**
         * 通过 BitmapFactory 从不同位置获取 bitmap
         *
         * 资源文件( drawable/mipmap/raw )
         * Bitmap bitmap = BitmapFactory.decodeResource( mContext.getResources(), R.raw.bitmap );
         *
         *
         * 资源文件( assets )
         * Bitmap bitmap = null;
         * try {
         *     InputStream is = mContext.getAssets().open(" bitmap.png ");
         *     bitmap = BitmapFactory.decodeStream(is);
         *     is.close();
         * } catch( IOException e ) {
         *     e.printStackTrace();
         * }
         *
         *
         * 内存卡文件:
         * Bitmap bitmap = BitmapFactory.decodeFile("/sdcard/bitmap.png");
         *
         *
         * 网络文件:
         * // 此处省略获取网络输入流的代码
         * Bitmap bitmap = BitmapFactory.decodeStream(is);
         * is.close();
         */


        /**
         * 第一种也是最简单的绘制方法,
         */
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_33);
        // Matrix 矩阵, 支持四种基本变换  平移,旋转,缩放,错切

        canvas.drawBitmap(bitmap, new Matrix(), mPaint);


        /**
         * z这种方法中间多了两个参数是从这个点再开始绘制
         * 就是这张bitmap 左上角距离原点的距离
         */
        canvas.drawBitmap(bitmap, 300, 500, mPaint);


        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_555);
        canvas.translate(0, mHeight / 2);
        // 指定图片绘制区域( 左上角四分之一 )
        Rect src = new Rect(0, 0, bitmap1.getWidth() / 2, bitmap1.getHeight() / 2);
        // 指定图片显示的区域
        Rect dst = new Rect(0, 0, 200, 300);
        canvas.drawBitmap(bitmap1, src, dst, mPaint);



    }
}
