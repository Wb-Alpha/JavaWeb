package com.service;

import java.util.List;

import com.po.Course;

public interface CourseService {

	
	List<Course> findAllCourses();
	void addCourse(Course course);
	void updateCourse(Course course);
	void deleteCourses(int[] cnoArray);
}
