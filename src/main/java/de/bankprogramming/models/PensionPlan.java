/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.models;

import java.util.List;

import de.bankprogramming.models.enums.ProductType;
import de.bankprogramming.models.enums.Strategy;

public class PensionPlan extends Investment {

	public double monthlyInput;

	public PensionPlan(ProductType type, long customerID, List<String> portfolio, Strategy strategy,
			double monthlyInput) {
		super(type, customerID, portfolio, strategy);
		this.monthlyInput = monthlyInput;
	}
}