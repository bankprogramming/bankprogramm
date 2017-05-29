/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.models;

import java.time.Period;

import de.bankprogramming.models.enums.KindOfPayback;
import de.bankprogramming.models.enums.ProductType;

public class Credit extends Loan {

	private KindOfPayback kop;

	// falls nicht validiert, nicht auflisten im GUI, kann nur bei validierten
	// erstellt werden
	public Credit(ProductType type, long customerID, KindOfPayback kop, double amount, double interestRate,
			Period duration) {
		super(type, customerID, amount, interestRate, duration);
		this.kop = kop;
	}

	public KindOfPayback getKop() {
		return kop;
	}

	public void setKop(KindOfPayback kop) {
		this.kop = kop;
	}
}