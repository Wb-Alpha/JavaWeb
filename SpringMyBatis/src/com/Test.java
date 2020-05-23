package com;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.*;
import com.po.Student;
public class Test {	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studentDao = (StudentDao)applicationContext.getBean("studentDao");
		Student student = studentDao.selectStudentBySno("100000001");
		System.out.println(student);
		
		List<Student> studentList = studentDao.selectStudentBySname("Xiao");
		for(Student stu : studentList) {System.out.println(studentList);}
		
		int num = 0;
		num = studentDao.deleteStudent("100000002");
		if (num != 0) 
			System.out.println("已成功插入数据"+num+"条");
		else 
			System.out.println("插入失败");
		
		num = 0;
		Student stu1 = new Student();
		stu1.setSno("114514");
		stu1.setSname("LingRiJin");
		stu1.setSsex("M");
		stu1.setSnative("Xinyi");
		num = studentDao.updateStudent(stu1);
		if (num != 0) 
			System.out.println("已成功插入数据"+num+"条");
		else 
			System.out.println("更新失败");
		
		
		
	}
}