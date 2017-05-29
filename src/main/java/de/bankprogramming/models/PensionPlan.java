/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.models;

import java.util.List;

import de.bankprogramming.models.enums.ProductType;
import de.bankprogramming.models.enums.Strategy;

public class PensionPlan extends Investment {

	private double monthlyInput;

	public PensionPlan(ProductType type, Customer owner, List<String> portfolio, Strategy strategy,
			double monthlyInput) {
		super(type, owner, portfolio, strategy);
		this.monthlyInput = monthlyInput;
	}

	public double getMonthlyInput() {
		return monthlyInput;
	}

	public void setMonthlyInput(double monthlyInput) {
		this.monthlyInput = monthlyInput;
	}

}