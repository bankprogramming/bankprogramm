/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.models;

import java.time.Period;

import de.bankprogramming.models.enums.ProductType;

public class Loan extends Product {

	private double amount;
	private double interestRate;
	private Period duration;

	public Loan(ProductType type, long customerID, double amount, double interestRate, Period duration) {
		super(type, customerID);
		this.amount = amount;
		this.interestRate = interestRate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Period getDuration() {
		return duration;
	}

	public void setDuration(Period duration) {
		this.duration = duration;
	}
}