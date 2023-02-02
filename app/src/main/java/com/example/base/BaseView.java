package com.example.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public abstract class BaseView<P extends BasePresenter, CONTRACT> extends Activity {
    public P presenter;

    public BaseView(P p){
        this.presenter = p;
    }

    public BaseView(){}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
        presenter.bindView(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbindView();
    }



    public abstract CONTRACT getContract();

    public abstract P getPresenter();
}
