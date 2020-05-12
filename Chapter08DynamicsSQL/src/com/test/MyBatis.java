package com.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.po.Customer;
import com.utils.*;

public class MyBatis {
	@Test
	public void findCustomerByNameAndJobsTest() {
		SqlSession session = MybatisUtils.getSession();
		Customer customer = new Customer();
	    customer.setUsername("Jack");
	    customer.setJobs("teacher");
	    List<Customer> customers = session.selectList("com.mapper"+".CustomerMapper.findCustomerByNameAndJobs", customer);
	    for (Customer customer2 : customers) {
	    	System.out.println(customer2);
	    }
	    
	    session.close();
	}
	
	@Test
	public void findCustomerByNameOrJobsTest() {
		SqlSession session = MybatisUtils.getSession();
		Customer customer = new Customer();
		customer.setUsername("jack");
		customer.setJobs("teacher");
		
		List<Customer> customers = session.selectList("com.mapper"+".CustomerMapper.findCustomerByNameOrJobs", customer);
		for (Customer customer2 : customers) {
			System.out.println(customer2);
		}
		session.close();
	}
	
	@Test
	public void updateCustomerTest() {
		SqlSession session = MybatisUtils.getSession();
		Customer customer = new Customer();
		customer.setId(3);
		customer.setPhone("13311111234");
		
		int row = session.update("com.mapper"+".CustomerMapper.updateCustomer", customer);
		if (row >0) {
			System.out.println("宁成功修改了"+row+"条数据");
		}
		else
			System.out.println("修改失败");
		session.commit();
		session.close();
	}
	
	@Test
	public void findCustomerByIdsTest(){
		SqlSession session = MybatisUtils.getSession();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		
		List<Customer> customers = session.selectList("com.mapper"+".CustomerMapper.findCustomerByIds", ids);
		for (Customer customer : customers){
			System.out.println(customer);
		}
		
		session.close();
	}
	
	@Test
	public void findCustomerByNameTest() {
		SqlSession session = MybatisUtils.getSession();
		Customer customer = new Customer();
		customer.setUsername("j");
		List<Customer> customers = session.selectList("com.mapper"+".CustomerMapper.findCustomerByName", customer);
		for (Customer customer2 : customers) {
			System.out.println(customer2);
		}
		session.close();
	}
}
