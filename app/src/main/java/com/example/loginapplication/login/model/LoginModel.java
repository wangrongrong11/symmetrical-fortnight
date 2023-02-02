package com.example.loginapplication.login.model;

import android.util.Log;
import android.widget.Toast;

import com.example.application.LocalApplication;
import com.example.base.BaseModel;
import com.example.loginapplication.login.bean.LoginResultBean;
import com.example.loginapplication.login.bean.UserInfoBean;
import com.example.loginapplication.login.contract.LoginContract;
import com.example.loginapplication.login.presenter.LoginPresenter;
import com.example.net.RequestBodyUtils;
import com.example.net.RetrofitConstants;
import com.example.net.RetrofitService;
import com.example.net.RetrofitUtils;
import com.google.gson.JsonObject;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class LoginModel extends BaseModel<LoginPresenter, LoginContract.Model> {

    private RetrofitService service = RetrofitUtils.mRetrofit.create(RetrofitService.class);

    public LoginModel(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void execLogin(String account, String password) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("username", account);
                jsonObject.addProperty("password", password);
                service.login(RequestBodyUtils.getBody(jsonObject.toString()))
                        .flatMap(new Function<LoginResultBean, ObservableSource<UserInfoBean>>() {
                            @Override
                            public ObservableSource<UserInfoBean> apply(LoginResultBean loginResultBean) throws Exception {
                                LocalApplication.putString(RetrofitConstants.CLIENT_TOKEN, loginResultBean.getToken());
                                return service.getInfo();
                            }
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<UserInfoBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(UserInfoBean userInfoBean) {
                                // Gson gson = new Gson();
                                if(userInfoBean.getCode() == 200){
                                    p.getContract().responseLogin(userInfoBean);
                                }else {
                                    Toast.makeText(p.getView(), userInfoBean.getMsg() , Toast.LENGTH_SHORT).show();
                                    LocalApplication.putString(RetrofitConstants.CLIENT_TOKEN, "");
                                }

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("wrrr", "onError: "+e.toString());
                                LocalApplication.putString(RetrofitConstants.CLIENT_TOKEN, "");

                            }

                            @Override
                            public void onComplete() {

                            }
                        });



            }
        };
    }
}
