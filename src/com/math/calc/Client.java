package com.math.calc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {

	public static void main(String args[]) throws Exception {
		Calculator calc = new Calculator();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String equation = reader.readLine();
		calc.calculate(equation);
		System.out.println("Answer = " + calc.getAnswer());
	}
}
