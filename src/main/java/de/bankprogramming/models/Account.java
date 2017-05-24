/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.models;

import java.util.Date;

import de.bankprogramming.models.enums.AccountType;

public class Account {

	long accountID;
	Date startDate;
	Date endDate;
	AccountType type;

	long customerID;

	public Account(AccountType type) {
		this.type = type;
		startDate = new Date(System.currentTimeMillis());
	}
}
