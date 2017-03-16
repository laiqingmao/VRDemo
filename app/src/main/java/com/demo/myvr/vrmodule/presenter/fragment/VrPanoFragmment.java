package com.demo.myvr.vrmodule.presenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.myvr.vrmodule.model.bean.ImageInfo;
import com.demo.myvr.vrmodule.model.net.RequestManager;
import com.demo.myvr.vrmodule.presenter.VRPanoPresenter;
import com.demo.myvr.vrmodule.presenter.activity.ImageDetailActivity;
import com.demo.myvr.vrmodule.view.VRPanoViewDelegate;
import com.demo.myvr.vrmodule.view.VRPanoViewDelegateIml;


public class VrPanoFragmment extends Fragment implements VRPanoPresenter {

	private VRPanoViewDelegate mViewDelegate;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mViewDelegate = new VRPanoViewDelegateIml();
		mViewDelegate.bind(getActivity(), this);
		return mViewDelegate.getRootView();
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		RequestManager.getInstance().getVRPanoData(
				(data) -> mViewDelegate.setData(data)
		);
	}

	public void onItemClick(View v) {
		Intent intent=new Intent(getContext(),ImageDetailActivity.class);
		ImageInfo item= (ImageInfo) v.getTag();
		intent.putExtra("url",item.url);
		intent.putExtra("mp3",item.mp3);
		startActivity(intent);
	}
}
