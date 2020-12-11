package com.controller;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.po.Employee;
import com.po.Log;
import com.po.User;
import com.service.EmployeeService;
import com.service.LogService;
import com.tools.DateTransformer;
import com.tools.XMLUtil;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LogService logService;
	protected String date = XMLUtil.getBean();
	protected String dateId = DateTransformer.toSid(date);
	
	@RequestMapping("/employeelist")
	public String employeeList(Model model, HttpSession session) {
		List<Employee> list = employeeService.findAllEmployee();
		model.addAttribute("employeeList", list);
		return "employee/employeelist";
	}
	
	@RequestMapping(value="/employeepreinsert",method=RequestMethod.GET)
	public String employeePreinsert() {
		return "employee/employeeadd";
	}
	
	@RequestMapping(value="/employeeinsert", method=RequestMethod.POST)
	public String employeeInsert(Employee employee, String identify, String password){
		employee.setEmer_sal(0);
		employee.setEsubsidy(0);
		employeeService.addEmployee(employee, identify, password);
		
		return "redirect:employeelist";
	}
	
	@RequestMapping(value="/employeedelete", method=RequestMethod.POST)
	public String employeeDelete(String[] enoArray) {
		if (enoArray != null) {
			employeeService.deleteEmployee(enoArray);	
		}
		return "redirect:employeelist";
	}
	
	@RequestMapping(value="/employeepreupdate", method=RequestMethod.GET)
	public String employeePreupdate(Employee employee, Model model) {
		model.addAttribute("employee", employee);
		return "employee/employeeupdate";
	}
	
	@RequestMapping(value="/employeeupdate", method=RequestMethod.POST)
	public String employeeUpdate(Employee employee,String identify) {
		employeeService.updateEmployee(employee, identify);
		return "redirect:employeelist";
	}
	
	@RequestMapping(value="/employeepresearch", method=RequestMethod.GET)
	public String employeePresearch(Employee employee, Model model) {
		model.addAttribute("employee", employee);
		return "employee/employeesearch";
	}
	
	@RequestMapping(value="/employeesearch", method=RequestMethod.POST)
	public String employeeSearch(Employee employee,String identify) {
		employeeService.updateEmployee(employee, identify);
		return "redirect:employeelist";
	}
	
	@RequestMapping("/exportEmployeeToExcal")
	public void exportToExcal(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		List<Employee> list= employeeService.findAllEmployee();
		response.setContentType("application/octet-stream;charset=utf-8");

		HSSFWorkbook wbook = employeeService.exportToExcal(list);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNowStr = sdf.format(d);
		response.setHeader("Content-Disposition","attachment;filename="+new String((dateNowStr+"员工信息报表").getBytes(),"iso-8859-1")+".xls");
		OutputStream outputStream=response.getOutputStream();
		wbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}
}