package com;

import com.tools.*;
import com.service.*;

public class Test {
	public static void main(String[] args) {
		Person person = new Person();
		Axe axe = new IronAxe();
		person.setAxe(axe);
		person.useAxe();
	}
}
