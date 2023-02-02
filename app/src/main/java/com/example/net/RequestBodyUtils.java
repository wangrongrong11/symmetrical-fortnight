package com.example.net;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RequestBodyUtils {
    public static RequestBody getBody(String json){
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
    }
}
