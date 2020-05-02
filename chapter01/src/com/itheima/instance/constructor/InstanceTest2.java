package com.itheima.instance.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest2 {
	public static void main(String[] args) {
		String xmlPath = "com/itheima/instance/constructor/Bean2.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
		System.out.println(ac.getBean("bean2"));
	}
}
