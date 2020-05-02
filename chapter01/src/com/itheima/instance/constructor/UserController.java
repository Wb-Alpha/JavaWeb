package com.itheima.instance.constructor;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller("userController")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	public void save() {
		this.userService.save();
	}
}
