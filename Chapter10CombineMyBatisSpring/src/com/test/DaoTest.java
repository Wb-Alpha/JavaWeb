package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.CustomerDao;
import com.mapper.CustomerMapper;
import com.po.Customer;

public class DaoTest {
	@Test
	public void findCustomerByIdDaoTest() {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao customerDao  =(CustomerDao) act.getBean("customerDao");
		Customer customer = customerDao.findCustomerById(1);
		System.out.println(customer);
	}
	
	
	@Test
	public void findCustomerByIdMapperTest() {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerMapper customerMapper = act.getBean(CustomerMapper.class);
		Customer customer = customerMapper.findCustomerById(1);
	}
}
