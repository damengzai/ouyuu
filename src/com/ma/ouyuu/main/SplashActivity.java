package com.ma.ouyuu.main;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ma.ouyuu.R;
import com.ma.ouyuu.base.BaseActivity;


/**
*
* name:OuyuU
* description:SplashActivity
* Author:msm
* Date:2014-10-21 下午2:21:26
* Revise:Administrator
* ReviseTime:2014-10-21 下午2:21:26
* ReviseRemark:
* @version
*
*	过度动画
*	判断是否显示登录、注册按钮
*
*/
public class SplashActivity extends BaseActivity implements OnClickListener {
	private Button login_btn, reg_btn;
	private SharedPreferences sp = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_layout);
		initView();
		setListener();
		startTimer();
	}

	private void initView() {
		// TODO Auto-generated method stub
		login_btn = (Button) findViewById(R.id.splash_login_btn);
		login_btn.setVisibility(View.VISIBLE);
		reg_btn = (Button) findViewById(R.id.splash_reg_btn);
		reg_btn.setVisibility(View.VISIBLE);
	}

	private void setListener() {
		login_btn.setOnClickListener(this);
		reg_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.splash_login_btn:
			// 登录按钮
			startActivity(new Intent(SplashActivity.this, LoginActivity.class));
			break;
		case R.id.splash_reg_btn:
			// 注册按钮

			startActivity(new Intent(SplashActivity.this, EnterMsgActivity.class));

			break;

		default:
			break;
		}
	}

	private void startTimer() {
		// TODO Auto-generated method stub
		final Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sp = getSharedPreferences("user_info", MODE_PRIVATE);
				if (sp != null) {
					String name = sp.getString("name", "");
					String password = sp.getString("password", "");
					// 将数据与服务器对比
					{

					}
					// 成功则直接登录
					{
						startActivity(new Intent(SplashActivity.this, MyPathActivity.class));
//						timer.cancel();
						finish();
					}
					// 失败则显示登录与注册的按钮
					{
						login_btn.setVisibility(View.VISIBLE);
						reg_btn.setVisibility(View.VISIBLE);

					}
				}
			}
		};
		timer.schedule(task, 1000 * 3);
	}

}
