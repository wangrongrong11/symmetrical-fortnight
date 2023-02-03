package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.Utils.Utils;
import com.example.application.LocalApplication;

public class MainPageActivity extends Activity {
    FrameLayout flTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //SplashScreen.installSplashScreen(this);
        setContentView(R.layout.activity_main_page);
        LocalApplication.putBoolean("is_login_in", true);
        initView();
    }

    private void initView() {
        Utils.setStatusBarColor(this);
        flTabBar = findViewById(R.id.fl_topBar);
        Utils.setTabPaddingTop(this,flTabBar);
    }
}