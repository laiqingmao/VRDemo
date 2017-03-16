package com.demo.myvr.vrmodule.model.net;

import android.widget.Toast;

import com.demo.myvr.App;
import com.demo.myvr.common.base.model.NetworkManager;
import com.demo.myvr.common.base.model.NetworkResposeListener;
import com.demo.myvr.vrmodule.model.bean.ImageInfo;
import com.demo.myvr.vrmodule.model.bean.VideoBean;
import com.demo.myvr.vrmodule.model.bean.VideoInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RequestManager {

	private final Api mApi;
	private static RequestManager sInstance = new RequestManager();

	private RequestManager() {
		mApi = NetworkManager.getInstance().create(Api.class);
	}

	public static RequestManager getInstance() {
		return sInstance;
	}

	public void getVRPanoData(final NetworkResposeListener<List<ImageInfo>> listener) {
		List<ImageInfo> items = new ArrayList<>();
		items.add(new ImageInfo("滕王阁", "http://media.qicdn.detu.com/pano177051472357986990056825/thumb/500_500/panofile.jpg", "http://media.qicdn.detu.com/@/13363707-8857-C248-3CE1-64F2F24291636/source/145049/o_1arbdk2apj37df16up16um196j7.mp3"));
		items.add(new ImageInfo("巴山大峡谷-云海日出", "http://media.qicdn.detu.com/@/17596710-5661-0192-EDC8-81F89376806/source/142048/o_1aqd3brm71svb11gqh5la5bjj17.jpg", "http://media.qicdn.detu.com/@/17596710-5661-0192-EDC8-81F89376806/source/128321/o_1amb55jqq13ma8po16aogvdrjkc.mp3"));
		items.add(new ImageInfo("厦大", "http://media.qicdn.detu.com/pano781791479224712452691293/thumb/500_500/panofile.jpg", null));
		items.add(new ImageInfo("西南大学经济管理学院", "http://media.qicdn.detu.com/pano573341478189386216286405/thumb/500_500/panofile.jpg", null));
		items.add(new ImageInfo("辽宁工业大学", "http://media.qicdn.detu.com/pano476831467201488386232805/thumb/500_500/panofile.jpg", null));
		items.add(new ImageInfo("西安海棠职业学院", "http://media.qicdn.detu.com/pano532201469338026348840893/thumb/500_500/panofile.jpg", "http://media.qicdn.detu.com/@/18192570-5756-0D36-9533-2416F77090543/source/135547/o_1aodn4afsqclli11jm5tr22kg7.mp3"));
		listener.onSuccess(items);
	}

	public void getVRVideoData(final NetworkResposeListener<List<VideoInfo>> listener) {
		mApi.getVRVideoData().enqueue(new Callback<VideoBean>() {
			@Override
			public void onResponse(Call<VideoBean> call, Response<VideoBean> response) {
				listener.onSuccess(response.body().content);
			}

			@Override
			public void onFailure(Call<VideoBean> call, Throwable t) {
				Toast.makeText(App.sContext, "网络连接失败", Toast.LENGTH_SHORT).show();
				t.printStackTrace();
			}
		});
	}
}