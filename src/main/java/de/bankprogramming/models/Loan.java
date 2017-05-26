package de.bankprogramming.models;

import de.bankprogramming.models.enums.ProductType;

public class Loan extends Product {

	public Loan(ProductType type, long customerID) {
		super(type, customerID);
	}

}
