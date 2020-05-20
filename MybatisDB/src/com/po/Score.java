package com.po;

public class Score {
	private String sno;
	private int cno;
	private int tno;
	private float participation;
	private float sfinal;
	private float total;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public float getParticipation() {
		return participation;
	}

	public void setParticipation(float participation) {
		this.participation = participation;
	}

	public float getSfinal() {
		return sfinal;
	}

	public void setSfinal(float sfinal) {
		this.sfinal = sfinal;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String toString() {
		return sno + " | " + cno + " | " + tno + " | " + participation + " | " + sfinal + " | " + total;
	}
}