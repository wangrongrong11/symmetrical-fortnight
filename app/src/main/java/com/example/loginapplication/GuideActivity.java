package com.example.loginapplication;

import androidx.core.splashscreen.SplashScreen;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.View.LoadingView;
import com.example.base.BaseView;
import com.example.loginapplication.login.activity.LoginActivity;
import com.example.loginapplication.login.contract.GuideContract;
import com.example.loginapplication.login.presenter.GuidePresenter;

public class GuideActivity extends BaseView<GuidePresenter, GuideContract.View> {

    Button stopAnimator;
    ImageView imageView;
    LoadingView mLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashScreen.installSplashScreen(this);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        presenter.init();

    }

    @Override
    public GuideContract.View getContract() {
        return null;
    }

    @Override
    public GuidePresenter getPresenter() {
        return new GuidePresenter();
    }

    private void initView() {
        imageView = findViewById(R.id.iv_logo);
        mLoadingView =findViewById(R.id.rotation_view);
        stopAnimator = findViewById(R.id.bt_stop_animator);
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationY", 300f, 0f);
        animator.setDuration(3000);
        animator.start();
    }

    private void initEvent() {
/*        btLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // 动画练习  mLoadingView.startAnimator();




            }
        });*/

        stopAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, LoginActivity.class);
                startActivity(intent);
                //mLoadingView.stopAnimator();
            }
        });



    }
}