package com.example.net;

import com.example.loginapplication.login.bean.LoginResultBean;
import com.example.loginapplication.login.bean.UserInfoBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitService {

    //===================登录====================//
    @POST("userAdmin/login")
    Observable<LoginResultBean> login(@Body RequestBody body);

    //获取用户信息
    @GET("userAdmin/getInfo")
    Observable<UserInfoBean> getInfo();


}
