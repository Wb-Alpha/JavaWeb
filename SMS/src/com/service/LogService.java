package com.service;

import java.util.List;

import com.po.Log;

public interface LogService {
	void addLog(String id, String creater, String date, String content);
	List<Log> findAllLog();
}
