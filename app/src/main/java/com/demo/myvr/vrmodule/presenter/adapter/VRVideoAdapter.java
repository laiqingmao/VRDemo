package com.demo.myvr.vrmodule.presenter.adapter;

import android.view.ViewGroup;

import com.demo.myvr.common.base.presenter.BaseRecycleViewListAdapter;
import com.demo.myvr.vrmodule.model.bean.VideoInfo;
import com.demo.myvr.vrmodule.view.ItemVRVideo;

/**
 *
 * Created by laiqi on 2017/3/14.
 */

public class VRVideoAdapter extends BaseRecycleViewListAdapter<ItemVRVideo, VideoInfo> {
	@Override
	protected ItemVRVideo getItemView(ViewGroup parent, int viewType) {
		return new ItemVRVideo(parent.getContext());
	}
}
