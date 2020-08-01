package com.mapper;

import java.util.List;
import com.po.Level;
import com.po.Position;

public interface LevelMapper {
	Level selectLevelByLno(Integer lno);
	List<Level> selectLevelByLname(String lname);
	List<Level> selectAllLevel();
	List<Position> findLevelWithPosition(Integer lno);
	void initPositionLevel(Integer lno);
	void insertLevel(Level level);
	void updateLevel(Level level);
	void deleteLevel(Integer lno);
}
