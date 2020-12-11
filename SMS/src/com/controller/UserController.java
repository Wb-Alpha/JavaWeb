package com.controller;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.po.Employee;
import com.po.Position;
import com.po.Salary;
import com.po.User;
import com.service.EmployeeService;
import com.service.SalaryService;
import com.service.UserService;
import com.tools.DateTransformer;
import com.tools.TestTools;
import com.tools.XMLUtil;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private SalaryService salaryService;
	
	String date = XMLUtil.getBean();
	
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
	    User user1 = userService.findUserById(userid);
	    if(user1 != null){
	    	if (user1.getPassword().equals(password)) {
		     	List<Salary> list = salaryService.findSalaryByDate(date);
	     		List<Employee> emp_list = employeeService.findAllEmployee();	//拿到全体员工列表
//	     		TestTools.showList(emp_list);     // 打印全体员工列表的
	     		
	     		
		     	String last_month = DateTransformer.lastMonth(date);
		     	System.out.println(last_month+" "+list.size());
		     	List<Salary> list_sal = new ArrayList<Salary>();	// 存储还没有更新薪资的员工
		     	
		     	if (list.size() == 0) {
		     		for (Employee emp : emp_list){
		     			String eno = emp.getEno();	// 提取员工号
//		     			System.out.println(eno);
		     			// 为每一位员工新建这一个月的薪资表
		     			Salary salary = new Salary();
		     			salary.setId(DateTransformer.toSid(date)+eno);
		     			salary.setEno(eno);
		     			salary.setDate(date);
		     			salary.setSalary(emp.getEbase_sal());
		     			salary.setBase_sal(emp.getEbase_sal());    
		     			salary.setMer_sal(0);
		     			salary.setSub(0);
		     			salaryService.addSalary(salary);
		     			
		     			// 为每一位员工初始化他们的薪资表
		     			String sid = DateTransformer.toSid(last_month)+emp.getEno();
		     			Salary salary_last = salaryService.findSalaryByEnoAndDate(sid);
		     			Salary salary_now = salaryService.findSalaryByEnoAndDate(DateTransformer.toSid(date)+emp.getEno());
		     			if (salary_last != null) {
		     				Employee temp = emp;
			     			temp.setEmer_sal(salary_last.getMer_sal());
			     			temp.setEsubsidy(salary_last.getSub());
			     			temp.setEbase_sal(salary_last.getBase_sal());
			     			temp.setEsal(salary_last.getBase_sal()+salary_last.getMer_sal()+salary_last.getSub());
			     			System.out.println(temp.getEno()+" "+salary_now.getBase_sal());
			     			System.out.println(salary_now.toString());
//			     			System.out.println(temp.toString());
			     			employeeService.selfUpdateEmployee(temp);
		     			}
		     		}
		     	}
		     	
		     	if (user1.getIdentify().equals("FM") || user1.getIdentify().equals("admin")) {			     	
			     	for (Employee emp : emp_list) {
//			     		System.out.println(emp.toString());
			     		String sid = DateTransformer.toSid(last_month)+emp.getEno();
				     	Salary salary = salaryService.findSalaryByEnoAndDate(sid);
				     	if (salary != null) {
				     		if ( salary.getMer_sal()==0 || salary.getSub()==0) {
				     			list_sal.add(salary);
				     		}
				     	}
			     	}
			     	session.setAttribute("PREDEAL_SESSION", list_sal.size());
			     	session.setAttribute("PREDEAL_SALARY_SESSION", list_sal);
		     	}
		     	List<Salary> lst = (List<Salary>) session.getAttribute("PREDEAL_SALARY_SESSION");
//		     	TestTools.showList(lst);
		     	session.setAttribute("USER_SESSION", user1);
		     	int num = salaryService.findSalaryByEno(user1.getId()).size();
		     	System.out.println(num);
		     	if (num == 1) {
		     		session.setAttribute("LAST_TIME_SESSION", DateTransformer.getYearAndMon(XMLUtil.getBean()));
		     	}
		     	else {
		     		session.setAttribute("LAST_TIME_SESSION", DateTransformer.getYearAndMon(DateTransformer.lastMonth(XMLUtil.getBean())));
		     	}
			    Employee employee = employeeService.findEmployeeByEno(userid);
		     	session.setAttribute("TIME_SESSION", XMLUtil.getBean());
		     	session.setAttribute("EMPLOYEE_SESSION", employee);
		     	return "redirect:toAdmin";
	    	}
	    }
	    System.out.println("用户名或密码错误，请重新登录！");
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
	 * 向人力资源用户主页面跳转
	 */
	@RequestMapping(value="/toHR")
	public String toHR() {
		return "toHR";
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
	
	// 跳转到用户主页
	@RequestMapping("/userlist")
	public String userList(Model model) {
		List<User> list = userService.findAllUser();
		model.addAttribute("userList", list);
		return "user/userlist";
	}
	
	
	// 跳转到个人信息
	@RequestMapping("/userInfo")
	public String userInfo(HttpSession session) {
		User user = (User) session.getAttribute("USER_SESSION");
     	List<Salary> self_list = salaryService.findSalaryByEno(user.getId());
     	session.setAttribute("SALARY_SESSION", self_list);
		return "user/userInfo";
	}
	
	@RequestMapping(value="/userpreinsert",method=RequestMethod.GET)
	public String userPreinsert() {
		return "user/useradd";
	}
	
	
	//插入新的用户
	@RequestMapping(value="/userinsert", method=RequestMethod.POST)
	public String userInsert(User user, int epos){
		userService.insertUser(user, epos);
		return "redirect:userlist";
	}
	
	@RequestMapping(value="/userpreupdate", method = RequestMethod.GET)
	public String userPreupdate(User user, Model model) {
		model.addAttribute("user", user);
		return "user/userupdate";
	}
	
	@RequestMapping(value="/userupdate", method=RequestMethod.POST)
	public String userUpdate(User user) {
		System.out.println(user);
		userService.updateUser(user);
		return "redirect:userlist";
	}
	
	@RequestMapping("/userpre_selfupdate")
	public String userPreselfupdate(User user,Model model) {
		model.addAttribute("user", user);
		return "user/user_selfupdate";
	}
	
	// 用户修改个人信息
	@RequestMapping(value="/user_selfupdate", method=RequestMethod.POST)
	public String userSelfUpdate(User user, HttpSession session) {
		userService.updateUser(user);
		session.setAttribute("USER_SESSION", user);
		return "redirect:toAdmin";
	}
	
	// 删除用户
	@RequestMapping(value="/userdelete", method=RequestMethod.POST)
	public String userDelete(String[] unoArray) {
		if (unoArray != null) {
			userService.deleteUser(unoArray);
		}
		return "redirect:userlist";
	}

}
