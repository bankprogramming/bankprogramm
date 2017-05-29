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

	public void openAccount(Customer customer, final ProductType type, final Double balance, final Double limit,
			final Double interestRate, Customer guardian) {
		Account acc;
		if (type == ProductType.CurrentAccount || type == ProductType.JuniorCurrentAccount
				|| type == ProductType.CorporateAccount || type == ProductType.StudentAccount) {
			acc = new Account(type, customer);
			if (balance != null && balance >= 0.0) {
				acc.setBalance(balance);
			}
			if (limit != null && limit >= 0.0) {
				acc.setLimit(limit);
			}
			if (interestRate != null && interestRate >= 0.0) {
				acc.setInterestRate(interestRate);
			}
			switch (type) {
			case CurrentAccount:
				break;
			case JuniorCurrentAccount:
				acc = new Account(type, customer);

				break;
			case CorporateAccount:

				break;
			case StudentAccount:

				break;
			}
			ph.addProduct(acc);
			customer.getProducts().add(acc);
		}
	}

	public void deleteAccount(final Account acc) {
		Customer owner = acc.getOwner();
		owner.getProducts().remove(acc);
		ph.deleteProduct(acc);
	}

	public void blockCard(Card card) {
		card.setLocked(true);
	}

	public void openCard(Card card) {
		card.setLocked(false);
	}

}
