package com;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.po.Student;
import com.utils.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = StudentDBUtils.getSession();
		int count = -1;
		
		// 精确查询测试
		Student student = sqlSession.selectOne("com.mapper.StudentMapper.selectStudentBySno", "100000001");
		System.out.println(student);
		
		// 模糊查询测试
		List<Student> list = sqlSession.selectList("com.mapper.StudentMapper.selectStudentBySname", "小");
		for (Student stu : list)
			System.out.println(stu);
		
		// 插入记录测试
		student = new Student();
		student.setSno("100000005");
		student.setSname("刘伟");
		student.setSsex("男");
		student.setSnative("广东汕头");
		student.setMno(2);
		sqlSession = StudentDBUtils.getSession();
		count = sqlSession.insert("com.mapper.StudentMapper.insertStudent", student);
		sqlSession.commit();
		System.out.println("成功插入了" + count + "条记录。");
/*	
		// 删除记录测试
		count = sqlSession.insert("com.mapper.StudentMapper.deleteStudent", "100000004");
		sqlSession.commit();
		System.out.println("成功删除了" + count + "条记录。");

		// 更新记录测试
		student.setSno("100000002");
		student.setSname("廖凡");
		student.setSsex("男");
		student.setSnative("广东汕头");
		student.setMno(2);
		count = sqlSession.insert("com.mapper.StudentMapper.updateStudent", student);
		sqlSession.commit();
		System.out.println("成功更新了" + count + "条记录。");
	*/	
		sqlSession.close();
	}
}
