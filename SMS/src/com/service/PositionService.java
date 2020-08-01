package com.service;

import java.util.List;
import com.po.Employee;
import com.po.Position;

public interface PositionService {
	List<Employee> findPositionWithEmployee(Integer pno);
	List<Position> findAllPositions();
	void addPosition(Position position);
	void updatePosition(Position position);
	void deletePosition(Integer[] pnoArray);
}
