package com.itheima.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.po.Customer;

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
	}
}
