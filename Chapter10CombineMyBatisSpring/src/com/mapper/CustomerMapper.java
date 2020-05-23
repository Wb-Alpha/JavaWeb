package com.mapper;

import com.po.Customer;

public interface CustomerMapper {
	//通过id查询用户
	public Customer findCustomerById(Integer id);
}
