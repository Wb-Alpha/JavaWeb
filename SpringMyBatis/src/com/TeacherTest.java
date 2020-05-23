package com;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.*;
import com.mapper.CourseMapper;
import com.mapper.TeacherMapper;
import com.po.Course;
import com.po.Student;
import com.po.Teacher;

public class TeacherTest {	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherMapper teacherMapper = applicationContext.getBean(TeacherMapper.class);
		Teacher teacher = teacherMapper.selectTeacherByTno(1);
		System.out.println(teacher);
		
		
		List<Teacher> teacherList = teacherMapper.selectTeacherByTname("Yang");
		for (Teacher teach : teacherList) {
			System.out.println(teach);
		}
		
		int num = 0;
		Teacher teach1 = new Teacher();
		teach1.setTno("114514");
		teach1.setTname("PingAn Gao");
		teach1.setTsex("M");
		teach1.setTel("13345287598");
		num = teacherMapper.insertTeacher(teach1);
		if (num != 0) 
			System.out.println("已成功插入数据"+num+"条");
		else 
			System.out.println("更新失败");
		
		
		num = 0;
		num = teacherMapper.deleteTeacherByTno("1");
		if (num != 0) 
			System.out.println("已成功删除数据"+num+"条");
		else 
			System.out.println("删除失败");
		
		
		num = 0;
		Teacher teach2 = new Teacher();
		teach2.setTno("145783");
		teach1.setTname("Mason Lee");
		teach1.setTsex("M");
		teach1.setTel("1334528888");
		num = teacherMapper.updateTeacher(teacher);
		if (num != 0) 
			System.out.println("已成功插入数据"+num+"条");
		else 
			System.out.println("更新失败");
	}
}
