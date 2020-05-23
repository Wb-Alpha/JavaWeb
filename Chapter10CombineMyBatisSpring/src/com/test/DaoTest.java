package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.CustomerDao;
import com.po.Customer;

public class DaoTest {
	@Test
	public void findCustomerByIdTest() {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		//根据容器中的Bean的ID来获取指定的Bean
		CustomerDao customerDao = (CustomerDao) act.getBean("customerDao");
		Customer customer = customerDao.findCustomerById(1);
		System.out.println(customer);	
	}
}
