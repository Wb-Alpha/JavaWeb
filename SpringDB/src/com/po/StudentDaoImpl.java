package com.po;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Student selectStudentById(String sid) {
		// TODO Auto-generated method stub
		/*Student stu = new Student();
		stu.setSid(sid);
		return stu;*/
		String sql = "select * from stu where sno=?";
		return null; 
	}

	@Override
	public List<Student> selectStudentByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from stu where sn=?";
		Object[] obj = new Object[] {name};
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
		return this.jdbcTemplate.query(sql, obj, rowMapper);
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		//定义sql
		String sql = "update stu set sno=?, sn=?";
		//定义数组来存储sql语句中的参数
		Object[] params = new Object[] {
			student.getSid(),
			student.getSname()
		};
		//执行更新操作
		int num = this.jdbcTemplate.update(sql, params);
		return 0;
	}

	@Override
	public int deleteStudentById(String sid) {
		//SQL语句
		String sql = "delete from stu where sno=?";
		//执行更新操作，返回受影响行数
		int num = this.jdbcTemplate.update(sql, sid);
		return num;
	}

	@Override
	public int deleteStudentByName(String name) {
		//sql语句
		String sql = "delete from stu where sn=?";
		//执行更新操作，返回受到影响行数
		int num = this.jdbcTemplate.update(sql, name);
		return num;
	}

	@Override
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		//SQL语句
		String sql = "insert into stu(sno,no) values (?,?)";
		//创建数组储存参数
		Object[] params = new Object[] {
			student.getSid(),
			student.getSname()
		};
		//执行插入操作，并且返回受影响行数
		int num = this.jdbcTemplate.update(sql, params);
		return num;
	}

}
