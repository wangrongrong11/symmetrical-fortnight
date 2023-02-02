package com.example.View;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.DynamicAnimation;

import com.example.loginapplication.R;

public class LoadingView extends View {
    private static final String TAG = "LoadingView";

    //定义控件的宽高
    private float mWidth, mHeight;
    //小圆围绕大圆旋转的半径
    private float rotationRadius;
    //围绕中心点位置
    private PointF core;
    //小圆点的半径
    private float miniCircleRadius;
    //小圆的颜色
    private int[] colors;
    //小圆的画笔
    private Paint mPaint;
    //旋转角度，定义圆心正上方零度
    private double deltaAngle = 0.0;

    //透明度
    private double mAlpha = 100.0;

    //属性动画
    private ValueAnimator mValueAnimator;
    //private AnimationEndListener mAnimationEndListener;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initRes(context, attrs, defStyleAttr);
    }

    private void initRes(Context context, AttributeSet attrs, int defStyleAttr) {
        //初始化小圆的画笔
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        core = new PointF();
    }

    //对外提供接口，开始动画
    public void startAnimator(){
        //重置初始值
        resetValue();
        //执行动画
        getRotationAnimator();
    }

    public void stopAnimator(){
        if (mValueAnimator != null){
            mValueAnimator.cancel();
            mValueAnimator = null;
        }
    }

    private void resetValue() {
        Log.d(TAG, "resetValue: .....");
        deltaAngle = 0;
        rotationRadius = mWidth / 3;
    }

    private void getRotationAnimator() {
        if(mValueAnimator != null){
            mValueAnimator.cancel();
            mValueAnimator = null;
        }
        mValueAnimator = new ValueAnimator();
        mValueAnimator.setFloatValues(0,1);
        mValueAnimator.setDuration(1500);
        mValueAnimator.addUpdateListener(this::dealWithValue);
        mValueAnimator.setInterpolator(new LinearInterpolator());
        mValueAnimator.setRepeatCount(ValueAnimator.INFINITE);
/*        mValueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                resetValue();
                setAnimationEnd();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                setAnimationEnd();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                resetValue();
            }
        });*/
        mValueAnimator.start();
    }

    /**
     * 开始绘制参数
     * */
    public void dealWithValue(ValueAnimator animator){
        float value = (float) animator.getAnimatedValue();
        Log.d(TAG, "dealWithValue: value = "+value);
        deltaAngle = value * 2 * Math.PI;
        //重绘制
        invalidate();

    }

    //继承自view，只测量自己；如果是viewGroup则测量子view和自己
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure.....");
    }

    //负责布局，就是把view 放在哪里
    //onLayout 后可以调用getWidth,getHeight获取宽高,与之前的getMeasuredXXX不同,他们可能不相等
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout....");
        mWidth = getWidth();
        mHeight = getHeight();
        //设置圆心
        core.set(mWidth / 2, mHeight / 2);
        //设置小圆的半径
        miniCircleRadius = mWidth / 16;
        resetValue();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: .......");
        for(int i = 1; i <= 10; i++){
            mPaint.setColor(getResources().getColor(R.color.purple_500));
            mPaint.setAlpha((int)mAlpha/(11-i));
            Log.d(TAG, "onDraw: Alpha = "+(int)mAlpha/(11-i));
            float circleX = (float) (core.x + rotationRadius * Math.sin(i * 2 * Math.PI / 10 + deltaAngle));
            float circleY = (float) (core.y - rotationRadius * Math.cos(i * 2 * Math.PI / 10 + deltaAngle));
            canvas.drawCircle(circleX, circleY, miniCircleRadius, mPaint);
        }
    }

/*
    public interface AnimationEndListener {
        void animationEnd();
    }

    public void setAnimationEndListener(AnimationEndListener animationEndListener){
        mAnimationEndListener = animationEndListener;
    }

    public void setAnimationEnd(){
        if (mAnimationEndListener != null) {
            mAnimationEndListener.animationEnd();
        }
    }*/


}
