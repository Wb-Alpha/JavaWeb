package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.OrderDao;
import com.po.Order;
import com.service.OrderService;

@Service
@Transactional
public class OrderServiceImp implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order findOrderById(String id) {
		// TODO Auto-generated method stub
		return orderDao.selectOrderById(id);
	}

	@Override
	public List<Order> findAllOrder() {
		// TODO Auto-generated method stub
		return orderDao.selectAllOrder();
	}

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		orderDao.addOrder(order);
	}

	@Override
	public void deleteOrderById(String id) {
		// TODO Auto-generated method stub
		orderDao.deleteOrderById(id);
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		orderDao.updateOrder(order);
	}
}
