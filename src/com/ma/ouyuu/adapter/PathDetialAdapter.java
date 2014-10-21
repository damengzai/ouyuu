package com.ma.ouyuu.adapter;

import java.util.ArrayList;
import java.util.List;

import com.ma.ouyuu.R;
import com.ma.ouyuu.base.BaseActivity;
import com.ma.ouyuu.entity.PathInfo;
import com.ma.ouyuu.main.SameRoadPeopleListActivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * 
 * name:OuyuU description:PathDetialAdapter Author:msm Date:2014-10-21 下午2:13:40
 * Revise:Administrator ReviseTime:2014-10-21 下午2:13:40 ReviseRemark:
 * 
 * @version 路线的详细信息 可以查看每一段路线的同路人
 */
public class PathDetialAdapter extends BaseAdapter {
	private BaseActivity activity;
	private List<PathInfo> list;

	public PathDetialAdapter(BaseActivity mActivity, List<PathInfo> mList) {
		// TODO Auto-generated constructor stub
		this.activity = mActivity;
		this.list = mList;
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
		return list == null ? null : list.hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(activity, R.layout.item_path_detial, null);
			holder.start_place = (TextView) convertView.findViewById(R.id.item_path_detial_start_place_tv);
			holder.start_time = (TextView) convertView.findViewById(R.id.item_path_detial_start_time_tv);
			holder.end_place = (TextView) convertView.findViewById(R.id.item_path_detial_end_place_tv);
			holder.travel_way = (TextView) convertView.findViewById(R.id.item_path_detial_travel_way_tv);
			holder.same_path = (Button) convertView.findViewById(R.id.item_path_detial_same_path_btn);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.start_place.setText("");
		holder.start_time.setText("");
		holder.end_place.setText("");
		holder.travel_way.setText("");
		holder.same_path.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ArrayList<PathInfo> path = new ArrayList<PathInfo>();
				Intent intent = new Intent();
				intent.putParcelableArrayListExtra("list", path);
				intent.setClass(activity, SameRoadPeopleListActivity.class);
				activity.startActivity(intent);
			}
		});
		return convertView;
	}

	static class ViewHolder {
		TextView start_place, start_time,end_place, travel_way;
		Button same_path;
	}

}
