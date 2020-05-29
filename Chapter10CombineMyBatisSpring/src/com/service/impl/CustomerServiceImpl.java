package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mapper.CustomerMapper;
import com.po.Customer;
import com.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	//注解注入CustomerMapper
	@Autowired
	private CustomerMapper customerMapper;
	
	//添加客户
	public void addCustomer(Customer customer) {
		this.customerMapper.addCustomer(customer);
		int i = 1/0;
	}
	
}
