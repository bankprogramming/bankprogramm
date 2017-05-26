/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.models;

import java.time.LocalDate;

public class Transaction {

	public double amount;

	// vom Ziel Account die CustomerID
	public long targetID;
	public long targetAccount;
	// vom source Account die CustomerID
	public long sourceID;
	public long sourceAccount;

	public LocalDate timestamp;
	public LocalDate triggerDate;

	public Transaction(double amount, long targetID, long targetAccount, long sourceID, long sourceAccount,
			LocalDate triggerDate) {
		timestamp = LocalDate.now();
		this.triggerDate = triggerDate;
		this.amount = amount;
		this.targetID = targetID;
		this.targetAccount = targetAccount;
		this.sourceID = sourceID;
		this.sourceAccount = sourceAccount;
	}
}
