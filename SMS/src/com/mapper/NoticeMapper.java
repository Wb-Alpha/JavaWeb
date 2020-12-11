package com.mapper;

import com.po.Notice;

public interface NoticeMapper {
	void findAllNotice();
	void deleteNotice(String nno);
	void updateNotice(Notice notice);
	void insertNotice(Notice notice);
	
}
