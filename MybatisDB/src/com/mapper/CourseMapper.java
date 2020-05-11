package com.mapper;

import java.util.List;

import com.po.Course;

public interface CourseMapper {
	public Course selectCourseBySno(String cno);
	public List<Course> selectCourseByCname(String cname);
	public int insertCourse(Course course);
	public int updateCourse(Course course);
}
