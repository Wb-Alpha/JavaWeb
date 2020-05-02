package com.itheima.instance.constructor;

import java.util.List;

public class User {
	private String username;
	private Integer pwd;
	private List<String> list;

	public User(String username) {//, Integer pwd, List<String> list) {
		super();
		this.username = username;
		//this.pwd = pwd;
		//this.list = list;
	}
	
	public User(){
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPwd() {
		return pwd;
	}

	public void setPwd(Integer pwd) {
		this.pwd = pwd;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
}
