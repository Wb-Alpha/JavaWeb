package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FirstController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//创建对应的对象
		ModelAndView mav = new ModelAndView();
		//向模型中添加数据
		mav.addObject("msg", "这是我的第一个MVC程序");
		//设置逻辑视图名
		mav.setViewName("/WEB-INF/jsp/first.jsp");
		//返回ModelAndView对象                                                                        
		return mav;
	}
	
}
