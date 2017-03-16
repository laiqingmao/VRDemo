package com.demo.myvr.vrmodule.presenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.myvr.vrmodule.model.bean.VideoInfo;
import com.demo.myvr.vrmodule.model.net.RequestManager;
import com.demo.myvr.vrmodule.presenter.VRVidioPresenter;
import com.demo.myvr.vrmodule.presenter.activity.VideoDetailActivity;
import com.demo.myvr.vrmodule.view.VRVideoViewDelegate;
import com.demo.myvr.vrmodule.view.VRVideoViewDelegateIml;

public class VrVideoFragment extends Fragment implements VRVidioPresenter {

	private VRVideoViewDelegate mViewDelegate;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mViewDelegate = new VRVideoViewDelegateIml();
		mViewDelegate.bind(getActivity(), this);
		return mViewDelegate.getRootView();
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		RequestManager.getInstance().getVRVideoData(
				(data) -> mViewDelegate.setData(data)
		);
	}

	@Override
	public void onItemClick(View view) {
		Intent intent=new Intent(getContext(),VideoDetailActivity.class);

		VideoInfo item = (VideoInfo) view.getTag();
		intent.putExtra("title",item.title);
		intent.putExtra("img",item.img);
		intent.putExtra("text",item.text);
		intent.putExtra("play",item.play);
		startActivity(intent);
	}
}
