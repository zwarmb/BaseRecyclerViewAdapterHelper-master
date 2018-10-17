package com.example.demo1.view.qqSpace;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by yida on 2018/6/28.
 */

public class SpaceImageView extends android.support.v7.widget.AppCompatImageView {

    private Context mContext;

    private ViewTreeObserver mViewTreeObserver = null;
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener = null;
    private Bitmap bm = null;
    private int screenHeight = 0; // 屏幕高度

    private float scale = 1;      // 图片 的缩放比例
    private float oriYAbs = 0, oriXAbs = 0, oriRAbs = 0;  // 记录比例放大后的圆的圆点和半径， 用于判断点击位置

    public static final int CLICK_SPACE = 0;  // 点击空白处
    public static final int CLICK_RANGE = 1;  // 点击在圆上
    private int where_click = 0;  // 用于返回点击在哪里

    public SpaceImageView(Context context) {
        super(context);
        mContext = context;
        this.setScaleType(ScaleType.CENTER_CROP);
    }

    public SpaceImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        this.setScaleType(ScaleType.CENTER_CROP);
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
    }

    @Override
    public void setImageResource(int resId) {
        Drawable drawable = ContextCompat.getDrawable(mContext, resId);
        setImageDrawable(drawable);
//        super.setImageResource(resId);
    }

    @Override
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            bm = drawableToBitmap(drawable);
        }

        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        screenHeight = dm.heightPixels;

        mViewTreeObserver = getViewTreeObserver();
        mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {

            }
        };
    }

    private Bitmap getSpaceBitmap(Bitmap bitmap, int r, int orix, int oriy) {

        Paint paint = new Paint();
        paint.setAntiAlias(true);

        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        // TODO: 2018/6/29 返回一个bitmap
        return output;

    }


    /**
     * 将drawable转化为bitmap
     * @param drawable
     * @return
     */
    private Bitmap drawableToBitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    private float getScale(Bitmap bitmap, float vw, float vh) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float scale = 1;
        scale = vw / width > vh / height ? vw / width : vh / height;
        return scale;
    }
}
