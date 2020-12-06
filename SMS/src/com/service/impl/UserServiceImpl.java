package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.EmployeeMapper;
import com.mapper.LevelMapper;
import com.mapper.PositionMapper;
import com.mapper.UserMapper;
import com.po.Employee;
import com.po.Level;
import com.po.Position;
import com.po.User;
import com.service.UserService;
import com.tools.RandomPassword;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private PositionMapper positionMapper;
	@Autowired
	private LevelMapper levelMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserById(String id) {
		return userMapper.selectUserById(id);
	} 

	@Override
	public void insertUser(User user, int epos, int emer_sal, int esubsidy) {
		// 初始化Employee类
		Employee employee = new Employee();
		employee.setEno(user.getId());
		employee.setEname(user.getUsername());
		employee.setEmer_sal(emer_sal);
		employee.setEsubsidy(esubsidy);
		employee.setEpos(epos);
		Position position = positionMapper.selectPositionByPno(employee.getEpos());
		Level level = levelMapper.selectLevelByLno(position.getPlevel());
		employee.setEbase_sal(level.getBase_sal());
		employee.setEsal(employee.getEbase_sal()+
				employee.getEmer_sal()+employee.getEsubsidy());
		
		user.setPassword(RandomPassword.getRandom(10, RandomPassword.TYPE.LETTER_NUMBER));
		
		userMapper.insertUser(user);
		employeeMapper.insertEmployee(employee);
	}

	@Override
	public void deleteUser(String[] unoArray) {
		for (int i = 0; i < unoArray.length; i ++){
			userMapper.deleteUserById(unoArray[i]);
			employeeMapper.deleteEmployeeByEno(unoArray[i]);
		}
	}

	@Override
	public List<User> findAllUser() {
		return userMapper.selectAllUsers();
	}

	@Override
	public List<User> findUserByName(String name) {
		return userMapper.selectUserByName(name);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}
	
}
