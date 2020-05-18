package com.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.po.Person;
import com.po.User;
import com.tools.MybatisUtils;

public class MybatisAssociationTest {

	/*
	 * 嵌套查询
	 */
	@Test
	public void findPersonByIdTest() {
		SqlSession session = MybatisUtils.getSession();
		Person person = session.selectOne("com.mapper."+"PersonMapper.findPersonById", 1);
		System.out.println(person);
		session.close();
	}

	/*
	@Test
	public void findPersonByIdTest2() {
		SqlSession session = MybatisUtils.getSession();
		Person person = session.selectOne("com.mapper."+"PersonMapper.findPersonById2");
		System.out.println(person);
		session.close();
	}*/
	
	@Test
	public void findUserTest() {
		SqlSession session = MybatisUtils.getSession();
		User user = session.selectOne("com.mapper."+"UserMapper.findUserWithPrders", 1);
		System.out.println(user);
		session.close();
	}
}
