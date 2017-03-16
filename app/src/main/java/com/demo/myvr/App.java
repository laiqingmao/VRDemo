package com.demo.myvr;

import android.app.Application;
import android.content.Context;

public class App extends Application {

	public static Context sContext;
	@Override
	public void onCreate() {
		super.onCreate();
		//全局初始化
		sContext = this;
	}
}
