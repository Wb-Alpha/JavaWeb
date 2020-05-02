package com.po;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
	public static void main(String[] args) {
		//加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取JdbcTemplate实例
		JdbcTemplate jdTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
	}
	
	public void insertStudentTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studentDao = (StudentDao)applicationContext.getBean("studentDao");
		Student stu = new Student();
		stu.setSid("1000001");
		stu.setSname("Tom");
		int num = studentDao.insertStudent(stu);
		if (num > 0) {
			System.out.println("成功插入"+num+"条数据");
		}
		else {
			System.out.println("操作失败");
		}
	}
	
	public void updateStudentTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studentDao = (StudentDao)applicationContext.getBean("studentDao");
		Student stu = new Student();
		stu.setSid("114514");
		stu.setSname("Tom");
		int num = studentDao.insertStudent(stu);
		if (num > 0) {
			System.out.println("成功插入"+num+"条数据");
		}
		else {
			System.out.println("插入操作执行失败！");
		}
	}
	
	public void selectStudentByNameTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studentDao = (StudentDao)applicationContext.getBean("studentDao");
		Student stu = (Student)studentDao.selectStudentByName("Tom");
	}
	
	public void deleteStudentTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studentDao = (StudentDao)applicationContext.getBean("studentDao");
		Student stu = new Student();
		stu.setSname("Tom");
		studentDao.selectStudentByName(stu.getSname());
	}
}
