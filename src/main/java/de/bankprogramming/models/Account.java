/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.models;

import de.bankprogramming.models.enums.ProductType;

public class Account extends Product {

	public double balance;
	public double limit;
	public double interestRate;

	public boolean locked;

	/**
	 *
	 * @param type
	 */
	public Account(final ProductType type, final long customerID) {
		super(type, customerID);
		balance = 0.0;
		locked = false;
		limit = 500;
		interestRate = 1.25;
	}
}