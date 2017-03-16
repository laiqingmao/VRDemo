package com.demo.myvr.vrmodule.view;

import com.demo.myvr.common.base.view.ViewDelegate;
import com.demo.myvr.vrmodule.model.bean.VideoInfo;

import java.util.List;

/**
 *
 * Created by laiqi on 2017/3/14.
 */

public interface VRVideoViewDelegate extends ViewDelegate {


	void setData(List<VideoInfo> list);

	void addData(List<VideoInfo> list);
}
