package com.example.net;

import com.example.application.LocalApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    private static OkHttpClient mHttpClient;

    public static Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl(RetrofitConstants.HOST_ADDRESS)
            .client(getHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static Headers addHeaders() {
        String client_token = LocalApplication.getString(RetrofitConstants.CLIENT_TOKEN, "");
        Headers.Builder builder = new Headers.Builder();
        if (client_token!=null && !"".equals(client_token)) {
            builder.add("Authorization",client_token);
        }
        return builder.build();
    }
    /**
     * Token是服务端生成的一串字符串，以作客户端进行请求的一个令牌，
     * 当第一次登录后，服务器生成一个Token便将此Token返回给客户端，
     * 以后客户端只需带上这个Token前来请求数据即可，无需再次带上用户名和密码。
     * */
    private static OkHttpClient getHttpClient() {
        HttpsVerification.SSLParams sslParams = HttpsVerification.getSslSocketFactory(LocalApplication.getInstance());

        if (mHttpClient == null) {

            OkHttpClient.Builder builder = new OkHttpClient.Builder().
                    connectTimeout(60, TimeUnit.SECONDS).
                    readTimeout(60, TimeUnit.SECONDS).
                    writeTimeout(60, TimeUnit.SECONDS).
                    addInterceptor(new Interceptor() {

                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();

                            Request request = original.newBuilder()
                                    .headers(addHeaders())
                                    .build();

                            Response response = chain.proceed(request);
                            String tokenCode = response.header("token_code");
                            if ("-1".equals(tokenCode) || "-2".equals(tokenCode)) {
                               //todo: 退出登录 logout();

                            }
                            return response;
                        }
                    });

            mHttpClient = builder.build();
        }
        return mHttpClient;
    }




}
