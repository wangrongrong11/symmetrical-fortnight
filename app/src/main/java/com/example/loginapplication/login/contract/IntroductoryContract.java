package com.example.loginapplication.login.contract;

import com.example.loginapplication.login.adapter.IntroductoryPageAdapter;
import com.example.loginapplication.login.bean.IntroductoryPageBean;

import java.util.List;

public interface IntroductoryContract {



    interface Model{
        //获取引导页面图片资源
       void execGetIntroductoryPage();
    }

    interface Presenter{
        void responseGetList(List<IntroductoryPageBean> list);
    }

    interface View{
        void setAdapter(IntroductoryPageAdapter adapter);

    }


}
