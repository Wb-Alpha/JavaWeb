package com.service;

import com.tools.Axe;

public class Person {
	private Axe axe;
	public void setAxe(Axe axe) {
		this.axe = axe;
	}	
	public void useAxe() {
		if (axe == null) {
			System.out.println("��ͷ�����ڣ�");
			return;
		}
		axe.chop();
	}
	
	public void chop() {
		System.out.println("Person chop the tree");
	}
}
