package com.example.homepage.interfaces;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.homepage.bean.TabEntity;

import java.util.ArrayList;

public interface HomeContract {
    interface View{
        void setAdapter(FragmentStateAdapter adapter);

    }

    interface Model{
      void execGetHomeData();
      void execGetHomeBanner();

    }

    interface Presenter{
        void getHomeData();
        void responseGetHomeData(ArrayList<TabEntity> entities, ArrayList<Fragment> fragments);

    }
}
