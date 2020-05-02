package com.po;

public class Course {
	private int cno;
	private String cn;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	
	@Override
	public String toString() {
		return "Course [cno=" + cno + ", cn=" + cn + "]";
	}
	
}
