package com.ma.ouyuu.adapter;

import java.util.List;
import java.util.Map;

import com.ma.ouyuu.R;
import com.ma.ouyuu.base.BaseActivity;
import com.ma.ouyuu.main.PathDetialActivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
*
* name:OuyuU
* description:MyPathAdapter
* Author:msm
* Date:2014-10-21 下午2:04:35
* Revise:Administrator
* ReviseTime:2014-10-21 下午2:04:35
* ReviseRemark:
* @version
*
*	我的路线适配器
*	用于在服务器查询出我的路线后在首页显示我设置过的路线
*	只显示了省略的信息，第几条路线和路线的部分内容
*	有按钮点击会查看详细路线信息
*/
public class MyPathAdapter extends BaseAdapter {

	private BaseActivity activity;
	private List<Map<String, String>> list;

	public MyPathAdapter(BaseActivity mactivity, List<Map<String, String>> mlist) {
		// TODO Auto-generated constructor stub
		this.activity = mactivity;
		this.list = mlist;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list == null ? 0 : list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list == null ? null : list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return list == null ? 0 : list.hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = View.inflate(activity, R.layout.item_my_path, null);
			viewHolder.name = (TextView) convertView.findViewById(R.id.item_my_path_name_txt);
			viewHolder.content = (TextView) convertView.findViewById(R.id.item_my_path_content_txt);
			viewHolder.relativeLayout = (RelativeLayout) convertView.findViewById(R.id.item_my_path_main_layout);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.name.setText("name");
		viewHolder.content.setText("content");
		viewHolder.relativeLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("pathId", "");
				intent.setClass(activity, PathDetialActivity.class);
				activity.startActivity(intent);
			}
		});

		return convertView;
	}

	static class ViewHolder {
		TextView name;
		TextView content;
		RelativeLayout relativeLayout;
	}
}
