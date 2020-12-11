package com.service.impl;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mapper.EmployeeMapper;
import com.mapper.LevelMapper;
import com.mapper.PositionMapper;
import com.mapper.SalaryMapper;
import com.mapper.UserMapper;
import com.po.Employee;
import com.po.Level;
import com.po.Position;
import com.po.Salary;
import com.po.User;
import com.service.EmployeeService;
import com.tools.DateTransformer;
import com.tools.RandomPassword;
import com.tools.XMLUtil;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private PositionMapper positionMapper;
	@Autowired
	private LevelMapper levelMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SalaryMapper salaryMapper;
	
	@Override
	public Employee findEmployeeByEno(String eno) {
		// TODO Auto-generated method stub
		return employeeMapper.selectEmployeeByEno(eno);
	}
	
	@Override
	public void addEmployee(Employee employee, String identify, String password) {
		// 初始化User类
		User user = new User();
		user.setId(employee.getEno());
		user.setUsername(employee.getEname());
//		user.setPassword(RandomPassword.getRandom(10, RandomPassword.TYPE.LETTER_NUMBER));
		user.setPassword(password);
		user.setIdentify(identify);
		
		// 初始化Employee类
		Position position = positionMapper.selectPositionByPno(employee.getEpos());
		Level level = levelMapper.selectLevelByLno(position.getPlevel());
		employee.setEbase_sal(level.getBase_sal());
		employee.setEsal(employee.getEbase_sal()+
				employee.getEmer_sal()+employee.getEsubsidy());
			
		//初始化Salary类
		String date_str = XMLUtil.getBean();
		Salary salary = new Salary();
		salary.setId(DateTransformer.toSid(date_str)+employee.getEno());
		salary.setEno(employee.getEno());
		salary.setBase_sal(employee.getEbase_sal());
		salary.setMer_sal(0);
		salary.setSub(0);
		salary.setSalary(employee.getEbase_sal());
		salary.setDate(date_str);
		System.out.println(salary);
		
		// 插入User, Salary和Employee
		userMapper.insertUser(user);
		employeeMapper.insertEmployee(employee);
		salaryMapper.insertSalary(salary);
	}
	
	@Override
	public void deleteEmployee(String[] enoArray) {
		// TODO Auto-generated method stub
		for (int i = 0; i < enoArray.length; i ++){
			employeeMapper.deleteEmployeeByEno(enoArray[i]);
			userMapper.deleteUserById(enoArray[i]);
			salaryMapper.deleteSalaryByEno(enoArray[i]);
		}
	}
	
	@Override
	public void updateEmployee(Employee emp,String identify) {
		String last_month = DateTransformer.toSid(DateTransformer.lastMonth(XMLUtil.getBean()));
		String now_month = DateTransformer.toSid(XMLUtil.getBean());
		Employee employee = employeeMapper.selectEmployeeByEno(emp.getEno());
		employee.setEpos(emp.getEpos());
		Position position = positionMapper.selectPositionByPno(employee.getEpos());
		Level level = levelMapper.selectLevelByLno(position.getPlevel());
		User user = userMapper.selectUserById(employee.getEno());
		Salary last_salary = salaryMapper.selectSalaryByEnoAndDate(last_month+employee.getEno());
		Salary now_salary = salaryMapper.selectSalaryByEnoAndDate(now_month+employee.getEno());
		System.out.println(employee.toString());
		user.setUsername(employee.getEname());
		
//		System.out.println(emp.toString());
//		System.out.println(emp.getEmer_sal() != null && emp.getEsubsidy() != null);

		if (emp.getEmer_sal() != null && emp.getEsubsidy() != null) {
			employee.setEmer_sal(emp.getEmer_sal());
			employee.setEsubsidy(emp.getEsubsidy());
		}
		employee.setEsal(employee.getEbase_sal()+employee.getEmer_sal()+employee.getEsubsidy());
//		System.out.println(employee.toString());
//		System.out.println(last_salary == null);
		
		// 更新上个月数据
		last_salary.setMer_sal(employee.getEmer_sal());
		last_salary.setSub(employee.getEsubsidy());
		last_salary.setSalary(last_salary.getBase_sal()+last_salary.getMer_sal()+last_salary.getSub());
		

		// 更新本月数据
		now_salary.setBase_sal(level.getBase_sal());
		now_salary.setSalary(now_salary.getBase_sal());
		
//		System.out.println("EmpService  "+employee.toString());
		userMapper.updateUser(user);
		employeeMapper.updateEmployee(employee);
		salaryMapper.updateSalary(last_salary);
		salaryMapper.updateSalary(now_salary);
	}
	
	
	
	@Override
	public void selfUpdateEmployee(Employee employee) {
		employeeMapper.updateEmployee(employee);	
	}	
	
	@Override
	public List<Employee> findAllEmployee() {
		return employeeMapper.selectEmployee(); 
	}
	
	@Override
	public List<Employee> findEmployeeByName(String ename) {
		return employeeMapper.selectEmployeeBySname(ename);
	}

	@Override
	public HSSFWorkbook exportToExcal(List<Employee> list) {
		//创建excel文件
		HSSFWorkbook wbook=new HSSFWorkbook();
		//创建sheet页
		HSSFSheet sheet=wbook.createSheet("工资流水报表");
		//创建标题行
		HSSFRow titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("员工号");
		titleRow.createCell(1).setCellValue("员工姓名");
		titleRow.createCell(2).setCellValue("职位");
		titleRow.createCell(3).setCellValue("总工资");
		titleRow.createCell(4).setCellValue("基本工资");
		titleRow.createCell(5).setCellValue("绩效");
		titleRow.createCell(6).setCellValue("津贴");		

		//将数据放入excel
		for (Employee employee:list) {
		   HSSFRow dataRow=sheet.createRow(sheet.getLastRowNum()+1);
		   dataRow.createCell(0).setCellValue(employee.getEno());
		   dataRow.createCell(1).setCellValue(employee.getEname());
		   dataRow.createCell(2).setCellValue(employee.getEpos());
		   dataRow.createCell(3).setCellValue(employee.getEsal());
		   dataRow.createCell(4).setCellValue(employee.getEbase_sal());
		   dataRow.createCell(5).setCellValue(employee.getEmer_sal());
		   dataRow.createCell(6).setCellValue(employee.getEsubsidy());
		}
		return wbook;
	}
}
