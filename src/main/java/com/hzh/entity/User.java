package com.hzh.entity;

public class User { 
	private String username;//用户名
	private String password;//密码
	private long phone;//手机号
	private int short_num;//短号
	private String wechat;//微信号
	private String head_img;//头像图
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public long getPhone() {
		return phone;
	}
	public int getShort_num() {
		return short_num;
	}
	public String getWechat() {
		return wechat;
	}
	public String getHead_img() {
		return head_img;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setShort_num(int short_num) {
		this.short_num = short_num;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}
	public User() {
		super();
	}
	public User(String username, String password, long phone) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
	}
	
	
}
