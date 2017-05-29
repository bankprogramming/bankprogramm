/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;

import de.bankprogramming.models.Customer;

public class CustomerHelper {

	private static CustomerHelper instance;

	private HashMap<Long, Customer> customers;

	Gson gson;
	final File file;

	/**
	 *
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
