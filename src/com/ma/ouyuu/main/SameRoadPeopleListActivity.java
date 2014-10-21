package com.ma.ouyuu.main;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.ma.ouyuu.R;
import com.ma.ouyuu.adapter.SimplePeopleAdapter;
import com.ma.ouyuu.base.BaseActivity;
import com.ma.ouyuu.entity.PathInfo;
import com.ma.ouyuu.entity.UserInfo;


/**
*
* name:OuyuU
* description:SameRoadPeopleListActivity
* Author:msm
* Date:2014-10-21 下午3:20:56
* Revise:Administrator
* ReviseTime:2014-10-21 下午3:20:56
* ReviseRemark:
* @version
*
*	查看同路人
*	路人列表
*/
public class SameRoadPeopleListActivity extends BaseActivity {
	private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.same_road_people_list);
		
		ArrayList<PathInfo> pathInfo = (ArrayList<PathInfo>) getIntent().getExtras().getSerializable("list");
		for(PathInfo path : pathInfo){
			Log.d("test", path.getStartPlace()+"----"+path.getStartTime()+"----"+path.getTravelWay());
		}
		
		initView();
		setData();
	}
	private void initView() {
		listview = (ListView) findViewById(R.id.same_road_people_list_listview);
	}
	private void setData() {
		List<UserInfo> list = new ArrayList<UserInfo>();
		//获得同路人的简略信息
		/**
		 * 头像, 姓名, 性别, ID
		 * */
		SimplePeopleAdapter adapter = new SimplePeopleAdapter(activity, list);
		listview.setAdapter(adapter);
	}
}
