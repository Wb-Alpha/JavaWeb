package com.itheima.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.po.Customer;

public class MyBatisTest2{
	static InputStream inputStream;
	static String resource;
	static SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void test() throws Exception{
		//读取配置文件	
		resource = "mybatis-config.xml";
		inputStream = Resources.getResourceAsStream(resource);
		//根据配置文件构建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//根据客户编号查询客户信息
	@Test
	public void findCustomerByIdTest() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		//SqlSession执行映射文件种定义的SQL，并且返回映射结果
		
		Customer customer = sqlSession.selectOne("com.itheima.mapper"+".CustomerMapper.findCustomerById", 1);
		//打印输出结果
		System.out.println(customer.toString());
		//关闭SqlSession
		sqlSession.close();
		
	}
	
	public static void main(String[] args) throws Exception{
		MyBatisTest2 myBatisTest = new MyBatisTest2();
		myBatisTest.test();
		myBatisTest.findCustomerByIdTest();
	}
}
