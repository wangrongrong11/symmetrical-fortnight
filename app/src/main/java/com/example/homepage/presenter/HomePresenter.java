package com.example.homepage.presenter;

import androidx.fragment.app.Fragment;

import com.example.base.BasePresenter;
import com.example.homepage.adapter.HomeFragmentAdapter;
import com.example.homepage.bean.TabEntity;
import com.example.homepage.model.HomeModel;
import com.example.homepage.view.activity.HomeActivity;
import com.example.homepage.interfaces.HomeContract;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter extends BasePresenter<HomeModel, HomeActivity, HomeContract.Presenter> {
    private List<Fragment> fragmentList = new ArrayList<>();
    private HomeFragmentAdapter homeFragmentAdapter;

    @Override
    public HomeModel getModel() {
        return new HomeModel(this);
    }

    public void init() {
        getContract().getHomeData();
    }


    @Override
    public HomeContract.Presenter getContract() {
        return new HomeContract.Presenter() {
            @Override
            public void getHomeData() {
                getModel().getContract().execGetHomeData();
            }

            @Override
            public void responseGetHomeData(ArrayList<TabEntity> entities, ArrayList<Fragment> fragments) {
                fragmentList = fragments;
                homeFragmentAdapter = new HomeFragmentAdapter(getView(), fragmentList);
                getView().getContract().setAdapter(homeFragmentAdapter);



            }
        };
    }

}
