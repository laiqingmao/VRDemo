package com.demo.myvr.vrmodule.model.net;

import com.demo.myvr.vrmodule.model.bean.VideoBean;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

	@GET("api/video/query")
	Call<VideoBean> getVRVideoData();
}