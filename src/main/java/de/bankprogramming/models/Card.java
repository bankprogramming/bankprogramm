/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.models;

import de.bankprogramming.models.enums.ProductType;

public class Card extends Product {

	public double yearlyFee;
	public String cardStyle;

	// TODO Verknüpfung mit accountlimit
	public int limit;
	public boolean international;
	public boolean locked;

	public Card(ProductType type, long customerID, double yearlyFee, String cardStyle, int limit, boolean international,
			boolean locked) {
		super(type, customerID);
		this.yearlyFee = yearlyFee;
		this.cardStyle = cardStyle;
		this.limit = limit;
		this.international = international;
		this.locked = locked;
	}
}