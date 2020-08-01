package com.mapper;

import java.util.List;

import com.po.Employee;

public interface EmployeeMapper {
	Employee selectEmployeeBySno(String eno);
	List<Employee> selectEmployeeBySname(String ename);
	List<Employee> selectEmployee();
	void insertEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployeeByEno(String eno);
}
