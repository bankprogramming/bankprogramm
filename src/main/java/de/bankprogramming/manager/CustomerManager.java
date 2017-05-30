/**
* @ Author: Rick
* @ Creation Date: May 27, 2017
*/
package de.bankprogramming.manager;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.bankprogramming.helper.CustomerHelper;
import de.bankprogramming.models.Account;
import de.bankprogramming.models.Customer;
import de.bankprogramming.models.Product;
import de.bankprogramming.models.enums.Gender;
import de.bankprogramming.models.enums.ProductType;

@Singleton
public class CustomerManager {

	private CustomerHelper customerHelper;

	@Inject
	public CustomerManager() throws FileNotFoundException {
		customerHelper = CustomerHelper.getInstance();
	}

	/**
	 * @param validated
	 *            Der Bankangestellte muss angeben ob der Kunde von der Bank
	 *            validiert ist zum Kredit erhalten
	 * @param gender
	 *            Gender ist ein enum mit 4 möglichkeiten TODO check code
	 */
	public Customer addNewCustomer(String name, String address, String telNumber, LocalDate dateofBirth,
			boolean validated, Gender gender) throws IllegalArgumentException, NullPointerException {

		// region Check arguments
		// region check if agrument are null TODO catch exception
		if (name == null) {
			throw new NullPointerException("name ist null at method addNewCustomer");
		}
		if (address == null) {
			throw new NullPointerException("address ist null at method addNewCustomer");
		}
		if (telNumber == null) {
			throw new NullPointerException("telNumber ist null at method addNewCustomer");
		}
		if (dateofBirth == null) {
			throw new NullPointerException("dateofBirth ist null at method addNewCustomer");
		}
		if (gender == null) {
			throw new NullPointerException("gender ist null at method addNewCustomer");
		}
		// endregion
		// region test if strings are only whitespaces TODO catch exceptions
		/*
		 * if(name.matches(".*\\w.*")){ throw new
		 * IllegalArgumentException("name contains only whitepsaces in addNewCustomer"
		 * ); } if(address.matches(".*\\w.*")){ throw new
		 * IllegalArgumentException("address contains only whitepsaces in addNewCustomer"
		 * ); } if(telNumber.matches(".*\\w.*")){ throw new
		 * IllegalArgumentException("telNumber contains only whitepsaces in addNewCustomer"
		 * ); } //endregion //TODO catch exception
		 * if(dateofBirth.isAfter(LocalDate.now())){ throw new
		 * IllegalArgumentException("dateofBirth is a Date of the future in addNewCustomer"
		 * ); } //TODO catch exception, check code if(!(gender == Gender.Female
		 * ||gender == Gender.Male ||gender == Gender.Other ||gender ==
		 * Gender.AH64)){ throw new
		 * IllegalArgumentException("gender is not validated in addNewCustomer"
		 * );
		 * 
		 * }
		 */
		// endregion

		Customer customer = new Customer(name, address, telNumber, dateofBirth, validated, gender);
		customerHelper.addCustomer(customer);

		return customer;
	}

	/**
	 * TODO check code
	 */
	public void updatePersonDetails(String name, String address, String telNumber, LocalDate dateofBirth,
			boolean validated, Gender gender, Long customerID) throws IllegalArgumentException, NullPointerException {
		// region Check arguments
		// region check if agrument are null TODO catch exception
		if (name == null) {
			throw new NullPointerException("name ist null at method addNewCustomer");
		}
		if (address == null) {
			throw new NullPointerException("address ist null at method addNewCustomer");
		}
		if (telNumber == null) {
			throw new NullPointerException("telNumber ist null at method addNewCustomer");
		}
		if (dateofBirth == null) {
			throw new NullPointerException("dateofBirth ist null at method addNewCustomer");
		}
		if (gender == null) {
			throw new NullPointerException("gender ist null at method addNewCustomer");
		}
		// endregion
		// region test if strings are only whitespaces TODO catch exceptions
		if (name.matches(".*\\w.*")) {
			throw new IllegalArgumentException("name contains only whitepsaces in addNewCustomer");
		}
		if (address.matches(".*\\w.*")) {
			throw new IllegalArgumentException("address contains only whitepsaces in addNewCustomer");
		}
		if (telNumber.matches(".*\\w.*")) {
			throw new IllegalArgumentException("telNumber contains only whitepsaces in addNewCustomer");
		}
		// endregion
		// TODO catch exception
		if (dateofBirth.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("dateofBirth is a Date of the future in addNewCustomer");
		}
		// TODO catch exception, check code
		if (!(gender == Gender.Female || gender == Gender.Male || gender == Gender.Other || gender == Gender.AH64)) {
			throw new IllegalArgumentException("gender is not validated in addNewCustomer");
		}
		// endregion
		if (customerID == null) {
			throw new NullPointerException("customerID is null in updatePersonDetails");
		}
		if (customerHelper.getCustomer(customerID) == null) {
			throw new IllegalArgumentException(
					"customerID is no valid, HashMap does not contain this ID: updatePersonDetails");
		}

		Customer customer = customerHelper.getCustomer(customerID);

		if (!name.equals(customer.getName())) {
			customer.setName(name);
		}
		if (!address.equals(customer.getAddress())) {
			customer.setAddress(address);
		}
		if (!telNumber.equals(customer.getTelNumber())) {
			customer.setTelNumber(telNumber);
		}
		if (!dateofBirth.equals(customer.getDateOfBirth())) {
			customer.setDateOfBirth(dateofBirth);
		}
		if (validated != customer.isValidated()) {
			customer.setValidated(validated);
		}
		if (!gender.equals(customer.getGender())) {
			customer.setGender(gender);
		}

	}

	public ArrayList<Customer> listCustomers() throws IllegalArgumentException {
		if (customerHelper.getAllCustomers() == null) {
			throw new IllegalArgumentException("You dont have any customers: listCustomers");
		}

		ArrayList<Customer> listCustomer = customerHelper.getAllCustomers();

		return listCustomer;
	}

	public void deleteCustomer(Long customerID) throws IllegalArgumentException, NullPointerException {
		if (customerID == null) {
			throw new NullPointerException("customerID is null in deleteCustomer");
		}
		if (customerHelper.getCustomer(customerID) == null) {
			throw new IllegalArgumentException(
					"customerID is no valid, HashMap does not contain this ID:deleteCustomer");
		}

		for (Product p : customerHelper.getCustomer(customerID).getProducts()) {
			if (p.getType() == ProductType.JuniorCurrentAccount) {
				for (Account a : p.getOwner().getAccounts()) {
					if (a == p) {
						p.getOwner().getAccounts().remove(a);
						break;
					}
				}
				customerHelper.getCustomer(customerID).getProducts().remove(p);
				continue;
			}
			customerHelper.getCustomer(customerID).getProducts().remove(p);

		}

		customerHelper.deleteCustomer(customerID);

	}

}
