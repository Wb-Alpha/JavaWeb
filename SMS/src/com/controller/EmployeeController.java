package com.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.po.Employee;
import com.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employeelist")
	public String employeeList(Model model) {
		List<Employee> list = employeeService.findAllEmployee();
		model.addAttribute("employeeList", list);
		return "employee/employeelist";
	}
	
	@RequestMapping(value="/employeepreinsert",method=RequestMethod.GET)
	public String employeePreinsert() {
		return "employee/employeeadd";
	}
	
	@RequestMapping(value="/employeeinsert", method=RequestMethod.POST)
	public String employeeInsert(Employee employee, String identify){
		employeeService.addEmployee(employee, identify);
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
}