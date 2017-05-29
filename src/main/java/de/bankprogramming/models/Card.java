/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.models;

import de.bankprogramming.models.enums.ProductType;

public class Card extends Product {

	private double yearlyFee;
	private String cardStyle;

	// TODO Verknüpfung mit accountlimit
	private int limit;
	private boolean international;
	private boolean locked;

	private long accountID;

	public Card(ProductType type, long customerID, double yearlyFee, String cardStyle, int limit, boolean international,
			boolean locked, long accountID) {
		super(type, customerID);
		this.yearlyFee = yearlyFee;
		this.cardStyle = cardStyle;
		this.limit = limit;
		this.international = international;
		this.locked = locked;
		this.setAccountID(accountID);
	}

	public double getYearlyFee() {
		return yearlyFee;
	}

	public void setYearlyFee(double yearlyFee) {
		this.yearlyFee = yearlyFee;
	}

	public String getCardStyle() {
		return cardStyle;
	}

	public void setCardStyle(String cardStyle) {
		this.cardStyle = cardStyle;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public boolean isInternational() {
		return international;
	}

	public void setInternational(boolean international) {
		this.international = international;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public long getAccountID() {
		return accountID;
	}

	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
}