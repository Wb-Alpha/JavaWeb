package com.po;

public class User {
	private String id;        //id
	private String username;  //用户名
	private String password;  //密码
	private String identify;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getIdentify() {
		return identify;
	}


	public void setIdentify(String identify) {
		this.identify = identify;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", identify=" + identify + "]";
	}
	
}
