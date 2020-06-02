package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.User;

@Controller
public class UserController {
	@RequestMapping("/selectUser")
	public String selectUser(Integer id) {
		System.out.println("id="+id);
		return "success";
	}
	
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register";
	}
	
	@RequestMapping("/registerUser")
	public String registerUser(User user) {
		String username = user.getUsername();
		Integer password = user.getPassword();
		System.out.println("username="+username);
		System.out.println("password="+password);
		return "success";
	}
}
