package com.ma.ouyuu.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {

	/**
	 * serialVersionUID:TODO
	 * 
	 * @since Ver 1.1
	 */

	private static final long serialVersionUID = 1980878L;

	private int age;
	private String name;
	private String headImg;
	private String password;
	private String qq;
	private String sex;
	private String weibo;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
}
