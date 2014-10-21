package com.ma.ouyuu.adapter;

import java.util.ArrayList;
import java.util.List;

import com.ma.ouyuu.R;
import com.ma.ouyuu.entity.PathInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


/**
*
* name:OuyuU
* description:PathInfoAdapter
* Author:msm
* Date:2014-10-21 下午2:11:29
* Revise:Administrator
* ReviseTime:2014-10-21 下午2:11:29
* ReviseRemark:
* @version
*
*	
*/
public class PathInfoAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<PathInfo> mList = new ArrayList<PathInfo>();

	public PathInfoAdapter(Context mContext, List<PathInfo> list) {
		super();
		if (list != null) {
			this.mList = list;
		}
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return mList != null ? mList.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		return mList != null ? mList.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return mList != null ? mList.hashCode() : 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();

			convertView = mInflater.inflate(R.layout.item_one_path, null);

			holder.start_place = (TextView) convertView.findViewById(R.id.item_one_path_start_place_text);
			holder.start_time = (TextView) convertView.findViewById(R.id.item_one_path_start_time_text);
			holder.end_place = (TextView) convertView.findViewById(R.id.item_one_path_end_place_text);
			holder.travel_way = (TextView) convertView.findViewById(R.id.item_one_path_travel_way_text);
			

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.start_place.setText(mList.get(position).getStartPlace());
		holder.start_time.setText(mList.get(position).getStartTime());
		holder.end_place.setText(mList.get(position).getEndPlace());
		holder.travel_way.setText(mList.get(position).getTravelWay());
		return convertView;
	}

	static class ViewHolder {
		TextView start_place, start_time,end_place, travel_way;
	}
}
