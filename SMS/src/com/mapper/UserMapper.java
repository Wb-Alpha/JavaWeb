package com.mapper;

import java.util.List;

import com.po.User;

public interface UserMapper {
	User selectUserById(String id);
	void insertUser(User user);
	void updateUser(User user);
	List<User> selectAllUsers();
	List<User> selectUserByName(String username);
	void deleteUserById(String id);
}
