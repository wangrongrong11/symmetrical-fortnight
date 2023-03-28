package com.example.homepage.model;

import androidx.fragment.app.Fragment;

import com.example.base.BaseModel;
import com.example.homepage.bean.TabEntity;
import com.example.homepage.view.fragment.DataAnalysisFragment;
import com.example.homepage.view.fragment.HomeFragment;
import com.example.homepage.view.fragment.MainFragment;
import com.example.homepage.view.fragment.ServiceFragment;
import com.example.loginapplication.R;
import com.example.homepage.interfaces.HomeContract;
import com.example.homepage.presenter.HomePresenter;
import com.example.net.RetrofitService;
import com.example.net.RetrofitUtils;

import java.util.ArrayList;

public class HomeModel extends BaseModel<HomePresenter, HomeContract.Model> {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<TabEntity> tabEntities = new ArrayList<>();
    private String[] titles = {"首页","数据分析","服务","个人中心"};
    private int[] mIconUnSelectIds = {R.mipmap.bar_homepage_grey, R.mipmap.bar_data_grey , R.mipmap.bar_service_grey,R.mipmap.bar_my_grey};
    private int[] mIconSelectIds = {R.mipmap.bar_homepage_blue, R.mipmap.bar_data_blue , R.mipmap.bar_service_blue,R.mipmap.bar_my_blue};


    private RetrofitService service = RetrofitUtils.mRetrofit.create(RetrofitService.class);

    public HomeModel(HomePresenter homePresenter) {
        super(homePresenter);
    }

    @Override
    public HomeContract.Model getContract() {
        return new HomeContract.Model() {
            @Override
            public void execGetHomeData() {
                for (int i = 0; i < mFragments.size(); i++) {
                    p.getView().getSupportFragmentManager().beginTransaction().remove(mFragments.get(i)).commit();
                }
                mFragments.clear();
                tabEntities.clear();
                for (int i= 0; i < titles.length;i++) {
                    tabEntities.add(new TabEntity(titles[i], mIconSelectIds[i], mIconUnSelectIds[i]));
                    mFragments.add(new HomeFragment());
                    mFragments.add(new DataAnalysisFragment());
                    mFragments.add(new ServiceFragment());
                    mFragments.add(new MainFragment());
                }
                p.getContract().responseGetHomeData(tabEntities, mFragments);
            }

            @Override
            public void execGetHomeBanner() {

            }
        };
    }
}
