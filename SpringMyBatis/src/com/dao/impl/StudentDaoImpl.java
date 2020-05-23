package com.dao.impl;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dao.StudentDao;
import com.po.Student;

public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao{
	
	public Student selectStudentBySno(String sno) {
		return this.getSqlSession().selectOne("com.mapper.StudentMapper.selectStudentBySno", sno);
	}

	@Override
	public List<Student> selectStudentBySname(String sname) {
		return this.getSqlSession().selectList("com.mapper.StudentMapper.selectStudentBySname", sname);
	}

	@Override
	public int deleteStudent(String sno) {
		return this.getSqlSession().delete("com.mapper.StudentMapper.deleteStudent", sno);
	}

	@Override
	public int updateStudent(Student student) {
		return this.getSqlSession().delete("com.mapper.StudentMappper.updateStudent", student);
	}

	@Override
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert("com.mapper.StudentMappper.deleteStudent", student);
	}

}