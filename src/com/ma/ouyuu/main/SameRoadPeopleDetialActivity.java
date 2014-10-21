package com.ma.ouyuu.main;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.ouyuu.R;
import com.ma.ouyuu.base.BaseActivity;

public class SameRoadPeopleDetialActivity extends BaseActivity {
	private ImageView head_img;
	private TextView name, sex, age, qq, weibo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detial_people_info_layout);
		// 获得用户ID
		// 查询用户详细信息

		initView();
		setData();
	}

	private void initView() {
		head_img = (ImageView) findViewById(R.id.detial_people_info_head_img_img);
		name = (TextView) findViewById(R.id.detial_people_info_name_tv);
		sex = (TextView) findViewById(R.id.detial_people_info_sex_tv);
		age = (TextView) findViewById(R.id.detial_people_info_age_tv);
		qq = (TextView) findViewById(R.id.detial_people_info_qq_tv);
		weibo = (TextView) findViewById(R.id.detial_people_info_weibo_tv);
	}

	private void setData() {

	}
}
