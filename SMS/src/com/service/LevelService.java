package com.service;

import java.util.List;
import com.po.Level;
import com.po.Position;

public interface LevelService {
	List<Position> findLevelWithPosition(Integer lno);
	List<Level> findAllLevel();
	void addLevel(Level level);
	void updateLevel(Level level);
	void deleteLevel(Integer[] lnoArray);
}
