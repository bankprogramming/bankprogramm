/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import de.bankprogramming.models.Customer;

public class CustomerHelper {

	private static CustomerHelper instance;

	private HashMap<Long, Customer> customers;

	Gson gson;
	final File file;

	/**
	 * Constructor
	 */
	private CustomerHelper() {
		gson = new Gson();
		file = getFileReference();
	}

	/**
	 *
	 * @return
	 */
	public static CustomerHelper getInstance() {
		if (CustomerHelper.instance == null) {
			CustomerHelper.instance = new CustomerHelper();
		}
		return CustomerHelper.instance;
	}

	/**
	 * 
	 * @returns all currently saved customers
	 */
	public ArrayList<Customer> getAllCustomers() {
		return (ArrayList<Customer>) customers.values();
	}

	/**
	 * 
	 * @param id
	 */
	public void deleteCustomer(final long id) {
		customers.remove(id);
	}

	/*
	 * public
	 */

	/**
	 * 
	 * @param id
	 * @returns the customer or null if no mapping exists
	 */
	public Customer getCustomer(Long id) {
		return customers.get(id);
	}

	/**
	 * 
	 * @param customer
	 * @returns true if customer is not null and true if the customer was
	 *          succesfully added to the map
	 */
	public boolean addCustomer(final Customer customer) {
		if (customer != null) {
			customers.put(customer.getCustomerId(), customer);
			return true;
		} else {
			return false;
		}
	}
	/*
	 * private
	 */

	/**
	 *
	 * @returns the file containing the customers
	 */
	private File getFileReference() {
		File file = new File("Customers.json");

		if (!file.exists()) {
			try {
				file.createNewFile();

				// write default content to file
				try (FileWriter writer = new FileWriter(file)) {
					HashMap<Long, Customer> map = new HashMap<>();
					gson.toJson(map, writer);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

}
