package com.po;

import java.util.List;

public class Level {
	private Integer lno;	//级别id
	private String lname; 	//级别名称
	private List<Position> posList;
	private int base_sal;	//级别工资
	

	public Integer getLno() {
		return lno;
	}
	public void setLno(Integer lno) {
		this.lno = lno;
	}
	public List<Position> getPosList() {
		return posList;
	}
	public void setPosList(List<Position> posList) {
		this.posList = posList;
	}

	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getBase_sal() {
		return base_sal;
	}
	public void setBase_sal(int base_sal) {
		this.base_sal = base_sal;
	}

}
