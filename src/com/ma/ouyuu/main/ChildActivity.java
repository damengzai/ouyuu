package com.ma.ouyuu.main;

import android.os.Bundle;

import com.ma.ouyuu.base.BaseActivity;

public class ChildActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

}
