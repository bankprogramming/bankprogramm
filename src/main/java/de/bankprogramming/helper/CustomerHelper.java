/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import de.bankprogramming.models.Customer;
import de.bankprogramming.models.Product;

public class CustomerHelper {

	private static CustomerHelper instance;

	private HashMap<Long, Customer> customers;

	Gson gson;
	final File file;

	/**
	 * Constructor
	 * 
	 * @throws FileNotFoundException
	 */
	private CustomerHelper() throws FileNotFoundException {
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(Product.class, new CustomerAdapter());

		gson = new Gson();
		customers = new HashMap<>();
		file = getFileReference();
		if (file.exists()) {
			loadCustomers();
		} else {
			throw new FileNotFoundException();
		}
	}

	/**
	 *
	 * @return
	 * @throws FileNotFoundException
	 */
	public static CustomerHelper getInstance() throws FileNotFoundException {
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
		return new ArrayList<Customer>(customers.values());
	}

	/**
	 * 
	 * @param id
	 */
	public void deleteCustomer(final long id) {
		customers.remove(id);
		saveCustomers();
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
			saveCustomers();
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

	/**
	 * 
	 */
	private void saveCustomers() {
		try (FileWriter writer = new FileWriter(file)) {
			gson.toJson(customers, writer);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void loadCustomers() {
		if (file != null) {
			try (FileReader reader = new FileReader(file)) {
				customers = gson.fromJson(reader, new TypeToken<HashMap<Long, Customer>>() {
				}.getType());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	private class CustomerAdapter extends TypeAdapter<Product> {

		@Override
		public void write(JsonWriter out, Product value) throws IOException {
			out.name("productID").value(value.getProductID());
		}

		@Override
		public Product read(JsonReader in) throws IOException {
			return ProductHelper.getInstance().getProduct(in.nextLong());
		}

	}

}
