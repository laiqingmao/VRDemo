package com.demo.myvr.vrmodule.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.demo.myvr.common.base.presenter.BaseRecycleViewListAdapter;
import com.demo.myvr.common.base.presenter.Presenter;
import com.demo.myvr.vrmodule.model.bean.VideoInfo;
import com.demo.myvr.vrmodule.presenter.VRVidioPresenter;
import com.demo.myvr.vrmodule.presenter.adapter.VRVideoAdapter;

import java.util.List;

/**
 * 全景视频fragment视图代理类
 * Created by laiqi on 2017/3/14.
 */

public class VRVideoViewDelegateIml implements VRVideoViewDelegate, BaseRecycleViewListAdapter.OnItemClickListener {
	private Context mContext;
	private VRVidioPresenter mPresenter;
	private RecyclerView mView;
	private VRVideoAdapter mAdapter;

	@Override
	public View getRootView() {
		mView = new RecyclerView(mContext);
		init();
		return mView;
	}

	@Override
	public void bind(Context context, Presenter presenter) {
		mContext = context;
		mPresenter = (VRVidioPresenter) presenter;
	}

	private void init() {
		mAdapter = new VRVideoAdapter();
		mView.setAdapter(mAdapter);
		mView.setLayoutManager(new GridLayoutManager(mContext, 2));
		mAdapter.setOnItemClickListener(this);
	}

	@Override
	public void setData(List<VideoInfo> list) {
		mAdapter.setData(list);
	}

	@Override
	public void addData(List<VideoInfo> list) {
		mAdapter.addData(list);
	}

	@Override
	public void onItemClick(View view, int position) {
		mPresenter.onItemClick(view);
	}
}
