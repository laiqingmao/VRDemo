package com.demo.myvr.common.base.model;


/**
 *
 * Created by laiqi on 2017/3/11.
 */
@FunctionalInterface
public interface NetworkResposeListener<T> {
	 void onSuccess(T result);
}
