package com.ma.ouyuu.base;

import com.ma.ouyuu.util.Constant;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class BaseFragmentActivity extends FragmentActivity {
	public Context context;
	public BaseFragmentActivity activity;

	public Constant constant;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

		activity = this;
		context = getApplicationContext();
		constant = (Constant) context;
	}
}
