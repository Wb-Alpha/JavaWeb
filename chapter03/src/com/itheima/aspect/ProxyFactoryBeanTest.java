package com.itheima.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.jdk.UserDao;

public class ProxyFactoryBeanTest {
	public static void main(String[] args) {
		String xmlPath = "com/itheima/factorybean/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
		//从Spring容器中或的内容
		UserDao userDao = (UserDao) ac.getBean("userDaoProxy");
		//执行方法
		userDao.addUser();
		userDao.deleteUser();
	}
}
