package com.service;

import java.util.List;

import com.po.User;

public interface UserService {
	User findUserById(String id);
	void insertUser(User user, int epos, int emer_sal, int esubsidy);
	void deleteUser(String[] unoArray);
	List<User> findAllUser();
	List<User> findUserByName(String name);
	void updateUser(User user);
}
