package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.po.Salary;

public interface SalaryService {
	List<Salary> findSalaryByEno(String eno);
	List<Salary> findSalaryByDate(String date);
	Salary findSalaryByEnoAndDate(String id);
	void deleteSalaryByEno(String eno);
	void addSalary(Salary salary);
}
