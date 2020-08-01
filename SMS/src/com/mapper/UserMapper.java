package com.mapper;

import com.po.User;

public interface UserMapper {
	User selectUserById(String id);
	void insertUser(User user);
	User updateUser(String id);
}
