package com.dao;
import java.util.List;

import com.po.Student;

public interface StudentDao {
	Student selectStudentBySno(String sno);
	List<Student> selectStudentBySname(String sname);	// 按姓名模糊查询
	int deleteStudent(String sno);			// 按指定学号删除一条学生记录
	int updateStudent(Student student);	// 按学号更新学生信息
	int insertStudent(Student student);	// 插入一条学生信息
}