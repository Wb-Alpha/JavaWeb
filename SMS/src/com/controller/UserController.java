package com.controller;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.po.Employee;
import com.po.User;
import com.service.EmployeeService;
import com.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private EmployeeService employeeService;
	
	/**	 
	 * 向用户登录页面跳转
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toLogin() {
		return "login";
	}
	
	/**
	 * 用户登录
	 */
	@RequestMapping(value="/login")
	public String login(User user,Model model,HttpSession session, HttpSession session1) {
	    // 获取用户名和密码
	    String userid = user.getId();
	    String password = user.getPassword();
	    System.out.println(userid+" "+password);
	    Employee employee = employeeService.findEmployeeByEno(userid);
	    User user1 = userService.findUserById(userid);
	    if(user1 != null){
	    	if (user1.getPassword().equals(password)) {
		     	session.setAttribute("USER_SESSION", user1);
		     	session.setAttribute("EMPLOYEE_SESSION", employee);
		    	if (user1.getIdentify().equals("admin")) {
			     	// 重定向到主页面的跳转方法
			    	return "redirect:toAdmin";
		    	}
		    	else if (user1.getIdentify().equals("user")) {
			     	// 重定向到主页面的跳转方法
			    	return "redirect:toNormal";
		    	}
		    	else if (user1.getIdentify().equals("FM")) {
		    		return "redirect:toFM";
		    	}
		    	else if (user1.getIdentify().equals("PR")) {
		    		return "redirect:toPR";
		    	}
	    	}
	    }

	    model.addAttribute("msg", "用户名或密码错误，请重新登录！");
	    return "login";
	}

	/**
	 * 向 管理员主页面跳转
	 */
	@RequestMapping(value="/toAdmin")
	public String toAdmin() {
		return "toAdmin";
	}
	
	/**
	 * 向普通用户主页面跳转
	 */
	@RequestMapping(value="/toNormal")
	public String toNormal() {
		return "toNormal";
	}
	
	/**
	 * 向财务部用户主页面跳转
	 */
	@RequestMapping(value="/toFM")
	public String toFM() {
		return "toFM";
	}
	
    /**
               * 退出登录
     */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// 清除Session
		session.invalidate();
		// 重定向到登录页面的跳转方法
		return "redirect:login";
	}
	
	@RequestMapping(value = "/employee")
	public String turnToEmployee(HttpSession session) {
		// 清除Session
		session.invalidate();
		return "employee/employeelist";
	}
	
	@RequestMapping("/userlist")
	public String userList(Model model) {
		List<User> list = userService.findAllUser();
		model.addAttribute("userList", list);
		return "user/userlist";
	}
	
	@RequestMapping("/userInfo")
	public String userInfo(HttpSession session) {
		return "user/userInfo";
	}
	
	@RequestMapping(value="/userpreinsert",method=RequestMethod.GET)
	public String userPreinsert() {
		return "user/useradd";
	}
	
	@RequestMapping(value="/userinsert", method=RequestMethod.POST)
	public String userInsert(User user, int epos, int emer_sal,int esubsidy){
		System.out.println(epos);
		userService.insertUser(user, epos, emer_sal, esubsidy);
		return "redirect:userlist";
	}
	
	@RequestMapping(value="/userdelete", method=RequestMethod.POST)
	public String userDelete(String[] unoArray) {
		if (unoArray != null) {
			userService.deleteUser(unoArray);
		}
		return "redirect:userlist";
	}
	

}
