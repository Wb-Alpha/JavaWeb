package com.service.impl;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

	@Override
	public List<Salary> findAllSalary() {
		return salaryMapper.selectAllSalary();
	}

	@Override
	public HSSFWorkbook exportToExcal(List<Salary> list) {
		//创建excel文件
		HSSFWorkbook wbook=new HSSFWorkbook();
		//创建sheet页
		HSSFSheet sheet=wbook.createSheet("工资流水报表");
		//创建标题行
		HSSFRow titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("账单号");
		titleRow.createCell(1).setCellValue("员工号");
		titleRow.createCell(2).setCellValue("日期");
		titleRow.createCell(3).setCellValue("总工资");
		titleRow.createCell(4).setCellValue("基本工资");
		titleRow.createCell(5).setCellValue("绩效");
		titleRow.createCell(6).setCellValue("津贴");		

		//将数据放入excel
		for (Salary salary:list) {
		   HSSFRow dataRow=sheet.createRow(sheet.getLastRowNum()+1);
		   dataRow.createCell(0).setCellValue(salary.getId());
		   dataRow.createCell(1).setCellValue(salary.getEno());
		   dataRow.createCell(2).setCellValue(salary.getDate());
		   dataRow.createCell(3).setCellValue(salary.getSalary());
		   dataRow.createCell(4).setCellValue(salary.getBase_sal());
		   dataRow.createCell(5).setCellValue(salary.getMer_sal());
		   dataRow.createCell(6).setCellValue(salary.getSub());
		}
		return wbook;
	}
}
