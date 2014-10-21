package com.ma.ouyuu.main;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.ma.ouyuu.R;
import com.ma.ouyuu.adapter.GeneralSpinnerAdapter;
import com.ma.ouyuu.adapter.PathInfoAdapter;
import com.ma.ouyuu.base.BaseActivity;
import com.ma.ouyuu.entity.PathInfo;
import com.ma.ouyuu.util.Util;

/**
 * name:OuyuU description:AddPathActivity Author:msm Date:2014-10-8 上午11:21:52
 * ReviseRemark: 添加路线
 * 
 * @version1.0
 */
public class AddPathActivity extends BaseActivity implements OnClickListener {

	private ListView listView;
	private Button add_btn, submit_btn;

	private ArrayList<PathInfo> list = new ArrayList<PathInfo>();

	private Dialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_path_layout);
		initView();
		setListener();
	}

	private void initView() {
		listView = (ListView) findViewById(R.id.add_path_more_path_listview);
		add_btn = (Button) findViewById(R.id.add_path_add_more_btn);
		submit_btn = (Button) findViewById(R.id.add_path_submit_btn);
	}

	private void setListener() {
		add_btn.setOnClickListener(this);
		submit_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.add_path_add_more_btn:
			// 添加新路线
			addPath();
			break;
		// case R.id.item_add_path_add_btn://也可以实现点击事件
		// Log.d("text", "add-----------------------------");
		// dialog.dismiss();
		// break;
		case R.id.add_path_submit_btn:
			// 提交数据到服务器
			//把list传到数据库
			
			// 成功后弹框
			AlertDialog.Builder builder = new AlertDialog.Builder(activity);
			builder.setMessage("上传成功").setPositiveButton("查看同路人", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent();
					intent.putParcelableArrayListExtra("list", list);
					intent.setClass(activity, SameRoadPeopleListActivity.class);
					startActivity(intent);
				}
			}).setNegativeButton("继续添加", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			builder.show();
			break;
		default:
			break;
		}
	}

	/**
	 * addPath TODO
	 * 
	 * @param 需要出发地点
	 *            、时间、方式等信息
	 * @param
	 * @return
	 * @return String 用于点击添加路线按钮，弹出框添加路线
	 * @Exception
	 * @since CodingExample Ver1.1
	 */
	private void addPath() {
		dialog = new Dialog(activity);
		LayoutInflater li = LayoutInflater.from(context);
		dialog.show();

		final View view = li.inflate(R.layout.item_add_path, null);
		// view.requestFocus();
		dialog.setContentView(view);

		final EditText startPlace = (EditText) view.findViewById(R.id.item_add_path_start_place_text);
		final EditText startTime = (EditText) view.findViewById(R.id.item_add_path_start_time_text);
		final EditText endPlace = (EditText) view.findViewById(R.id.item_add_path_end_place_text);
		final Spinner travel_way = (Spinner) view.findViewById(R.id.item_add_path_travel_way_spinner);
		GeneralSpinnerAdapter adapter = new GeneralSpinnerAdapter(context, getResources().getStringArray(R.array.travel_way_array));
		travel_way.setAdapter(adapter);
		Button add_path = (Button) view.findViewById(R.id.item_add_path_add_btn);

		add_path.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PathInfo path = new PathInfo();
				path.setStartPlace(Util.getText(startPlace));
				path.setStartTime(Util.getText(startTime));
				path.setEndPlace(Util.getText(endPlace));
				path.setTravelWay(Util.getSelectedSpinnerItem(travel_way, getResources().getStringArray(R.array.travel_way_array)));
				list.add(path);
				PathInfoAdapter pathAdapter = new PathInfoAdapter(context, list);
				listView.setAdapter(pathAdapter);

				pathAdapter.notifyDataSetChanged();
				dialog.dismiss();

			}
		});
	}
}
