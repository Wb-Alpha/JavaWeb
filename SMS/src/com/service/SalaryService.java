package com.service;

import java.util.List;

import com.po.Salary;

public interface SalaryService {
	List<Salary> findSalaryByEno(String eno);
	List<Salary> findSalaryByDate(String date);
	void deleteSalaryByEno(String eno);
	void addSalary(Salary salary);
}
