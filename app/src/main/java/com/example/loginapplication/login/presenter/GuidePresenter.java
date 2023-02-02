package com.example.loginapplication.login.presenter;

import android.content.Intent;

import com.example.application.LocalApplication;
import com.example.base.BasePresenter;
import com.example.loginapplication.GuideActivity;
import com.example.loginapplication.MainPageActivity;
import com.example.loginapplication.login.activity.IntroductoryActivity;
import com.example.loginapplication.login.activity.LoginActivity;
import com.example.loginapplication.login.contract.GuideContract;
import com.example.loginapplication.login.model.GuideModel;

public class GuidePresenter extends BasePresenter<GuideModel, GuideActivity, GuideContract.Presenter> {

    public void init(){
        startAnimationDown();
    }

    private void startAnimationDown() {
        boolean isNewInstall = LocalApplication.getBoolean("is_new_install", true);
        if(isNewInstall){
            getView().startActivity(new Intent(getView(), IntroductoryActivity.class));
        }else{
            boolean isLoginIn = LocalApplication.getBoolean("is_login_in", false);
            if(!isLoginIn){
                getView().startActivity(new Intent(getView(), LoginActivity.class));
            }else{
                getView().startActivity(new Intent(getView(), MainPageActivity.class));
            }
        }
        getView().finish();
    }

    @Override
    public GuideModel getModel() {
        return new GuideModel(this);
    }

    @Override
    public GuideContract.Presenter getContract() {
        return null;
    }
}
