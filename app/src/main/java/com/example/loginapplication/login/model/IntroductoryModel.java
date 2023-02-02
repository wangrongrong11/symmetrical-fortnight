package com.example.loginapplication.login.model;

import androidx.annotation.NonNull;

import com.example.base.BaseModel;
import com.example.loginapplication.R;
import com.example.loginapplication.login.bean.IntroductoryPageBean;
import com.example.loginapplication.login.contract.IntroductoryContract;
import com.example.loginapplication.login.presenter.IntroductoryPresenter;

import java.util.ArrayList;
import java.util.List;

public class IntroductoryModel extends BaseModel<IntroductoryPresenter, IntroductoryContract.Model> {
    public IntroductoryModel(IntroductoryPresenter introductoryPresenter) {
        super(introductoryPresenter);
    }

    @Override
    public IntroductoryContract.Model getContract() {
        return new IntroductoryContract.Model() {
            @Override
            public void execGetIntroductoryPage() {
                List<IntroductoryPageBean> beans = new ArrayList<>();
                Integer[] resIds = new Integer[]{R.mipmap.nvhai, R.mipmap.xiaoxin, R.mipmap.xiaoxiong};
                for (int i = 0; i < resIds.length; i++){
                    IntroductoryPageBean bean = new IntroductoryPageBean();
                    bean.setResId(resIds[i]);
                    beans.add(bean);
                }
                p.getContract().responseGetList(beans);
            }
        };

    }
}
