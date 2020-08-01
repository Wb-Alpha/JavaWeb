package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.LevelMapper;
import com.po.Level;
import com.po.Position;
import com.service.LevelService;

@Service
@Transactional
public class LevelServiceImpl implements LevelService{
	//依赖注入
	@Autowired
	private LevelMapper levelMapper;
	
	@Override
	public List<Position> findLevelWithPosition(Integer lno) {
		// TODO Auto-generated method stub
		return levelMapper.findLevelWithPosition(lno);
	}

	@Override
	public List<Level> findAllLevel() {
		// TODO Auto-generated method stub
		return levelMapper.selectAllLevel();
	}

	@Override
	public void addLevel(Level level) {
		// TODO Auto-generated method stub
		levelMapper.insertLevel(level);
	}

	@Override
	public void updateLevel(Level level) {
		// TODO Auto-generated method stub
		levelMapper.updateLevel(level);
	}

	@Override
	public void deleteLevel(Integer[] lnoArray) {
		// TODO Auto-generated method stub
		for (int i=0; i<lnoArray.length; i++) {
			levelMapper.initPositionLevel(lnoArray[i]);
			levelMapper.deleteLevel(lnoArray[i]);
		}
	}
	
}
