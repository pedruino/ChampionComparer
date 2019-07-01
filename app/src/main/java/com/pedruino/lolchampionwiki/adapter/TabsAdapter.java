package com.pedruino.lolchampionwiki.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class TabsAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragmentsTitle = new ArrayList<>();

    public TabsAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void add(Fragment fragment, String title) {
        this.fragments.add(fragment);
        this.fragmentsTitle.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentsTitle.get(position);
    }
}