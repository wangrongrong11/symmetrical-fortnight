package com.example.loginapplication.login.model;

import com.example.base.BaseModel;
import com.example.loginapplication.login.contract.GuideContract;
import com.example.loginapplication.login.presenter.GuidePresenter;

public class GuideModel extends BaseModel<GuidePresenter, GuideContract.Model> {

    public GuideModel(GuidePresenter guidePresenter) {
        super(guidePresenter);
    }

    @Override
    public GuideContract.Model getContract() {
        return null;
    }
}
