/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.helper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;

public class ModelHelper {

	private static ModelHelper instance;

	private HashMap<String, Integer> metaData;
	private Gson gson = new Gson();
	final File file;

	public ModelHelper() {
		file = getFileReference();

		try (FileReader reader = new FileReader(file)) {
			if (reader.ready()) {
				metaData = gson.fromJson(reader, (Type) metaData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ModelHelper getInstance() {
		if (ModelHelper.instance == null) {
			ModelHelper.instance = new ModelHelper();
		}
		return ModelHelper.instance;
	}

	/*
	 * public
	 */

	/**
	 *
	 * @returns the product id or -1 if there was an error during determining
	 *          the id
	 */
	public long getProductID() {

		int prodID = metaData.get("productID");

		int currentID = prodID + 1;
		metaData.put("productID", prodID);

		// save to file
		try (FileWriter writer = new FileWriter(file)) {
			gson.toJson(prodID, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return currentID;
	}

	public long getCustomerID() {
		int custID = metaData.get("customerID");

		int currentID = custID + 1;
		metaData.put("customerID", custID);

		// save to file
		try (FileWriter writer = new FileWriter(file)) {
			gson.toJson(custID, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return currentID;
	}

	/*
	 * private
	 */

	/**
	 *
	 * @returns the file containing the metadata
	 */
	private File getFileReference() {
		File file = new File("MetaData.json");

		if (!file.exists()) {
			try {
				file.createNewFile();

				// write default content to file
				try (FileWriter writer = new FileWriter(file)) {
					metaData = new HashMap<>();
					metaData.put("prodID", new Integer(0));
					metaData.put("customerID", new Integer(0));
					gson.toJson(metaData, writer);
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
