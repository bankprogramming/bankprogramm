/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.models;

import java.util.Date;

import de.bankprogramming.models.enums.ProductType;

public class Account extends Product {

	/**
	 *
	 * @param type
	 */
	public Account(ProductType type, long customerID) {
		super(type, customerID);
		startDate = new Date(System.currentTimeMillis());
	}
}
