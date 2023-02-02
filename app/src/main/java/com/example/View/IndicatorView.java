package com.example.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.loginapplication.R;

import java.util.ArrayList;
import java.util.List;

public class IndicatorView extends View implements ViewPager.OnPageChangeListener{
    private Indicator indicator;
    private Paint mPaint;
    private int mWidth;
    private int mLength;
    private float mRadius;  //圆点半径
    private float mSpace;  //圆点之间的距离
    private int mCount;  // 圆点的数量
    private int selectPosition; //选中小圆点位置
    private PointF core;   //小圆点圆心的位置
    private List<Indicator> mIndicators = new ArrayList<>();
    private int mSelectColor;
    private int mNormalColor;
    private ViewPager mViewPager;

    public IndicatorView(Context context) {
        this(context, null);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttr(context, attrs);
        initRes();
    }

    private void getAttr(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IndicatorView);
        mSelectColor = typedArray.getColor(R.styleable.IndicatorView_mSelectColor, Color.WHITE);
        mNormalColor = typedArray.getColor(R.styleable.IndicatorView_mNormalColor, Color.GRAY);
        typedArray.recycle();
    }

    private void initRes() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        core = new PointF();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mWidth = (int) ((mCount - 1) * mSpace + mCount * 2 * mRadius);
        mLength = (int) (2 * mRadius + mSpace * 2);
        setMeasuredDimension(mWidth, mLength);
        measureIndicator();
    }
    /**
     * 测量每个小圆点的位置
     * */
    private void measureIndicator() {
        mIndicators.clear();
        float cx = 0;
        for(int i = 0; i < mCount; i++){
            Indicator indicator = new Indicator();
            if(i == 0){
                cx = mRadius;
            }else{
                cx += mRadius * 2 + mSpace;
            }
            indicator.cx = cx;
            indicator.cy = getMeasuredHeight()/2;
            mIndicators.add(indicator);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("IndicatorView", "onDraw......... ");
        for (int i = 0; i < mIndicators.size(); i++){
            Indicator indicator = mIndicators.get(i);
            float x = indicator.cx;
            float y = indicator.cy;
            if(selectPosition == i){
                mPaint.setColor(mSelectColor);
            }else {
                mPaint.setColor(mNormalColor);
            }
            canvas.drawCircle(x, y, mRadius, mPaint);
        }

    }

    public void setRadius(float radius) {
        Log.d("IndicatorView", "setRadius....... ");
        this.mRadius = radius;
    }

    public void setSpace(float space) {
        this.mSpace = space;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
    }

    public void setSelectColor(int selectColor) {
        this.mSelectColor = selectColor;
    }
    public void setNormalColor(int normalColor) {
        this.mNormalColor = normalColor;
    }

    /**
     *  与ViewPager 关联
     * @param viewPager
     */
    public void setUpWithViewPager(ViewPager viewPager){
        releaseViewPager();
        if(viewPager == null){
            return;
        }
        mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(this);
        int count = mViewPager.getAdapter().getCount();
        setCount(count);
    }

    /**
     * 重置ViewPager
     */
    private void releaseViewPager(){
        if(mViewPager!=null){
            mViewPager.removeOnPageChangeListener(this);
            mViewPager = null;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        selectPosition = position;
        invalidate();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * Indicator 点击回调
     */
    public interface OnIndicatorClickListener{
        public void onSelected(int position);
    }

    private static class Indicator{
        public float cx;
        public float cy;
    }
}
