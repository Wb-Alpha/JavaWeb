package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.CourseMapper;
import com.po.Course;
import com.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	//“¿¿µ◊¢»Î
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public List<Course> findAllCourses() {
		List<Course> courses = courseMapper.selectCourses();
		return courses;
	}

	@Override
	public void addCourse(Course course) {
		courseMapper.insertCourse(course);
		
	}

	@Override
	public void updateCourse(Course course) {
		courseMapper.updateCourse(course);
		
	}

	@Override
	public void deleteCourses(int[] cnoArray) {
		for(int i=0;i<cnoArray.length;i++) {
			courseMapper.deleteCourseByCno(cnoArray[i]);
		}
		
	}

}
