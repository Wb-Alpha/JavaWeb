package com.po;

import java.util.List;

public class Student {
	String sno;
	String sname;
	String ssex;
	String snative;
	int mno;
	private List<Course> courseList;

	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSnative() {
		return snative;
	}
	public void setSnative(String snative) {
		this.snative = snative;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}

	
	@Override
	public String toString() {
		return sno+"|"+sname+"|"+ssex+""+snative+"|"+mno;
	}
}
