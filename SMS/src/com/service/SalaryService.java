package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.po.Salary;

public interface SalaryService {
	List<Salary> findSalaryByEno(String eno);
	List<Salary> findSalaryByDate(String date);
	List<Salary> findAllSalary();
	Salary findSalaryByEnoAndDate(String id);
	void deleteSalaryByEno(String eno);
	void addSalary(Salary salary);
	HSSFWorkbook exportToExcal(List<Salary> list);
}
