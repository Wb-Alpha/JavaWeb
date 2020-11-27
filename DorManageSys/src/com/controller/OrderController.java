package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Order;
import com.service.impl.OrderServiceImp;

@Controller
public class OrderController {
	@Autowired
	private OrderServiceImp orderService;
	
	@RequestMapping("/orderlist")
	public String orderList(Model model) {
		List<Order> list = orderService.findAllOrder();
		model.addAttribute("orderList", list);
		return "order/orederList";
	}
}
