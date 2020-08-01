package com.service;

import com.po.Employee;
import com.po.User;

public interface UserService {
	User findUserById(String id);
	void insertUser(User user);
}
