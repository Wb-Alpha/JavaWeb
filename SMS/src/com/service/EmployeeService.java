package com.service;

import java.util.List;

import com.po.Employee;

public interface EmployeeService {
	List<Employee> findAllEmployee();
	List<Employee> findEmployeeByName(String ename);
	Employee findEmployeeByEno(String eno);
	void addEmployee(Employee employee);
	void deleteEmployee(String[] enoArray);
	void updateEmployee(Employee employee);
}
