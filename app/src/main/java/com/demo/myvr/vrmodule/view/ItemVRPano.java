package com.demo.myvr.vrmodule.view;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.myvr.R;
import com.demo.myvr.common.base.view.ListItemView;
import com.demo.myvr.common.util.ImageLoader;
import com.demo.myvr.vrmodule.model.bean.ImageInfo;

import butterknife.BindView;

/**
 *
 * Created by laiqi on 2017/3/14.
 */

public class ItemVRPano extends ListItemView<ImageInfo> {

	@BindView(R.id.iv_pano)
	ImageView mIvPano;
	@BindView(R.id.tv_title)
	TextView mTvTitle;

	public ItemVRPano(Context context) {
		super(context);
	}

	@Override
	public int getLayoutId() {
		return R.layout.item_vr_pano;
	}

	@Override
	public void bind(ImageInfo imageInfo, int position) {
		mTvTitle.setText(imageInfo.title);
		ImageLoader.load((Activity) getContext(), imageInfo.url, mIvPano);
		setTag(imageInfo);
	}
}
