package com.dao;

import java.util.List;
import com.po.Order;

public interface OrderDao {
	Order selectOrderById(String id);
	List<Order> selectAllOrder();
	void addOrder(Order order);
	void deleteOrderById(String id);
	Order updateOrder(Order order);
}
