package com.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dao.CustomerDao;
import com.po.Customer;

public class CustomerDaoImpl extends SqlSessionDaoSupport implements CustomerDao{

	@Override
	public Customer findCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("com.po"+".CustomerMapper.findCustomerById");
	}

}
