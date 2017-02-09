package com.math.calc;

public class OperationFactory {

	public static Operation getOperation(String symbol) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String implClass = "";
		if (symbol == "/") {
			implClass = "com.math.calc.DivideImpl";
		} else if (symbol == "*") {
			implClass = "com.math.calc.MultiplyImpl";
		} else if (symbol == "+") {
			implClass = "com.math.calc.AddImpl";
		} else if (symbol == "-") {
			implClass = "com.math.calc.SubtractImpl";
		}

		Class<Operation> cls = (Class<Operation>) Class.forName(implClass);
		Operation impl = cls.newInstance();
		
		return impl;
	}
}
