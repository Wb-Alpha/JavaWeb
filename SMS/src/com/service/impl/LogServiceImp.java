package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mapper.LogMapper;
import com.po.Log;
import com.service.LogService;

@Service
@Transactional
public class LogServiceImp implements LogService {
	@Autowired
	private LogMapper logMapper;
	
	@Override
	public void addLog(String id, String creater, String date, String content) {
		Log log = new Log();
		log.setLogId(id);
		log.setLogCreater(creater);
		log.setLogDate(date);
		log.setLogCreater(content);
		logMapper.insertLog(log);
	}

	@Override
	public List<Log> findAllLog() {
		// TODO Auto-generated method stub
		return logMapper.selectAllLog();
	}
}
