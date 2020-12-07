package com.tools;

import java.util.Date;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;

public class DateTransformer {  

	/**  
	 * 日期转换成字符串  
	 * @param date  
	 * @return str  
	 */  
	public static String DateToStr(Date date) {  
	   
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	   String str = format.format(date);  
	   return str;  
	}  

	/**  
	* 字符串转换成日期  
	* @param str  
	* @return date  
	*/  
	public static Date StrToDate(String str) {  
	   
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	   Date date = null;  
	   try {  
	    date = sdf.parse(str);  
	   } catch (ParseException e) {  
	    e.printStackTrace();  
	   }  
	   return date;  
	}  
	
	public static String toSid(String str) {
		String[] list = str.split("-");
		String pre_id ="";
		for (int i = 0; i < list.length; i++) {
			pre_id += list[i];
		}
		return pre_id;
	}

	public static void main(String[] args) {  
		Date date = new Date();  
		System.out.println("日期转字符串：" + DateTransformer.DateToStr(DateTransformer.StrToDate("2020-11-20")));  
		System.out.println("字符串转日期：" + DateTransformer.StrToDate("2020-11-20"));  
	   
	}  

}  
