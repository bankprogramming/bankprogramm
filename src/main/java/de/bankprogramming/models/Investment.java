/**
* @ Author: Rick
* @ Creation Date: May 25, 2017
*/
package de.bankprogramming.models;

import java.util.List;

import de.bankprogramming.models.enums.ProductType;
import de.bankprogramming.models.enums.Strategy;

public class Investment extends Product {

	private List<String> portfolio;
	private Strategy strategy;

	public Investment(ProductType type, long customerID, List<String> portfolio, Strategy strategy) {
		super(type, customerID);
		this.portfolio = portfolio;
		this.strategy = strategy;
	}

	public List<String> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(List<String> portfolio) {
		this.portfolio = portfolio;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
}
