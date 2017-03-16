package com.demo.myvr.common.base.view;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;

/**
 * item基类
 * Created by Administrator on 2017/1/11.
 */

public abstract class ListItemView<DATA> extends RelativeLayout {

	public ListItemView(Context context) {
		super(context);
		View.inflate(context, getLayoutId(), this);
		ButterKnife.bind(this);
	}

	public abstract int getLayoutId();

	public abstract void bind(DATA data, int position);
}
