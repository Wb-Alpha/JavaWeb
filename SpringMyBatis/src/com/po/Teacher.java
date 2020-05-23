package com.po;

public class Teacher {
	private String tno;
	private String tname;
	private String tsex;
	private String tel;
	public String getTno() {
		return tno;
	}



	public void setTno(String tno) {
		this.tno = tno;
	}



	public String getTname() {
		return tname;
	}



	public void setTname(String tname) {
		this.tname = tname;
	}



	public String getTsex() {
		return tsex;
	}



	public void setTsex(String tsex) {
		this.tsex = tsex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	public String toString() {
		return tno + " | " + tname + " | " + tsex + " | " + tel;
	}
}