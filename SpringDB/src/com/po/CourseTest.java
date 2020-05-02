package com.po;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class CourseTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
	}
	
	public void selectCourseByIdTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao courseDao = (CourseDao)applicationContext.getBean("courseDao");
		courseDao.selectCourceById(19890604);
		courseDao.toString();
	}
	
	public void selectCourseByNameTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao courseDao = (CourseDao)applicationContext.getBean("courseDao");
		courseDao.selectCourseByName("MachineLearning");
		courseDao.toString();
	}
	
	public void insertCourseTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao courseDao = (CourseDao)applicationContext.getBean("courseDao");
		Course cou = new Course();
		cou.setCno(114514);
		cou.setCn("JavaEE");
		int num = courseDao.insertCourse(cou);
		if (num > 0) {
			System.out.println("成功插入"+num+"条数据");
		}
		else {
			System.out.println("操作失败");
		}
	}
	
	
	public void updateCourseTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao courseDao = (CourseDao)applicationContext.getBean("courseDao");
		Course cou = new Course();
		cou.setCno(19890604);
		cou.setCn("MachineLearning");
		int num = courseDao.updateCourse(cou);
		if (num > 0) {
			System.out.println("成功插入"+num+"条数据");
		}
		else {
			System.out.println("操作失败");
		}
	}
	
	
	public void deleteCourseByIdTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao courseDao = (CourseDao)applicationContext.getBean("courseDao");
		int num = courseDao.deleteCourseById(114514);
		if (num > 0) {
			System.out.println("成功插入"+num+"条数据");
		}
		else {
			System.out.println("操作失败");
		}
	}
	
	public void deleteCourseByName() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao courseDao = (CourseDao)applicationContext.getBean("courseDao");
		int num = courseDao.deleteCourseByName("JavaEE");
		if (num > 0) {
			System.out.println("成功插入"+num+"条数据");
		}
		else {
			System.out.println("操作失败");
		}
	}
}
