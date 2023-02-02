package com.example.loginapplication.login.contract;

import android.widget.EditText;

import com.example.loginapplication.login.bean.UserInfoBean;

public interface LoginContract {

    interface Model{
        //网络请求
        void execLogin(String account, String password);

    }

    interface View{
        //更新控件
        //获取控件的内容
        String getAccount();
        String getPassword();
        void showPassword(String mPassword);
        void showAccount(String account);
        boolean isSavaPassword();
    }

    interface Presenter{
        //执行view的显示
        //执行网络请求
        void login();
        void responseLogin(UserInfoBean userInfoBean);
        void showOrHidePassword(EditText editText);



    }
}
