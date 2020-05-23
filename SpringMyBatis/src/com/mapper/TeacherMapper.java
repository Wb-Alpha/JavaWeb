package com.mapper;
import java.util.List;

import com.po.Teacher;

public interface TeacherMapper {
	Teacher selectTeacherByTno(int tno);
	List<Teacher> selectTeacherByTname(String tname);
	int insertTeacher(Teacher teaher);
	int deleteTeacherByTno(String string);
	int updateTeacher(Teacher teacher);
}