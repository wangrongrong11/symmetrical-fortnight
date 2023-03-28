package com.example.loginapplication.login.presenter;

import android.content.Intent;
import android.util.Log;

import com.example.application.LocalApplication;
import com.example.base.BasePresenter;
import com.example.loginapplication.GuideActivity;
import com.example.homepage.view.activity.HomeActivity;
import com.example.loginapplication.login.activity.IntroductoryActivity;
import com.example.loginapplication.login.activity.LoginActivity;
import com.example.loginapplication.login.contract.GuideContract;
import com.example.loginapplication.login.model.GuideModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GuidePresenter extends BasePresenter<GuideModel, GuideActivity, GuideContract.Presenter> {

    public void init(){
        startAnimationDown();
    }

    private void startAnimationDown() {
        boolean isNewInstall = LocalApplication.getBoolean("is_new_install", true);
        if(isNewInstall){
            getView().startActivity(new Intent(getView(), IntroductoryActivity.class));
        }else{
            delay();
        }

    }

    private void delay(){

        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("wrr",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        boolean isLoginIn = LocalApplication.getBoolean("is_login_in", false);
                        if(!isLoginIn){
                            getView().getContract().goToNextPage(LoginActivity.class);
                        }else{
                            getView().getContract().goToNextPage(HomeActivity.class);
                        }
                        getView().finish();
                    }
                });

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
