package com.demo.myvr.vrmodule.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.demo.myvr.common.base.presenter.BaseRecycleViewListAdapter;
import com.demo.myvr.common.base.presenter.Presenter;
import com.demo.myvr.vrmodule.model.bean.ImageInfo;
import com.demo.myvr.vrmodule.presenter.VRPanoPresenter;
import com.demo.myvr.vrmodule.presenter.adapter.VrPanoAdapter;

import java.util.List;

/**
 * 全景图fragment视图代理类
 * Created by laiqi on 2017/3/14.
 */

public class VRPanoViewDelegateIml implements VRPanoViewDelegate, BaseRecycleViewListAdapter.OnItemClickListener {
	private Context mContext;
	private VRPanoPresenter mPresenter;
	private RecyclerView mView;
	private VrPanoAdapter mAdapter;

	@Override
	public View getRootView() {
		mView = new RecyclerView(mContext);
		init();
		return mView;
	}

	@Override
	public void bind(Context context, Presenter presenter) {
		mContext = context;
		mPresenter = (VRPanoPresenter) presenter;
	}

	private void init() {
		mAdapter = new VrPanoAdapter();
		mView.setAdapter(mAdapter);
		mView.setLayoutManager(new LinearLayoutManager(mContext));
		mAdapter.setOnItemClickListener(this);
	}

	@Override
	public void setData(List<ImageInfo> list) {
		mAdapter.setData(list);
	}

	@Override
	public void addData(List<ImageInfo> list) {
		mAdapter.addData(list);
	}

	@Override
	public void onItemClick(View view, int position) {
		mPresenter.onItemClick(view);
	}
}
