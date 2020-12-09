package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.SalaryMapper;
import com.po.Salary;
import com.service.SalaryService;

@Service
@Transactional
public class SalaryServiceImpl implements SalaryService{
	@Autowired
	private SalaryMapper salaryMapper;
	
	@Override
	public List<Salary> findSalaryByEno(String eno) {
		return salaryMapper.selectSalaryByEno(eno);
	}

	@Override
	public void deleteSalaryByEno(String eno) {
		salaryMapper.deleteSalaryByEno(eno);
	}

	@Override
	public void addSalary(Salary salary) {
		salaryMapper.insertSalary(salary);
	}
			
	@Override
	public List<Salary> findSalaryByDate(String date) {
		// TODO Auto-generated method stub
		return salaryMapper.selectSalaryByDate(date);
	}

	@Override
	public Salary findSalaryByEnoAndDate(String sid) {
		return salaryMapper.selectSalaryByEnoAndDate(sid);
	}
}
