package com.po;

import java.util.List;

public interface StudentDao {
	Student selectStudentById(String sid);
	List<Student> selectStudentByName(String name);
	int updateStudent(Student student);
	int deleteStudentById(String sid);
	int deleteStudentByName(String name);
	int insertStudent(Student student);
}
