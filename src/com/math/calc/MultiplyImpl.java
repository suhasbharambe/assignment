package com.math.calc;

import java.math.BigDecimal;

public class MultiplyImpl implements Operation {

	private static final Character MATH_NEGATIVE = '-';

	@Override
	public String perform(String arg1, String arg2) {

		BigDecimal bd1;

		if (!Character.isDigit(arg1.charAt(0))
				&& arg1.charAt(0) != MATH_NEGATIVE) {
			bd1 = new BigDecimal(arg1.substring(1));
		} else {
			bd1 = new BigDecimal(arg1);
		}
		BigDecimal bd2 = new BigDecimal(arg2.substring(1));

		BigDecimal result = bd1.multiply(bd2).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		if (arg1.charAt(0) == MATH_NEGATIVE) {
			return result.toPlainString();
		} else {
			return "+".concat(result.toPlainString());
		}
	}
}
