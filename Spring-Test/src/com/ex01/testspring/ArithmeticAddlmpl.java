package com.ex01.testspring;

public class ArithmeticAddlmpl implements Arithmetic{
	@Override
	public double calc(double num1, double num2) {
		double sum = num1 + num2;
		return sum;
	}

	
}
