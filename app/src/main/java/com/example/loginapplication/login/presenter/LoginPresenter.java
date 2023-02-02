package com.example.loginapplication.login.presenter;

import android.app.Application;
import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application.LocalApplication;
import com.example.loginapplication.MainPageActivity;
import com.example.base.BasePresenter;
import com.example.loginapplication.login.bean.UserInfoBean;
import com.example.loginapplication.login.activity.LoginActivity;
import com.example.loginapplication.login.contract.LoginContract;
import com.example.loginapplication.login.model.LoginModel;

public class LoginPresenter extends BasePresenter<LoginModel, LoginActivity, LoginContract.Presenter> {
    private String mAccount;
    private String mPassword;
    private boolean showPassword = false;
    private int count = 0;

    public void init() {
        //隐藏或者显示密码
        mAccount = LocalApplication.getString("loginAccount", "");
        mPassword = LocalApplication.getString("loginPassword", "");
        getView().getContract().showAccount(mAccount);
        getView().getContract().showPassword(mPassword);

    }

    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }

    @Override
    public LoginContract.Presenter getContract() {
        return new LoginContract.Presenter() {
            @Override
            public void login() {
                mAccount = getView().getContract().getAccount();
                mPassword = getView().getContract().getPassword();
                m.getContract().execLogin(mAccount, mPassword);
            }

            @Override
            public void responseLogin(UserInfoBean userInfoBean) {
                Toast.makeText(getView(), "登录成功" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(getView(), MainPageActivity.class);
                getView().startActivity(intent);
                //此处的finish()可以避免返回的时候重新打开这个页面
                getView().finish();

            }

            @Override
            public void showOrHidePassword(EditText editText) {
                if(!showPassword){
                    editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                showPassword = !showPassword;
                count++;
                Log.d("wrrrr", "showOrHidePassword: "+count );
            }
        };
    }


}
