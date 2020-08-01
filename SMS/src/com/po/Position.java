package com.po;

import java.util.List;

public class Position {
	private Integer pno;
	private String pname;
	private List<Employee> empList;
	private int plevel;
	

	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpLlist(List<Employee> plist) {
		this.empList = plist;
	}
	public int getPlevel() {
		return plevel;
	}
	public void setPlevel(int plevel) {
		this.plevel = plevel;
	}
	
}
