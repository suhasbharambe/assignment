package com.math.calc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
	String answer;
	List operator;
	boolean negativeFlag;

	Calculator() {
		init();
	}

	//Initialize list of supported operators and the order.
	private void init() {
		operator = new ArrayList();
		operator.add("/");
		operator.add("*");
		operator.add("+");
		operator.add("-");
	}
	
	public void calculate(String equation) throws Exception {
		solveEquation(equation, 0);
	}

	private void solveEquation(String equation, int symIndex) throws Exception {
		int i = -1;
		do {
			i = equation.lastIndexOf((String) operator.get(symIndex));
			if (i == -1) {
				++symIndex;
			}
		} while (i == -1 && symIndex < operator.size());
		if (i == -1) {
			answer = negativeFlag?"-".concat(equation): equation;
			return;
		}

		String op1 = getOperand1(i, equation);
		String op2 = getOperand2(i, equation);
		
		String result = performOperation(op1, op2,
				(String) operator.get(symIndex));
		equation = updateEquation(equation, op1, op2,
				(String) operator.get(symIndex), result, i);
		System.out.println("Equation:" + equation);
		solveEquation(equation, symIndex);
	}

	private String updateEquation(String equation, String op1, String op2,
			String symbol, String result, int index) {
		    
		    //if first character in equation is symbol (+/-) then remove symbol
			if (index == 0) {
				negativeFlag = handleFirstSymbolCase(equation,op2);
				return  equation.replace(op1 + op2, result.substring(1));
			} else {
				return equation.replace(op1 + op2, result);
			}
	}
    
	private boolean handleFirstSymbolCase(String equation, String op2) {
		try {
			return new BigDecimal(op2).signum() == -1 ? true:false;
		}catch(NumberFormatException nfe) {
			return false;
		}
    }
    
	private String performOperation(String op1, String op2, String symbol)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		Operation impl = OperationFactory.getOperation(symbol);
		String ret = impl.perform(op1, op2);
		return ret;
	}

	private String getOperand1(int index, String equation) {
		String op1 = "";
		for (int i = index - 1; i >= 0; i--) {
			if (Character.isDigit(equation.charAt(i))
					|| equation.charAt(i) == '.') {
				op1 = equation.charAt(i) + op1;
			} else {
				op1 = equation.charAt(i) + op1;
				break;
			}
		}
		return op1;
	}

	private String getOperand2(int index, String equation) {
		String op2 = ""+equation.charAt(index);
		for (int i = index + 1; i < equation.length(); i++) {
			if (Character.isDigit(equation.charAt(i))
					|| equation.charAt(i) == '.') {
				op2 = op2 + equation.charAt(i);
			} else {
				break;
			}
		}
		return op2;
	}
	
	public String getAnswer() {
		return answer;
	}
}