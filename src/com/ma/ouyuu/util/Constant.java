package com.ma.ouyuu.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Constant extends Application {
	/**
	 * sharedpreferences 存储文件名
	 * */
	public static final String SPConfig = "app_config";

	public SharedPreferences preferences;

	public static final int SMS_TIME = 60;
	public static final String KEY_ACTIONID = "ActionId";// vx 浏览器传参 actionid
															// key值
	public static final String KEY_ACTIONNAME = "ActionName";// vx 浏览器传参 title
																// key值
	public static final int REQUESTCODE = 100;// activity回调 请求码
	public static final int RESULTCODE = 101;// activity回调 返回码
	public static final String KEY_USERINFO = "UserInfo";
	public static final String KEY_WEB_TITLE = "WebTitle";// 给自定义浏览器传参 title
															// key值
	public static final String KEY_WEB_URL = "WebUrl";// 给自定义浏览器传参 url key值
	public static final String KEY_WEB_FLAG = "WebFlag";// 给自定义浏览器传参 url key值
	// public static final int contentId = R.id.content_ll;

	public static final String ProgressHint = "加载中...";
	public static final String ProgressTimeOutHint = "数据加载失败，请检查网络！";
	public static final String SmsAuthBtnHint = "发送验证码";

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		preferences = getSharedPreferences(SPConfig, Context.MODE_PRIVATE);
	}

	/**
	 * 服务器时间戳信息
	 * */
	private String Timestamp = "";
	/**
	 * 用户信息
	 * */
	// private UserInfo userInfo;
	/**
	 * 登录状态
	 * */
	private boolean isLogin = false;

	/**
	 * SharedPreferences本地存储
	 * 
	 * @return boolean
	 * */
	public boolean getToggleState(String key) {
		return preferences.getBoolean(key, false);
	}

	/**
	 * SharedPreferences本地存储
	 * 
	 * @param boolean
	 * */
	public void setToggleState(String key, boolean state) {
		preferences.edit().putBoolean(key, state).commit();
	}

	/**
	 * SharedPreferences本地存储
	 * 
	 * @return String
	 * */
	public String getToggleString(String key) {
		return preferences.getString(key, "");
	}

	/**
	 * SharedPreferences本地存储
	 * 
	 * @param String
	 * */
	public void setToggleString(String key, String value) {
		preferences.edit().putString(key, value).commit();
	}

	/**
	 * SharedPreferences本地存储
	 * 
	 * @return int
	 * */
	public int getToggleInt(String key) {
		return preferences.getInt(key, -1);
	}

	/**
	 * SharedPreferences本地存储
	 * 
	 * @param int
	 * */
	public void setToggleInt(String key, int value) {
		preferences.edit().putInt(key, value).commit();
	}


	public Editor getToggleEdit() {
		return preferences.edit();
	}

	public String getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}

	// public UserInfo getUserInfo() {
	// return userInfo;
	// }
	//
	// public void setUserInfo(UserInfo userInfo) {
	// this.userInfo = userInfo;
	// }

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

}
