package com.ma.ouyuu.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.ma.ouyuu.R;
import com.ma.ouyuu.adapter.MyPathAdapter;
import com.ma.ouyuu.base.BaseActivity;

public class MyPathActivity extends BaseActivity implements OnClickListener {
	private Button add_path_btn;
	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_path_layout);
		initView();
		setListener();
	}

	private void initView() {
		listview = (ListView) findViewById(R.id.my_path_listview);
		add_path_btn = (Button) findViewById(R.id.my_path_add_path_btn);
	}

	/**
	 * 设置数据
	 */
	private void setData() {
		List<Map<String, String>> pathList = new ArrayList<Map<String, String>>();
		// 去后台查询数据，放到pathList中
		
		MyPathAdapter pathAdapter = new MyPathAdapter(activity, pathList);
		listview.setAdapter(pathAdapter);
	}

	private void setListener() {
		add_path_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.my_path_add_path_btn:
			//添加路线按钮
			Intent intent = new Intent();
			intent.setClass(MyPathActivity.this, AddPathActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	@Override
	protected void onResume() {
		setData();
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.add_path_menu, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_path_menu_add_path:
			// 菜单栏添加路线按钮
			Intent intent = new Intent();
			intent.setClass(MyPathActivity.this, AddPathActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
