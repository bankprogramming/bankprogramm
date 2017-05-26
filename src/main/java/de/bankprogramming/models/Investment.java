/**
* @ Author: Rick
* @ Creation Date: May 25, 2017
*/
package de.bankprogramming.models;

import java.util.List;

import de.bankprogramming.models.enums.ProductType;
import de.bankprogramming.models.enums.Strategy;

public class Investment extends Product {

	public List<String> portfolio;
	public Strategy strategy;

	public Investment(ProductType type, long customerID, List<String> portfolio, Strategy strategy) {
		super(type, customerID);
		this.portfolio = portfolio;
		this.strategy = strategy;
	}
}
