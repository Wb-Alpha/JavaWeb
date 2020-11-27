package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.PositionMapper;
import com.po.Employee;
import com.po.Position;
import com.service.PositionService;

@Service
@Transactional
public class PositionServiceImpl implements PositionService{
	//依赖注入
	@Autowired
	private PositionMapper positionMapper;
	
	@Override
	public List<Employee> findPositionWithEmployee(Integer pno) {
		// TODO Auto-generated method stub
		List<Employee> empList = positionMapper.findPositionWithEmployee(pno);
		return empList;
	}

	@Override
	public List<Position> findAllPositions() {
		// TODO Auto-generated method stub
		List<Position> posList = positionMapper.selectAllPositions();
		return posList;
	}

	@Override
	public void addPosition(Position position) {
		// TODO Auto-generated method stub
		positionMapper.insertPosition(position);
	}

	@Override
	public void updatePosition(Position position) {
		// TODO Auto-generated method stub
		positionMapper.updatePosition(position);
	}

	@Override
	public void deletePosition(Integer[] pnoArray) {
		for (int i=0; i<pnoArray.length; i++) {
			positionMapper.initEmployeePosition(pnoArray[i]);
			positionMapper.deletePosition(pnoArray[i]);
		}
	}

}
