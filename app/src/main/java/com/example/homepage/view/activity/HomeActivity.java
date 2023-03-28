package com.example.homepage.view.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.Utils.Utils;
import com.example.application.LocalApplication;
import com.example.base.BaseView;
import com.example.homepage.presenter.HomePresenter;
import com.example.loginapplication.R;
import com.example.homepage.interfaces.HomeContract;

public class HomeActivity extends BaseView<HomePresenter, HomeContract.View> {
    FrameLayout flTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //SplashScreen.installSplashScreen(this);
        setContentView(R.layout.activity_main_page);
        LocalApplication.putBoolean("is_login_in", true);
        initView();
        presenter.init();
    }

    @Override
    public HomePresenter getPresenter() {
        return new HomePresenter();
    }

    private void initView() {
        Utils.setStatusBarColor(this);
        flTabBar = findViewById(R.id.fl_topBar);
        Utils.setTabPaddingTop(this,flTabBar);
    }

    @Override
    public HomeContract.View getContract() {
        return new HomeContract.View() {
            @Override
            public void setAdapter(FragmentStateAdapter adapter) {

            }
        };
    }

}