/**
* @ Author: Rick
* @ Creation Date: May 27, 2017
*/
package de.bankprogramming.manager;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import de.bankprogramming.helper.ProductHelper;
import de.bankprogramming.logging.Logger;
import de.bankprogramming.models.Account;
import de.bankprogramming.models.Card;
import de.bankprogramming.models.Credit;
import de.bankprogramming.models.Customer;
import de.bankprogramming.models.Investment;
import de.bankprogramming.models.JuniorCurrentAccount;
import de.bankprogramming.models.Loan;
import de.bankprogramming.models.Mortgage;
import de.bankprogramming.models.PensionPlan;
import de.bankprogramming.models.Product;
import de.bankprogramming.models.Transaction;
import de.bankprogramming.models.enums.KindOfPayback;
import de.bankprogramming.models.enums.ProductType;
import de.bankprogramming.models.enums.Strategy;

public class ProductManager {

	private ProductHelper ph;

	public ProductManager() throws FileNotFoundException {
		ph = ProductHelper.getInstance();
	}

	public void openAccount(Customer customer, final ProductType type, final Double balance, final Double limit,
			final Double interestRate, Customer guardian) throws IllegalArgumentException {
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

			if (type == ProductType.JuniorCurrentAccount) {
				if (guardian == null) {
					throw new IllegalArgumentException("A JuniorCUrrentAccount needs a Guardian: openAccount");
				}
				if (guardian.getAge() < 18) {
					throw new IllegalArgumentException(
							"The Guardian needs to be a legal guardian and therefore older than 18: openAcount");
				}
				if (!(customer.getAge() < 16)) {
					throw new IllegalArgumentException(
							"The customer must be younger than 16 to setup a JuniorCurrentAccount: openAccount");
				}

				acc = new JuniorCurrentAccount(type, customer, guardian);
				guardian.getProducts().add(acc);
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

	public void createCard(ProductType type, Customer owner, Double yearlyFee, String cardStyle, Integer limit,
			boolean international, boolean locked, Long accountID)
			throws IllegalArgumentException, NullPointerException {
		// region check arguments
		if (type == null) {
			throw new NullPointerException("type is null: createCard");
		}
		if (owner == null) {
			throw new NullPointerException("owner is null: createCard");
		}
		if (yearlyFee == null) {
			throw new NullPointerException("yearlyFee is null: createCard");
		}
		if (cardStyle == null) {
			throw new NullPointerException("cardStyle is null: createCard");
		}
		if (limit == null) {
			throw new NullPointerException("limit is null: createCard");
		}
		if (accountID == null) {
			throw new NullPointerException("accountID is null: createCard");
		}

		if (!(type == ProductType.CashCard || type == ProductType.CreditCard || type == ProductType.ChequeCard)) {
			throw new IllegalArgumentException("The type is invalid: createCard");
		}

		// endregion

		Card card = new Card(type, owner, yearlyFee, cardStyle, limit, international, locked, accountID);
		owner.getProducts().add(card);
		ph.addProduct(card);

	}

	public double showBalance(Account account) {

		return account.getBalance();
	}

	public double showAllBalance(Customer customer) {
		double allBalance = 0.0;
		if (customer.getAccounts() != null) {
			for (Account a : customer.getAccounts()) {
				allBalance = allBalance + a.getBalance();
			}
		}

		return allBalance;
	}

	public void addAmountTOBalance(Account account, double amount) {
		account.setBalance(account.getBalance() + amount);

	}

	public void setInterestRate(Account account, double rate) {
		account.setInterestRate(rate);
	}

	public void setCreditLimit(Account account, double limit) {
		account.setLimit(limit);
	}

	public ArrayList<Product> getProductList() {
		return ph.getAllProducts();
	}

	public String getExternOffers() {
		return "Alte Leipziger AG; Sparkassen Verbund; ComiBank; BankCommi; Deutsche Bank der Renter; Vorschlag 6; KassenSpar; Östliche Bank des Westen;Bayer AG, BVB";

	}

	// region proccessOFThings TODO CHECK CODE
	public void processMortgageOrder(ProductType type, Customer owner, Double amount, Double interestRate,
			Double loanToValueLimit, String insurance, Period duration) {
		Mortgage m = new Mortgage(type, owner, amount, interestRate, loanToValueLimit, insurance, duration);
		ph.addProduct(m);
		owner.getProducts().add(m);

	}

	public void startInvestment(ProductType type, Customer owner, List<String> portfolio, Strategy strategy) {

		Investment i = new Investment(type, owner, portfolio, strategy);
		ph.addProduct(i);
		owner.getProducts().add(i);
	}

	public void getLoan(ProductType type, Customer owner, double amount, double interestRate, Period duration) {

		Loan l = new Loan(type, owner, amount, interestRate, duration);
		ph.addProduct(l);
		owner.getProducts().add(l);
	}

	public void startPensionPlan(ProductType type, Customer owner, List<String> portfolio, Strategy strategy,
			double monthlyInput) {
		PensionPlan pp = new PensionPlan(type, owner, portfolio, strategy, monthlyInput);
		ph.addProduct(pp);
		owner.getProducts().add(pp);
	}

	public void takeCredit(ProductType type, Customer owner, KindOfPayback kop, double amount, double interestRate,
			Period duration) {
		Credit c = new Credit(type, owner, kop, amount, interestRate, duration);
		ph.addProduct(c);
		owner.getProducts().add(c);
	}
	// endregion

	public void deposit(double amount, Account account) {

		this.addAmountTOBalance(account, amount);
		Logger.logToFile(
				"The Amount of " + amount + " has been deposit to the Account: " + account.getProductID() + ".");
	}

	public void withdraw(double amount, Account account) {

		this.addAmountTOBalance(account, amount);
		Logger.logToFile(
				"The Amount of " + amount + " has been withdrawn from the Account: " + account.getProductID() + ".");
	}

	public void createTransaction(double amount, long targetCustomerID, long targetAccount, long sourceCustomerID,
			long sourceAccount, LocalDate triggerDate) {
		Transaction t = new Transaction(amount, targetCustomerID, targetAccount, sourceCustomerID, sourceAccount,
				triggerDate);
		executeTransaction(t);
	}

	public void executeTransaction(Transaction t) {
		Account sA = (Account) ph.getProduct(t.getSourceAccount());
		Account tA = (Account) ph.getProduct(t.getTargetAccount());

		this.addAmountTOBalance(sA, t.getAmount());
		this.addAmountTOBalance(tA, -t.getAmount());

		Logger.logToFile("The amount of: " + t.getAmount() + " at the Time: " + t.getTimestamp()
				+ " from the source Account: " + t.getSourceAccount() + " by the Customer: " + t.getSourceID()
				+ " to the Account: " + t.getTargetAccount() + "by the Customer: " + t.getTargetID() + "triggerd at: "
				+ t.getTriggerDate());
	}

}
