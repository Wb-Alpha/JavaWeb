package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Order;
import com.po.User;

public class OrdersController {
	/*
	 * 向订单查询页面跳转
	 */
	@RequestMapping("/tofindOrderWithUser")
	public String tofindOrderWithUser() {
		return "order";
	}
	
	/*
	 * 查询订单和用户信息
	 */
	@RequestMapping("/finOrderWithUser")
	public String findOrderWithUser(Order orders) {
		Integer orderId = orders.getOrderId();
		User user = orders.getUser();
		String username = user.getUsername();
		System.out.println("orderId="+orderId);
		System.out.println("username="+username);
		return "success";
	}
}
