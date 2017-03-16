package com.demo.myvr.common.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 *
 * Created by laiqi on 2017/3/14.
 */

public class ImageLoader {

	private ImageLoader() {}

	public static void load(Activity activity, String url, ImageView imageView) {
		Glide.with(activity).load(url).into(imageView);
	}
	public static void loadBitmap(Activity activity, String url, CallBack callBack) {
		Glide.with(activity).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
			@Override
			public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
				callBack.onSuccess(resource);
			}
		});
	}

	public interface CallBack {
		void onSuccess(Bitmap resource);
	}
}
