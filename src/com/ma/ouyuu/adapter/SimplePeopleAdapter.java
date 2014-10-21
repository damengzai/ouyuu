package com.ma.ouyuu.adapter;

import java.util.List;

import com.ma.ouyuu.R;
import com.ma.ouyuu.base.BaseActivity;
import com.ma.ouyuu.entity.UserInfo;
import com.ma.ouyuu.main.SameRoadPeopleDetialActivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * name:OuyuU description:PeopleAdapter Author:msm Date:2014-10-21 下午3:33:13
 * Revise:Administrator ReviseTime:2014-10-21 下午3:33:13 ReviseRemark:
 * 
 * @version
 * 
 *          显示用户的缩略信息列表
 */
public class SimplePeopleAdapter extends BaseAdapter {

	private BaseActivity mActivity;
	private List<UserInfo> mList;

	public SimplePeopleAdapter(BaseActivity activity, List<UserInfo> list) {
		this.mActivity = activity;
		this.mList = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList == null ? 0 : mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList == null ? null : mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return mList == null ? null : mList.hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(mActivity, R.layout.item_simple_people_info, null);
			holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.item_simple_people_info_linearlayout);
			holder.head_img = (ImageView) convertView.findViewById(R.id.item_simple_people_info_head_img_img);
			holder.name = (TextView) convertView.findViewById(R.id.item_simple_people_info_name_tv);
			holder.sex = (TextView) convertView.findViewById(R.id.item_simple_people_info_sex_tv);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.linearLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//跳转到路人详细信息
				//传递用户的ID
				Intent intent = new Intent();
				intent.setClass(mActivity, SameRoadPeopleDetialActivity.class);
			}
		});
		return convertView;
	}

	static class ViewHolder {
		LinearLayout linearLayout;
		ImageView head_img;
		TextView name, sex;
	}

}
