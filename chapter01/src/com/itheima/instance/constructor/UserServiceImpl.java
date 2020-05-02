package com.itheima.instance.constructor;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
	private UserDao ud;
	@Override
	public void save() {
		// TODO Auto-generated method stub
		this.ud.save();
	}
	
}
