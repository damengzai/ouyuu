package com.ma.ouyuu.base;

import android.os.Bundle;

/**
 * 用于Activity和Fragment之间交互的回调接口<br />
 * 由Activity实现该接口
 */
public interface CallBack {
	/**
	 * 回调方法
	 * 
	 * @param args
	 *            传递的参数
	 * @return bundle
	 */
	public Bundle callback(Bundle args);
}
