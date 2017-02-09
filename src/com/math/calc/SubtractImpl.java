package com.math.calc;

import java.math.BigDecimal;

public class SubtractImpl implements Operation {

	@Override
	public String perform(String arg1, String arg2) {
		
		if (arg1 != null && arg1.trim() == "") {
			return arg2;
		}
		
		BigDecimal  bd1 = new BigDecimal(arg1); 
		BigDecimal  bd2 = new BigDecimal(arg2.substring(1));
		
		return bd1.subtract(bd2).setScale(2,BigDecimal.ROUND_HALF_DOWN).toPlainString();
	}
}