package com.service;

import com.po.User;

public interface UserService {
	public User findUser(String userid, String password);
}
