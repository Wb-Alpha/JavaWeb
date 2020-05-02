package com.itheima.instance.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanAssembleTest {
	public static void main(String[] args) {
		String xmlPath = "com/itheima/instance/constructor/Bean4.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
		System.out.println(ac.getBean("user1"));
		System.out.println(ac.getBean("user2"));
	}
}
