package com.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.po.Salary;
import com.service.SalaryService;
import com.tools.TestTools;

@Controller
public class SalaryController {
	@Autowired
	private SalaryService salaryService;
	
	@RequestMapping("/salaryrecord")
	public String salaryRecord(Model model) {
		List<Salary> salarylist = salaryService.findAllSalary();
		model.addAttribute("salarylist",salarylist);
		return "salary/salary_record";
	}
	
	@RequestMapping("/exportToExcal")
	public void exportToExcal(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		List<Salary> list=	salaryService.findAllSalary();
		response.setContentType("application/octet-stream;charset=utf-8");

		HSSFWorkbook wbook = salaryService.exportToExcal(list);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNowStr = sdf.format(d);
		response.setHeader("Content-Disposition","attachment;filename="+new String((dateNowStr+"工资信息报表").getBytes(),"iso-8859-1")+".xls");
		OutputStream outputStream=response.getOutputStream();
		wbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}
}
