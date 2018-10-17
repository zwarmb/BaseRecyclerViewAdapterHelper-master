package com.example.yida.zidinyiview.zidinyiview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

/**
 * Created by yida on 2018/9/10.
 */

public class AnimationUtils {

    // 旋转动画
    public static RotateAnimation initRotateAnimation(long duration, int fromAngle, int toAngle, boolean isFillAfter, int repeatCount) {


        /**
         * int pivotXValue, 动画在 x 轴相对于物件位置类型, 与下面的pivotXValue 结合, 确定 x 轴上旋转中心.
         *可能值为：Animation.ABSOLUTE，Animation.RELATIVE_TO_SELF, Animation.RELATIVE_TO_PARENT
         * 如果是 Animation.ABSOLUTE : 则此参数为旋转中心在屏幕上 x 轴的值
         * RELATIVE_TO_PARENT : 则参数 pivotXValue 为旋转中心在父控件水平位置百分比, 如: 0.5 表示在父控件水平方向中间位置;
         * RELATIVE_TO_SELF : 则参数 pivotXValue 为旋转中心在控件自身水平位置百分比, 如果 x 和 y 的value 都是0.5, 则该控件以自身中心旋转.
         */
        RotateAnimation animation = new RotateAnimation(fromAngle, toAngle, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);


        /**
         * InterPolator ( 插值器 ) 这个属性是用来设置转动速率的, 有很多种类型
         * LinearInterpolator 为匀速效果,
         * DecelerateInterpolator 为减速效果
         *
         * repeatCount 重复的次数, 默认为0, 必须是 int , 可以为 -1 ,表示无限,  只有大于0 或者为 infinite(无限) 时生效
         *
         * duration 表示自 fromAngle(开始角度) 至 toAngle(结束角度) 所转动花费的时间, 单位为毫秒, 可以用来计算速度
         *
         * repeatMode 重复的模式, 即动画执行一次之后的持续效果, 默认为 restart , 即重头开始重新运行, 可以为 reverse, 即从结束位置开始向前重新运行
         *
         */

        LinearInterpolator linearInterpolator = new LinearInterpolator(); // 转动速率, 这里的是匀速转动
        animation.setInterpolator(linearInterpolator);
        animation.setDuration(duration); // 旋转一周时长
        animation.setFillAfter(isFillAfter);
        animation.setRepeatCount(repeatCount); // 重复次数
        animation.setRepeatMode(Animation.RESTART);
        return animation;
    }

    public static RotateAnimation initRotateAnimation(boolean isClockWise, long duration, boolean isFillAfter, int repeatCount) {
        int endAngle;
        if (isClockWise) {
            endAngle = 360;
        } else {
            endAngle = -360;
        }
        RotateAnimation animation = new RotateAnimation(0, endAngle, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        animation.setInterpolator(linearInterpolator);
        animation.setRepeatCount(repeatCount);
        animation.setFillAfter(isFillAfter);
        animation.setDuration(duration);
        animation.setRepeatMode(Animation.RESTART);
        return animation;
    }

    public static AnimationDrawable initAnimationDrawable(Context context, int[] drawableIds, int durationTime, boolean isOneShot) {
        AnimationDrawable drawable = new AnimationDrawable();
        for (int i = 0; i < drawableIds.length; i++) {
            int id = drawableIds[i];
            drawable.addFrame(context.getResources().getDrawable(id), durationTime);
        }
        drawable.setOneShot(isOneShot);
        return drawable;
    }

    /**
     * duration : 动画持续的时长, 单位是毫秒
     *
     * fromAlpha : 动画开始的透明度, 取值 0.0-1.0, 0.0 表示完全透明, 1.0 表示保持原有状态不变
     *
     * toAlpha : 动画结束时的透明度, 取值 同上( fromAlpha )
     *
     * fillAfter : 动画结束后是否保持动画的最终状态, true: 表示保持最终状态
     *
     * fillBefore : 动画结束之后是否保持动画开始前的状态, true: 表示恢复到动画开始之前的状态
     *
     *
     *
     */
    public static Animation initAlphaAnimation(Context context, float fromAlpha, float toAlpha, long duration) {
        Animation animation = new AlphaAnimation(fromAlpha, toAlpha);
        animation.setDuration(duration);
        return animation;
    }
}
