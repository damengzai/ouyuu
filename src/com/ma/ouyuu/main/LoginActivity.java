package com.ma.ouyuu.main;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ma.ouyuu.R;
import com.ma.ouyuu.base.BaseActivity;

public class LoginActivity extends BaseActivity implements OnClickListener {

	private TextView name_text, password_text;
	private Button login_btn;
	private SharedPreferences sp = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		initView();
		setListener();
	}

	private void initView() {
		// TODO Auto-generated method stub
		name_text = (TextView) findViewById(R.id.login_name_et);
		password_text = (TextView) findViewById(R.id.login_password_et);
		login_btn = (Button) findViewById(R.id.login_login_btn);
		sp = getSharedPreferences("user_info", MODE_PRIVATE);
	}

	private void setListener() {
		login_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login_login_btn:
			// 登录按钮

			String name = name_text.getText() + "";
			String password = password_text.getText() + "";
			// 与服务器进行登录数据比对
			// 成功
			{
				Editor editor = sp.edit();
				editor.putString("name", name);
				editor.putString("password", password);
				editor.commit();
			}
			// 失败
			{
				Toast.makeText(context, "用户名或密码错误", Toast.LENGTH_LONG).show();
			}
			break;

		default:
			break;
		}
	}
}
