package com.example.loginapplication.login.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Utils.Utils;
import com.example.View.IndicatorView;

import com.example.base.BaseView;
import com.example.loginapplication.R;
import com.example.loginapplication.login.adapter.IntroductoryPageAdapter;
import com.example.loginapplication.login.contract.IntroductoryContract;
import com.example.loginapplication.login.presenter.IntroductoryPresenter;

public class IntroductoryActivity extends BaseView<IntroductoryPresenter, IntroductoryContract.View> {
    private ViewPager mViewPage;
    private IndicatorView indicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);
        initView();
        presenter.init();
        indicatorView.setUpWithViewPager(mViewPage);
        indicatorView.setRadius(10);
        indicatorView.setSpace(10);
    }

    private void initView() {
        Utils.setStatusBarColor(this);
        mViewPage = findViewById(R.id.vp_introductory);
        indicatorView =(IndicatorView) findViewById(R.id.iv_indicator);
    }

    @Override
    public IntroductoryContract.View getContract() {
        return new IntroductoryContract.View() {
            @Override
            public void setAdapter(IntroductoryPageAdapter adapter) {
                mViewPage.setAdapter(adapter);
            }
        };
    }

    @Override
    public IntroductoryPresenter getPresenter() {
        return new IntroductoryPresenter();
    }
}