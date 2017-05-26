package de.bankprogramming.models;

import de.bankprogramming.models.enums.ProductType;

public class Card extends Product {

	public Card(ProductType type, long customerID) {
		super(type, customerID);
	}

}
