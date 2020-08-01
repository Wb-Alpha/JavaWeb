package com.controller;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.po.User;
import com.service.UserService;
@Controller
public class UserController {
	private UserService userService;
	
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
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,Model model,HttpSession session) {
	    // 获取用户名和密码
	    String username = user.getUsername();
	    String password = user.getPassword();
	    //User user1 = userService.findUserById(username);
	    if(username.equals("admin")  && "admin".equals(password)){
	         // 将用户对象添加到Session
	     	session.setAttribute("USER_SESSION", user);
	     	// 重定向到主页面的跳转方法
	    	    return "redirect:main";
	    }
	    model.addAttribute("msg", "用户名或密码错误，请重新登录！");
	    return "login";
	}
	/**
	 * 向用户主页面跳转
	 */
	@RequestMapping(value="/main")
	public String toMain() {
		return "main";
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
}
