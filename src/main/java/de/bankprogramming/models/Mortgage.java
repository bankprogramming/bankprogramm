/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.models;

import java.time.Period;

import de.bankprogramming.models.enums.ProductType;

public class Mortgage extends Loan {

	private double loanToValueLimit;
	private double fee;
	private double repaymentPenalty;
	private String insurance;

	public Mortgage(ProductType type, Customer owner, double amount, double interestRate, double loanToValueLimit,
			String insurance, Period duration) {
		super(type, owner, amount, interestRate, duration);
		this.loanToValueLimit = loanToValueLimit;
		this.insurance = insurance;
		fee = 35;
		repaymentPenalty = monthlyAmount() * 2;
	}

	public double monthlyAmount() {
		return (this.getAmount() * (100 + this.getInterestRate())) / this.getDuration().getMonths();
	}

	public double getLoanToValueLimit() {
		return loanToValueLimit;
	}

	public void setLoanToValueLimit(double loanToValueLimit) {
		this.loanToValueLimit = loanToValueLimit;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getRepaymentPenalty() {
		return repaymentPenalty;
	}

	public void setRepaymentPenalty(double repaymentPenalty) {
		this.repaymentPenalty = repaymentPenalty;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

}