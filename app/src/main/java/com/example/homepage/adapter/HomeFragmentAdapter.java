package com.example.homepage.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class HomeFragmentAdapter extends FragmentStateAdapter{
    private List<Fragment> mFragmentList;

    public HomeFragmentAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragmentList) {
        super(fragmentActivity);
        mFragmentList = fragmentList;

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(mFragmentList.size() != 0){
            return mFragmentList.get(position);
        }else{
            return new Fragment();
        }

    }

    @Override
    public int getItemCount() {
        return mFragmentList.size();
    }
}
