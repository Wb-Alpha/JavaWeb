package com.po;

import java.util.Date;  

public class Salary {
	private String id;
	private String eno;
	private String date;
	private int salary;
	private int base_sal;
	private int mer_sal;
	private int sub;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getBase_sal() {
		return base_sal;
	}
	public void setBase_sal(int base_sal) {
		this.base_sal = base_sal;
	}
	public int getMer_sal() {
		return mer_sal;
	}
	public void setMer_sal(int mer_sal) {
		this.mer_sal = mer_sal;
	}
	public int getSub() {
		return sub;
	}
	public void setSub(int sub) {
		this.sub = sub;
	}
	@Override
	public String toString() {
		return "Salary [id=" + id + ", eno=" + eno + ", salary=" + salary + ", base_sal=" + base_sal + ", mer_sal="
				+ mer_sal + ", sub=" + sub + "]";
	}
	
}
