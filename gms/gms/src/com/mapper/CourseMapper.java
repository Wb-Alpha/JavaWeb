package com.mapper;

import java.util.List;

import com.po.Course;

public interface CourseMapper {

	List<Course> selectCourseByCno(int cno);
	List<Course> selectCourseByCname(String cname);
	List<Course> selectCourses();
	void insertCourse(Course course);
	void updateCourse(Course course);
	void deleteCourseByCno(int cno);
	
}
