package com.service;

import com.tools.Axe;

public class Person {
	private Axe axe;
	public void setAxe(Axe axe) {
		this.axe = axe;
	}
	
	public void useAxe() {
		if (axe == null) {
			System.out.println("¸«Í·²»´æÔÚ");
			return;
		}
		axe.chop();
	}
}
