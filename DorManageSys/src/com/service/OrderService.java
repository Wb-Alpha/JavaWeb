package com.service;

import java.util.List;
import com.po.Order;

public interface OrderService {
	Order findOrderById(String id);
	List<Order> findAllOrder();
	void addOrder(Order order);
	void deleteOrderById(String id);
	void updateOrder(Order order);
}
