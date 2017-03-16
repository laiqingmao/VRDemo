package com.demo.myvr.vrmodule.presenter.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter{

	private List<Fragment> fragments;
	private String[] mTitle = {"全景图", "全景视频"};

	public MyPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public void setFragments(List<Fragment> fragments){
		this.fragments=fragments;
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
		return mTitle[position];
	}
}
