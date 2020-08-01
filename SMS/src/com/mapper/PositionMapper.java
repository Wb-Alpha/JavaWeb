package com.mapper;

import java.util.List;
import com.po.Employee;
import com.po.Position;

public interface PositionMapper {
	Position selectPositionByPno(Integer pno);
	List<Position> selectPositionByName(String pname);
	List<Employee> findPositionWithEmployee(Integer pno);
	List<Position> selectAllPositions();
	void initEmployeePosition(Integer pno);
	void insertPosition(Position position);
	void updatePosition(Position position);
	void deletePosition(Integer pno);
}
