package com.dao;

import org.apache.ibatis.annotations.Param;
import com.po.User;

public interface UserDao {
	public User findUserById(@Param("userid") String userid,
			@Param("password") String password);
}
