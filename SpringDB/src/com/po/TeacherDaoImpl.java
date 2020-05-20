package com.po;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TeacherDaoImpl implements TeacherDao{

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Course selectTeacherById(int tno) {
		return null;
	}

	@Override
	public List<Course> selectTeacherByName(String tn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTeacherById(int tno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTeacherByName(String cn) {
		// TODO Auto-generated method stub
		return 0;
	}

}
