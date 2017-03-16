package com.demo.myvr.vrmodule.view;

import com.demo.myvr.common.base.view.ViewDelegate;
import com.demo.myvr.vrmodule.model.bean.ImageInfo;

import java.util.List;

/**
 *
 * Created by laiqi on 2017/3/14.
 */

public interface VRPanoViewDelegate extends ViewDelegate {


	void setData(List<ImageInfo> list);

	void addData(List<ImageInfo> list);
}
