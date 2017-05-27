/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class CustomerHelper {

	private static CustomerHelper instance;

	Gson gson;
	final File file;

	/**
	 *
	 */
	private CustomerHelper() {
		gson = new Gson();
		file = getFileReference();

	}

	public static CustomerHelper getInstance() {
		if (CustomerHelper.instance == null) {
			CustomerHelper.instance = new CustomerHelper();
		}
		return CustomerHelper.instance;
	}

	/**
	 *
	 * @returns the file with the metadata
	 */
	private File getFileReference() {
		File file = new File("Customers.json");

		if (!file.exists()) {
			try {
				file.createNewFile();

				// write default content to file
				try (FileWriter writer = new FileWriter(file)) {
					int prodID = 0;
					gson.toJson(prodID, writer);
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
