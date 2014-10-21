package com.ma.ouyuu.main;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.ma.ouyuu.R;
import com.ma.ouyuu.adapter.PathDetialAdapter;
import com.ma.ouyuu.base.BaseActivity;
import com.ma.ouyuu.entity.PathInfo;


/**
*
* name:OuyuU
* description:PathDetialActivity
* Author:msm
* Date:2014-10-21 下午2:55:19
* Revise:Administrator
* ReviseTime:2014-10-21 下午2:55:19
* ReviseRemark:
* @version
*
*	查看自己的某一段路线的详细信息
*/
public class PathDetialActivity extends BaseActivity {
	private ListView path_detial_listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.path_detial_layout);
		
		initView();
		setData();
	}

	

	private void initView() {
		path_detial_listview = (ListView) findViewById(R.id.path_detial_listview);
	}
	
	private void setData() {
		if(getIntent().getExtras() != null){
			String pathId = getIntent().getExtras().getString("pathId");
			//根据id查询详细信息
			List<PathInfo> list = new ArrayList<PathInfo>();
			PathDetialAdapter pathDetialAdapter = new PathDetialAdapter(activity,list);
			path_detial_listview.setAdapter(pathDetialAdapter);
		}
	}
}
