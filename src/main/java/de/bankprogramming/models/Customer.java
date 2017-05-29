/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import de.bankprogramming.helper.ModelHelper;
import de.bankprogramming.models.enums.Gender;

public class Customer {

	// fields
	private long customerId;
	private String name;
	private String address;
	private String telNumber;
	private LocalDate dateOfBirth;
	private boolean validated;
	private Gender gender;

	private ArrayList<Product> products;

	public Customer(final String name, final String address, final String telNumber, final LocalDate dateofBirth,
			final boolean validated, final Gender gender) {
		customerId = ModelHelper.getInstance().getCustomerID();
		this.name = name;
		this.address = address;
		this.telNumber = telNumber;
		this.dateOfBirth = dateofBirth;
		this.validated = validated;
		this.gender = gender;
		products = new ArrayList<Product>();
	}

	public ArrayList<Account> getAccounts() {
		ArrayList<Account> list = new ArrayList<>();
		for (Product p : products) {
			if (p instanceof Account) {
				list.add((Account) p);
			}
		}
		return list;
	}

	public int getAge() {
		LocalDate now = LocalDate.now();
		Period p = Period.between(dateOfBirth, now);
		return p.getYears();
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

}
