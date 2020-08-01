package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mapper.EmployeeMapper;
import com.mapper.LevelMapper;
import com.mapper.PositionMapper;
import com.po.Employee;
import com.po.Level;
import com.po.Position;
import com.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeMapper employeeMapper;
	private PositionMapper positionMapper;
	private LevelMapper levelMapper;
		
	@Override
	public Employee findEmployeeByEno(String eno) {
		// TODO Auto-generated method stub
		return employeeMapper.selectEmployeeBySno(eno);
	}
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Position position = positionMapper.selectPositionByPno(employee.getEpos());
		Level level = levelMapper.selectLevelByLno(position.getPlevel());
		employee.setEbase_sal(level.getBase_sal());
		employee.setEsal(employee.getEbase_sal()+
				employee.getEmer_sal()+employee.getEsubsidy());
		employeeMapper.insertEmployee(employee);
	}
	@Override
	public void deleteEmployee(String[] enoArray) {
		// TODO Auto-generated method stub
		for (int i = 0; i < enoArray.length; i ++){
			employeeMapper.deleteEmployeeByEno(enoArray[i]);
		}
	}
	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Position position = positionMapper.selectPositionByPno(employee.getEpos());
		Level level = levelMapper.selectLevelByLno(position.getPlevel());
		employee.setEbase_sal(level.getBase_sal());
		employee.setEsal(employee.getEbase_sal()+
				employee.getEmer_sal()+employee.getEsubsidy());
		employeeMapper.updateEmployee(employee);
	}
	
	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeeMapper.selectEmployee(); 
	}
	@Override
	public List<Employee> findEmployeeByName(String ename) {
		// TODO Auto-generated method stub
		return employeeMapper.selectEmployeeBySname(ename);
	}
}
