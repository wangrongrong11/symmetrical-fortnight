package com.example.loginapplication.login.presenter;

import android.content.Intent;

import com.example.base.BasePresenter;
import com.example.loginapplication.MainPageActivity;
import com.example.loginapplication.login.activity.IntroductoryActivity;
import com.example.loginapplication.login.activity.LoginActivity;
import com.example.loginapplication.login.adapter.IntroductoryPageAdapter;
import com.example.loginapplication.login.bean.IntroductoryPageBean;
import com.example.loginapplication.login.contract.IntroductoryContract;
import com.example.loginapplication.login.model.IntroductoryModel;

import java.util.ArrayList;
import java.util.List;

public class IntroductoryPresenter extends BasePresenter<IntroductoryModel, IntroductoryActivity, IntroductoryContract.Presenter> {

    private List<IntroductoryPageBean> mBeans = new ArrayList<>();

    private IntroductoryPageAdapter mAdapter;


    public void init(){
        mAdapter = new IntroductoryPageAdapter(getView(), mBeans);
        getView().getContract().setAdapter(mAdapter);
        mAdapter.setOnClickNextListener(new IntroductoryPageAdapter.OnClickNextListener() {
            @Override
            public void onClickNext() {
                getView().startActivity(new Intent(getView(), LoginActivity.class));
                getView().finish();
            }
        });
        m.getContract().execGetIntroductoryPage();
    }

    @Override
    public IntroductoryModel getModel() {
        return new IntroductoryModel(this);
    }

    @Override
    public IntroductoryContract.Presenter getContract() {
        return new IntroductoryContract.Presenter() {
            @Override
            public void responseGetList(List<IntroductoryPageBean> list) {
                mBeans.clear();
                mBeans.addAll(list);
                mAdapter.notifyDataSetChanged();
            }
        };
    }
}
