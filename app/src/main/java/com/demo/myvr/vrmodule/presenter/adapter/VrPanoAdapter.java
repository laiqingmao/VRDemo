package com.demo.myvr.vrmodule.presenter.adapter;

import android.view.ViewGroup;

import com.demo.myvr.common.base.presenter.BaseRecycleViewListAdapter;
import com.demo.myvr.vrmodule.model.bean.ImageInfo;
import com.demo.myvr.vrmodule.view.ItemVRPano;


public class VrPanoAdapter extends BaseRecycleViewListAdapter<ItemVRPano, ImageInfo> {
	@Override
	protected ItemVRPano getItemView(ViewGroup parent, int viewType) {
		return new ItemVRPano(parent.getContext());
	}

}
