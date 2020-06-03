package com.mapper;

import com.po.Course;

public interface CourseMapper {
	Course selectCourseByCno(int cno);
	Course selectCourseByCname(String cname);
	void insertCourse(Course course);
	void deleteCourseByCno(int cno);
	void updateCourse(Course course);
	
}