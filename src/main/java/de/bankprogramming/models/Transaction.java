/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.models;

import java.time.LocalDate;

public class Transaction {

	private double amount;

	// vom Ziel Account die CustomerID
	private long targetID;
	private long targetAccount;
	// vom source Account die CustomerID
	private long sourceID;
	private long sourceAccount;

	private LocalDate timestamp;
	private LocalDate triggerDate;

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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTargetID() {
		return targetID;
	}

	public void setTargetID(long targetID) {
		this.targetID = targetID;
	}

	public long getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(long targetAccount) {
		this.targetAccount = targetAccount;
	}

	public long getSourceID() {
		return sourceID;
	}

	public void setSourceID(long sourceID) {
		this.sourceID = sourceID;
	}

	public long getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(long sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public LocalDate getTriggerDate() {
		return triggerDate;
	}

	public void setTriggerDate(LocalDate triggerDate) {
		this.triggerDate = triggerDate;
	}

}
