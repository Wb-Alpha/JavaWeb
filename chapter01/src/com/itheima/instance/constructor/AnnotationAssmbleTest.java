package com.itheima.instance.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAssmbleTest {
	public static void main(String[] args) {
		String xmlPath = "com/itheima/instance/constructor/AnnotationLoad.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
		UserController uc = (UserController)ac.getBean("userController");
		uc.save();
	}
}
