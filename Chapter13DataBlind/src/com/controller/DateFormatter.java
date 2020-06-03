package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

/*
 * 使用Formatter自定义日期转化器
 */
public class DateFormatter implements Formatter<Date>{
	//定义日期格式
	String datePattern = "yyyy-MM-dd HH:mm:ss";
	//圣灵SimpleDateFromat对象
	private SimpleDateFormat simpleDateFormat;
	
	@Override
	public String print(Date date, Locale locale) {
		return new SimpleDateFormat().format(date);
	}

	@Override
	public Date parse(String source, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		simpleDateFormat = new SimpleDateFormat(datePattern);
		return simpleDateFormat.parse(source);
	}
}
