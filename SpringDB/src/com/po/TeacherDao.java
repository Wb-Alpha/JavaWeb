package com.po;

import java.util.List;

public interface TeacherDao {
	Course selectTeacherById(int tno);
	
	List<Course> selectTeacherByName(String tn);
	
	int updateTeacher(Teacher teacher);
	
	int insertTeacher(Teacher teacher);
	
	int deleteTeacherById(int tno);
	
	int deleteTeacherByName(String tn);
}
