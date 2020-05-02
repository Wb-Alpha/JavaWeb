package com.po;

import java.util.List;

public interface CourseDao {
	Course selectCourceById(int cno);
	
	List<Course> selectCourseByName(String cn);
	
	int updateCourse(Course course);
	
	int insertCourse(Course course);
	
	int deleteCourseById(int cno);
	
	int deleteCourseByName(String cn);
}
