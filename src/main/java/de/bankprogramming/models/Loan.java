/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.models;

import java.time.Period;

import de.bankprogramming.models.enums.ProductType;

public class Loan extends Product {

	public double amount;
	public double interestRate;
	public Period duration;

	public Loan(ProductType type, long customerID, double amount, double interestRate, Period duration) {
		super(type, customerID);
		this.amount = amount;
		this.interestRate = interestRate;
	}
}