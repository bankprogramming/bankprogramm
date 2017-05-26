/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.models;

import java.time.Period;

import de.bankprogramming.models.enums.ProductType;

public class Mortgage extends Loan {

	public double loanToValueLimit;
	public double fee;
	public double repaymentPenalty;
	public String insurance;

	public Mortgage(ProductType type, long customerID, double amount, double interestRate, double loanToValueLimit,
			String insurance, Period duration) {
		super(type, customerID, amount, interestRate, duration);
		this.loanToValueLimit = loanToValueLimit;
		this.insurance = insurance;
		fee = 35;
		repaymentPenalty = monthlyAmount() * 2;

	}

	public double monthlyAmount() {
		return (amount * (100 + interestRate)) / duration.getMonths();
	}
}