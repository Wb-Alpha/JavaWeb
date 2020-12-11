package com.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	public String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());
	}
}
