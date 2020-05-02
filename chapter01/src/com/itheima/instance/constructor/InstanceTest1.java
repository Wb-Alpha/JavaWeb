package com.itheima.instance.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest1 {
	public static void main(String[] args) {
		String xmlPath = "com/itheima/instance/constructor/bean1.xml";
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(xmlPath);
		Bean1 bean = (Bean1)applicationContext.getBean("bean1");
		System.out.println(bean);
	}
}
