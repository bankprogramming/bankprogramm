/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.models;

import de.bankprogramming.models.enums.ProductType;

public class JuniorCurrentAccount extends Account {

	public long guardian;
	public int maxAge;

	public JuniorCurrentAccount(ProductType type, long customerID, long guardian) {
		super(type, customerID);
		this.guardian = guardian;
		maxAge = 16;
	}

	// public boolean isValid() {
	// // provisorisch (needs customerList from Main)
	// final Customer customer = Main.customerList.get(customerID);
	// if (customer.getAge() < maxAge) {
	// return true;
	// } else {
	// return false;
	// }
	// }
}