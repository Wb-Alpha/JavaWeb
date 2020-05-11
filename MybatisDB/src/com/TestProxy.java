package com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mapper.StudentMapper;
import com.po.Student;
import com.utils.StudentDBUtils;

public class TestProxy {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = StudentDBUtils.getSession();
		int count = -1;

		
		// 生成Mapper的代理对象studentMapper
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		// 精确查询测试
	
		Student student = studentMapper.selectStudentBySno("100000001");
		System.out.println(student);
		
		
		List<Student> list= studentMapper.selectStudentBySname("尚小云");
		for (Student stu : list)
			System.out.println(stu);
		
		Student student2 = new Student();
		student2.setSno("11000000659");
		student2.setSname("赵志峰");
		student2.setSsex("男");
		student2.setSnative("湛江");
		count = studentMapper.insertStudent(student2);
		System.out.println(count);
		
		int row= studentMapper.deleteStudentById("11000000659");
		System.out.println(row);
		
		
		Student stu = new Student();
		stu.setSno("10086");
		stu.setSname("李狗嗨");
		count = studentMapper.updateStudent(stu);
		
		sqlSession.close();
	}
}
