package com.mapper;

import java.util.List;
import com.po.Salary;

public interface SalaryMapper {
	void insertSalary(Salary salary);
	void deleteSalaryByEno(String eno);
	List<Salary> selectSalaryByEno(String eno);
	List<Salary> selectSalaryByDate(String date);
}
