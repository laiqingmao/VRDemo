package com.demo.myvr.common.base.view;

import android.content.Context;
import android.view.View;

import com.demo.myvr.common.base.presenter.Presenter;

/**
 * View代理类接口
 * Created by laiqi on 2017/3/10.
 */

public interface ViewDelegate {
	View getRootView();

	<T extends Presenter> void bind(Context context, T presenter);
}
