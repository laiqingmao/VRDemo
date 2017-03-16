package com.demo.myvr.vrmodule.view;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.myvr.R;
import com.demo.myvr.common.base.view.ListItemView;
import com.demo.myvr.common.util.ImageLoader;
import com.demo.myvr.vrmodule.model.bean.VideoInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import butterknife.BindView;

/**
 *
 * Created by laiqi on 2017/3/14.
 */

public class ItemVRVideo extends ListItemView<VideoInfo> {

	@BindView(R.id.topic_init_img)
	ImageView mTopicInitImg;
	@BindView(R.id.topic_init_title)
	TextView mTopicInitTitle;
	@BindView(R.id.tag0)
	TextView mTag0;
	@BindView(R.id.tag1)
	TextView mTag1;
	@BindView(R.id.tag2)
	TextView mTag2;
	@BindView(R.id.date_text)
	TextView mDateText;
	private DateFormat mDateFormat = SimpleDateFormat.getDateInstance();
	private TextView[] mTags = {mTag0, mTag1, mTag2};


	public ItemVRVideo(Context context) {
		super(context);
	}

	@Override
	public int getLayoutId() {
		return R.layout.item_vr_video;
	}

	@Override
	public void bind(VideoInfo videoInfo, int position) {
		mTopicInitTitle.setText(videoInfo.title);
		mDateText.setText(mDateFormat.format(videoInfo.date));
		ImageLoader.load((Activity) getContext(), videoInfo.img, mTopicInitImg);
		String[] tags = videoInfo.tags;
		for (int i = 0; i < tags.length; i++) {
			mTags[i].setText(tags[i]);
		}
		setTag(videoInfo);
	}
}
