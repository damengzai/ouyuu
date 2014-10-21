package com.ma.ouyuu.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.ma.ouyuu.R;
import com.ma.ouyuu.adapter.GeneralSpinnerAdapter;
import com.ma.ouyuu.base.BaseActivity;

public class EnterMsgActivity extends BaseActivity implements OnClickListener {
	private EditText name_text, qq_text, weibo_text, age_text, password_text;
	private ImageView head_img;
	private Spinner sex_spinner;
	private Button submin_btn;

	// 输入自己的信息,注册

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enter_msg_layout);
		initView();
		setListener();
		setData();

	}

	private void initView() {
		name_text = (EditText) findViewById(R.id.enter_msg_name_text);
		qq_text = (EditText) findViewById(R.id.enter_msg_qq_text);
		weibo_text = (EditText) findViewById(R.id.enter_msg_weibo_text);
		sex_spinner = (Spinner) findViewById(R.id.enter_msg_sex_spinner);
		age_text = (EditText) findViewById(R.id.enter_msg_age_text);
		password_text = (EditText) findViewById(R.id.enter_msg_password_text);
		submin_btn = (Button) findViewById(R.id.enter_msg_submit_btn);
	}

	private void setListener() {
		submin_btn.setOnClickListener(this);
	}

	private void setData() {
		GeneralSpinnerAdapter adapter = new GeneralSpinnerAdapter(context, getResources().getStringArray(R.array.sex_array));
		sex_spinner.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.enter_msg_submit_btn:
			// 提交用户数据然后返回到添加路线的页面

			startActivity(new Intent(EnterMsgActivity.this, AddPathActivity.class));
			break;

		default:
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.main_search:
			// Toast.makeText(EnterMsgActivity.class, '1',
			// Toast.LENGTH_LONG).show();
			Log.d("test", "search");
			break;
		case R.id.main_setting:
			// Toast.makeText(EnterMsgActivity.class, '1',
			// Toast.LENGTH_LONG).show();
			Log.d("test", "setting");
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
