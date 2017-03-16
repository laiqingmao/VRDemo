package com.demo.myvr.common.base.model;

import com.demo.myvr.App;
import com.demo.myvr.BuildConfig;
import com.google.gson.GsonBuilder;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * Created by simon on 2017/3/11.
 * 网络封装类
 */

public class NetworkManager {

	public static final String HOST = BuildConfig.DEBUG ?
			"http://api.youkes.com:8081" : "http://api.youkes.com:8081";
	private static NetworkManager sInstance = new NetworkManager();
	private final Retrofit mRetrofit;

	private NetworkManager() {
		mRetrofit = new Retrofit.Builder()
				.baseUrl(HOST)
				.addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.client(genericClient())
				.build();
	}

	private OkHttpClient genericClient() {
		return new OkHttpClient.Builder()
				.cache(new Cache(App.sContext.getCacheDir(), 60 * 1024 * 1024))
				.addInterceptor((Interceptor.Chain chain) -> {
						Request request = chain
								.request()
								.newBuilder()
								.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
								.addHeader("Accept-Encoding", "gzip, deflate")
								.addHeader("Connection", "keep-alive")
//								.cacheControl(NetworkUtil.isAvailable(BaseApplication.sInstance) ?
//										CacheControl.FORCE_NETWORK : CacheControl.FORCE_CACHE)
								.build();
						return chain.proceed(request);
					}
				)
				.build();
	}

	public static NetworkManager getInstance() {
		return sInstance;
	}

	public <T> T create(Class<T> clazz) {
		return mRetrofit.create(clazz);
	}
}
