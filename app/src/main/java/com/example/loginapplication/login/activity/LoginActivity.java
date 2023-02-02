package com.example.loginapplication.login.activity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Utils.StringUtils;
import com.example.Utils.Utils;
import com.example.application.LocalApplication;
import com.example.loginapplication.R;
import com.example.base.BaseView;
import com.example.loginapplication.login.contract.LoginContract;
import com.example.loginapplication.login.presenter.LoginPresenter;

public class LoginActivity extends BaseView<LoginPresenter, LoginContract.View>{

    EditText etLoginId;
    EditText etLoginPassword;
    Button btLoginButton;
    ImageView imageView;
    CheckBox rememberPassword;
    TextView textView;
    FrameLayout flTabBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        initView();
        presenter.init();
        LocalApplication.putBoolean("is_new_install", false);
    }


    public void initView() {
        Utils.setStatusBarColor(this);
        flTabBar = findViewById(R.id.layout_topbar);
        Utils.setTabPaddingTop(this,flTabBar);
        etLoginId = findViewById(R.id.et_login_id);
        etLoginPassword = findViewById(R.id.et_login_password);
        btLoginButton = findViewById(R.id.bt_login_in_new);
        imageView = findViewById(R.id.content_hide_or_show);
        textView = findViewById(R.id.tv_topTitle);
        rememberPassword = findViewById(R.id.cb_checkbox);
        textView.setText("登录");
        etLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        btLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getContract().login();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getContract().showOrHidePassword(etLoginPassword);
            }
        });
    }



    @Override
    public LoginContract.View getContract() {
        return new LoginContract.View() {
            @Override
            public String getAccount() {
                return etLoginId.getText().toString().trim();
            }

            @Override
            public String getPassword() {
                return etLoginPassword.getText().toString().trim();
            }

            @Override
            public void showPassword(String mPassword) {
                etLoginId.setText(mPassword);
                rememberPassword.setChecked(StringUtils.isEmptyString(mPassword));
            }

            @Override
            public void showAccount(String account) {
                etLoginId.setText(account);
            }

            @Override
            public boolean isSavaPassword() {
                return rememberPassword.isChecked();
            }
        };
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }
}