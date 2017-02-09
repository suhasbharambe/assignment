package com.math.calc;

import java.math.BigDecimal;

public class AddImpl implements Operation {

	private static final Character MATH_NEGATIVE='-';
	
	@Override
	public String perform(String arg1, String arg2) {
		
		BigDecimal  bd1;
		
		if (arg1 != null && arg1.trim() == "") {
			return arg2;
		}
		 
		if (!Character.isDigit(arg1.charAt(0)) && arg1.charAt(0) != MATH_NEGATIVE) {
			bd1 = new BigDecimal(arg1.substring(1));
		}else {
			bd1 = new BigDecimal(arg1);
		}
		BigDecimal  bd2 = new BigDecimal(arg2.substring(1));
		
		BigDecimal result =bd1.add(bd2).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		
		if (isNegative(result)) {
			return result.toPlainString();
		}else {
			return "+".concat(result.toPlainString());
		}
	}
	
	public static boolean isNegative(BigDecimal b) {
	    return b.signum() == -1;
	}
}
