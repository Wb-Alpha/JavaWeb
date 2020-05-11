package com.itheima.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.po.Customer;
import com.itheima.po.User;

//入门程序测试类
public class MybatisTest {
	//根据客户编号查询客户信息
	@Test
	public void findCustomerByIdTest() throws Exception {
		//读取配置文件	
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession执行映射文件种定义的SQL，并且返回映射结果
		Customer customer = sqlSession.selectOne("com.itheima.mapper"+".CustomerMapper.findCustomerById", 1);
		//打印输出结果
		System.out.println(customer.toString());
		//关闭SqlSession
		sqlSession.close();
		
	}
	
	/*
	 * 根据用户名来模糊查询用户信息列表
	 */
	@Test
	public void findCustopmerByNameTest() throws Exception{
		//读取配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession执行映射文件中定义的SQL，并且返回映射结果
		List<Customer> customers = sqlSession.selectList("com.itheima.mapper"+".CustomerMapper.findCustomerByName", "j");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		sqlSession.close();
	}
	
	
	/*
	 * 添加客户
	 */
	@Test
	public void addCustomerTest() throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Customer customer = new Customer();
		customer.setUsername("rose");
		customer.setJobs("student");
		customer.setPhone("13333333533092");
		
		int rows = sqlSession.insert("com.itheima.mapper"+".CustomerMapper.addCustomer", customer);
		
		if (rows>0) {
			System.out.println("您成功插入了"+rows+"条数据！");
		}
		else {
			System.out.println("执行插入操作失败");
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	/*
	 * 更新客户
	 */
	@Test
	public void updateCustomerTest() throws Exception{
		//读取配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession执行更新操作
		Customer customer = new Customer();
		customer.setId(4);
		customer.setUsername("rose");
		customer.setJobs("programmer");
		customer.setPhone("1331111111111");
		
		int rows = sqlSession.update("com.itheima.mapper"+".CustomerMapper.updateCustomer", customer);
		
		if (rows>0) {
			System.out.println("您成功插入了"+rows+"条数据！");
		}
		else {
			System.out.println("执行插入操作失败");
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	/*
	 * 删除用户
	 */
	@Test
	public void deleteCustomerTest() throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int rows = sqlSession.delete("com.itheima.mapper"+".Customer.deleteCustomer", 4);
		
		if (rows>0) {
			System.out.println("您成功插入了"+rows+"条数据！");
		}
		else {
			System.out.println("执行插入操作失败");
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	@Test
	public void findAllUserTest() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("com.itheima.mapper.UserMapper.findAllUser");
		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.close();
	}
}
