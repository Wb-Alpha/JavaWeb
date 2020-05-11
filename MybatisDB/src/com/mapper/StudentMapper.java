package com.mapper;

import java.util.List;

import com.po.Student;

public interface StudentMapper {
	public Student selectStudentBySno(String sno);
	public List<Student> selectStudentBySname(String sname);
	public int insertStudent(Student student);
	public int deleteStudentById(String sno);
	public int updateStudent(Student stu);
}
