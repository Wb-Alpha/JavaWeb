package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.po.Customer;
import com.service.CustomerService;

public class Transaction {
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = act.getBean(CustomerService.class);
		Customer customer = new Customer();
		customer.setUsername("zhangsan");
		customer.setJobs("manager");
		customer.setPhone("132333334444");
		customerService.addCustomer(customer);
	}
}
