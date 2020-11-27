package com.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.po.User;
import com.service.UserService;

public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String userid, String password, Model model, HttpSession session) {
		User user = userService.findUser(userid, password);
		if (user != null) {
			session.setAttribute("USER_SESSION", user);
			return "user";
		}
		model.addAttribute("msg", "账号或者密码错误，请重新输入");
		return "login";	
	}
	
	@RequestMapping(value="/toCustomer.action")
	public String toCustomer() {
		return "customer";
	}
}
