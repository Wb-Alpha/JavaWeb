package com.itheima.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JUintTest {
	/*
	 * 使用execute()建表
	 */
	@Test
	public static void mainTest() {
		//加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取JdbcTemplate实例
		JdbcTemplate jdTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
		//使用execute()方法执行SQL语句，创建用户账户管理表
		jdTemplate.execute("create table account("+
							"id int primary key auto_increment,"+
							"username varchar(50),"+
							"balance double)");
		System.out.println("账户account创建成功！");
	}
}

