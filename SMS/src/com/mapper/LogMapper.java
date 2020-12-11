package com.mapper;

import java.util.List;

import com.po.Log;

public interface LogMapper {
	void insertLog(Log log);
	List<Log> selectAllLog();
}
