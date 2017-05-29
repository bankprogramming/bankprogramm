/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.models;

import de.bankprogramming.models.enums.ProductType;

public class Account extends Product {

	private double balance;
	private double limit;
	private double interestRate;

	private boolean locked;

	/**
	 *
	 * @param type
	 */
	public Account(final ProductType type, final Customer owner) {
		super(type, owner);
		balance = 0.0;
		locked = false;
		limit = 500;
		interestRate = 1.25;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}