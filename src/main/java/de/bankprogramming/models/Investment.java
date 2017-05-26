package de.bankprogramming.models;

import de.bankprogramming.models.enums.ProductType;

public class Investment extends Product {

	public Investment(ProductType type, long customerID) {
		super(type, customerID);
	}

}
