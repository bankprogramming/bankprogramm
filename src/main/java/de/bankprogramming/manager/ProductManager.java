/**
* @ Author: Rick
* @ Creation Date: May 27, 2017
*/
package de.bankprogramming.manager;

import de.bankprogramming.helper.ProductHelper;
import de.bankprogramming.models.Account;
import de.bankprogramming.models.Card;
import de.bankprogramming.models.Customer;
import de.bankprogramming.models.enums.ProductType;

public class ProductManager {

	private ProductHelper ph;

	public ProductManager() {
		ph = ProductHelper.getInstance();
	}

	public void openAccount(final Customer customer, final ProductType type, final double balance, final double limit,
			final double interestRate) {
		switch (type) {
		case CurrentAccount:
			Account currAcc = new Account(type, customer);

			ph.addProduct(currAcc);
			customer.getProducts().add(currAcc);
			break;
		case JuniorCurrentAccount:

			break;
		case CorporateAccount:

			break;
		case StudentAccount:

			break;
		default:
			// TODO invalid account type
		}
	}

	public void deleteAccount(final Account acc) {

	}

	public void blockCard(Card card) {
		card.setLocked(true);
	}

	public void openCard(Card card) {
		card.setLocked(false);
	}

}
