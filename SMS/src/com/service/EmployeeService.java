package com.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.po.Employee;

public interface EmployeeService {
	List<Employee> findAllEmployee();
	List<Employee> findEmployeeByName(String ename);
	Employee findEmployeeByEno(String eno);
	void addEmployee(Employee employee, String identify, String password);
	void deleteEmployee(String[] enoArray);
	void updateEmployee(Employee employee, String identify);
	void selfUpdateEmployee(Employee employee);
	HSSFWorkbook exportToExcal(List<Employee> list);
}
