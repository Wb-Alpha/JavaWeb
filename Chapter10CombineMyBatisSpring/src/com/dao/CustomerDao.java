package com.dao;

import com.po.Customer;

public interface CustomerDao {
	public Customer findCustomerById(Integer id);
}
