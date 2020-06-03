package com.vo;

import java.util.List;

import com.po.*;
/*
 * 用户包装类
 */

public class UserVO {
	private List<User> users;
	
	public List<User> getUser(){
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
