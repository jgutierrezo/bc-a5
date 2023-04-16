package com.juan;

import jakarta.ejb.Stateful;

/**
 * Session Bean implementation class Mortgage
 */
@Stateful
public class Mortgage implements MortgageRemote {

	/**
	 * Default constructor.
	 */
	public Mortgage() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String calculateMortgage(Double amount, Double rate, int years) {

		Double monthlyFee = 0D;
		rate = rate/(100*12);
		int months = years * 12;
		

		monthlyFee = amount * rate / (1 - Math.pow(1 + rate, -months));
		return String.format("%.2f", monthlyFee);

	}

}
