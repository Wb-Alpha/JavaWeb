package com.po;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CourseDaoImpl implements CourseDao{

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Course selectCourceById(int cno) {
		// TODO Auto-generated method stub
		String sql = "select * from course where cno=?";
		RowMapper<Course> rowMapper = new BeanPropertyRowMapper(Course.class);
		return this.jdbcTemplate.queryForObject(sql, rowMapper, cno);
	}

	@Override
	public List<Course> selectCourseByName(String cn) {
		// TODO Auto-generated method stub
		String sql = "select * from course where cn=?";
		RowMapper<Course> rowMapper = new BeanPropertyRowMapper(Course.class);
		return this.jdbcTemplate.query(sql, rowMapper, cn);
	}

	@Override
	public int updateCourse(Course course) {
		// TODO Auto-generated method stub
		String sql = "update course set cno=?, cn=?";
		Object[] params = new Object[] {
				course.getCno(),
				course.getCn()
		};
		int num = this.jdbcTemplate.update(sql, params);
		return num;
	}

	@Override
	public int insertCourse(Course course) {
		// TODO Auto-generated method stub
		String sql = "insert into course(cno,cn) values (?,?)";
		Object[] params = new Object[] {
				course.getCno(),
				course.getCn()
		};
		int num = this.jdbcTemplate.update(sql, params);
		return num;
	}

	@Override
	public int deleteCourseById(int cno) {
		// TODO Auto-generated method stub
		String sql = "delete from course where cno=?";
		int num = this.jdbcTemplate.update(sql,cno);
		return num;
	}

	@Override
	public int deleteCourseByName(String cn) {
		// TODO Auto-generated method stub
		String sql = "delete from course where cn=?";
		int num = this.jdbcTemplate.update(sql, cn);
		return num;
	}

}
