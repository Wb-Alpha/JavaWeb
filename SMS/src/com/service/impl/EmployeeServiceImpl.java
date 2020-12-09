package com.service.impl;
import java.util.List;
import java.util.Random;
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
	public void addEmployee(Employee employee, String identify) {
		// 初始化User类
		User user = new User();
		user.setId(employee.getEno());
		user.setUsername(employee.getEname());
		user.setPassword(RandomPassword.getRandom(10, RandomPassword.TYPE.LETTER_NUMBER));
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
		
		user.setUsername(employee.getEname());
		
		System.out.println(employee.toString());
		if (emp.getEbase_sal() != null && emp.getEsubsidy() != null) {
			employee.setEmer_sal(emp.getEmer_sal());
			employee.setEsubsidy(emp.getEsubsidy());
		}
		employee.setEsal(employee.getEbase_sal()+
				employee.getEmer_sal()+employee.getEsubsidy());

		
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

}
