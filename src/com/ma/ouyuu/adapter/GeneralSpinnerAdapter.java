package com.ma.ouyuu.adapter;

import com.ma.ouyuu.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


/**
*
* name:OuyuU
* description:GeneralSpinnerAdapter
* Author:msm
* Date:2014-10-21 下午2:01:55
* Revise:Administrator
* ReviseTime:2014-10-21 下午2:01:55
* ReviseRemark:
* @version
* 下拉框适配器
*/
public class GeneralSpinnerAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private String[] datas = new String[0];
	private boolean isRed = false;

	public GeneralSpinnerAdapter(Context mContext, String[] datas) {
		super();
		if (datas != null) {
			this.datas = datas;
		}
		mInflater = LayoutInflater.from(mContext);
	}

	public GeneralSpinnerAdapter(Context mContext, String[] datas, boolean isRed) {
		this(mContext, datas);
		this.isRed = isRed;
	}

	@Override
	public int getCount() {
		return datas != null ? datas.length : 0;
	}

	@Override
	public Object getItem(int position) {
		return datas != null ? datas[position] : null;
	}

	@Override
	public long getItemId(int position) {
		return datas != null ? datas.hashCode() : 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			if (isRed) {
				convertView = mInflater.inflate(R.layout.item_spinner_red, null);

			} else {
				convertView = mInflater.inflate(R.layout.item_spiner, null);
			}

			holder.name = (TextView) convertView.findViewById(R.id.itemName);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.name.setText(datas[position]);
		return convertView;
	}

	static class ViewHolder {
		TextView name;
	}
}
