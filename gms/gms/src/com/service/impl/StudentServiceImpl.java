package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.StudentMapper;
import com.po.Student;
import com.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService  {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public List<Student> findAllStudent() {
		
		return studentMapper.selectStudents();
	}

	@Override
	public Student findStudentBySno(String sno) {
		
		return studentMapper.selectStudentBySno(sno);
	}

	@Override
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
		
	}

	@Override
	public void deleteStudents(String[] snoArray) {
		for(int i=0;i<snoArray.length;i++) {
			studentMapper.deleteStudentBySno(snoArray[i]);
		}
		
	}

	@Override
	public void updateStudent(Student student) {
		studentMapper.updateStudent(student);
		
	}
	
}
