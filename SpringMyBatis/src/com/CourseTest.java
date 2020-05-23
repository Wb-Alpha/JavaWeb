package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.*;
import com.mapper.CourseMapper;
import com.po.Course;
import com.po.Student;
public class CourseTest {	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseMapper courseMapper = applicationContext.getBean(CourseMapper.class);
		Course course = courseMapper.selectCourseByCno(1);
		System.out.println(course);
		//courseMapper.deleteCourseByCno(4);
	}
}
