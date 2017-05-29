/**
* @ Author: Rick
* @ Creation Date: May 27, 2017
*/
package de.bankprogramming.manager;

import de.bankprogramming.helper.ProductHelper;
import de.bankprogramming.models.*;
import de.bankprogramming.models.enums.ProductType;

import java.util.ArrayList;

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

			if (type == ProductType.JuniorCurrentAccount) {
				if(guardian==null){
					throw new IllegalArgumentException("A JuniorCUrrentAccount needs a Guardian: openAccount");
				}
				if(guardian.getAge()<18){
					throw new IllegalArgumentException("The Guardian needs to be a legal guardian and therefore older than 18: openAcount");
				}
				if(!(customer.getAge()<16)){
					throw new IllegalArgumentException("The customer must be younger than 16 to setup a JuniorCurrentAccount: openAccount");
				}

				acc = new JuniorCurrentAccount(type, customer,guardian);
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

	public void createCard(ProductType type, Customer owner, Double yearlyFee, String cardStyle, Integer limit, boolean international,
						   boolean locked, Long accountID){
		//region check arguments
		if(type == null){
		throw new NullPointerException("type is null: createCard");
	}
	if(owner == null){
		throw new NullPointerException("owner is null: createCard");
	}
	if(yearlyFee == null){
		throw new NullPointerException("yearlyFee is null: createCard");
	}
	if(cardStyle == null){
		throw new NullPointerException("cardStyle is null: createCard");
	}
	if(limit == null){
		throw new NullPointerException("limit is null: createCard");
	}
	if(accountID == null){
		throw new NullPointerException("accountID is null: createCard");
	}

	if(!(type == ProductType.CashCard||type == ProductType.CreditCard||type == ProductType.ChequeCard)){
		throw new IllegalArgumentException("The type is invalid: createCard");
	}

		//endregion

	Card card = new Card(type,owner,yearlyFee,cardStyle,limit,international,locked,accountID);
	owner.getProducts().add(card);
	ph.addProduct(card);

	}

	public double showBalance(Account account){

		return account.getBalance();
	}

	public double showAllBalance(Customer customer){
		double allBalance = 0.0;
		if(customer.getAccounts()!=null){
			for(Account a : customer.getAccounts()){
				allBalance = allBalance+a.getBalance();
			}
		}

		return allBalance;
	}

	public void addAmountTOBalance(Account account, double amount){
		account.setBalance(account.getBalance()+amount);

	}

	public void setInterestRate(Account account, double rate){
		account.setInterestRate(rate);
	}
	public void setCreditLimit(Account account, double limit){
		account.setLimit(limit);
	}
	public ArrayList<Product> getProductList(){
		return null;
	}
}
