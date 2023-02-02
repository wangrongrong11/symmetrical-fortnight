package com.example.loginapplication.login.bean;

public class LoginResultBean {


    /**
     * code : 2
     * msg : 成功
     * token  : eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6ImIyYWIwNTM3LTMxNzAtNDA3Ni1iZDhhLTk0ZjFmYjViOGJkYyJ9.jXyteMWK3uHVUpoxUNm-h4oc_IIWMCfrfYfwhrkMyMF77umroelXqN5pLo60f6b_NKF1wXjxyt7dwvtV6eDcmA
     */

    private int code;
    private String msg;
    private String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
