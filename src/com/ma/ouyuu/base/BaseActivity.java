package com.ma.ouyuu.base;

import com.ma.ouyuu.util.Constant;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

	/**
	 * @brief 上下文对象
	 * */
	public Context context;
	/**
	 * @brief 当前类对象
	 * */
	public BaseActivity activity;

	public Constant constant;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		activity = this;
		context = getApplicationContext();
		constant = (Constant) context;

	}

}
