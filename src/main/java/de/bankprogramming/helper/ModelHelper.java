/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.helper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;

public class ModelHelper {

	private HashMap<String, Integer> metaData;
	private Gson gson = new Gson();
	final File file;

	public ModelHelper() {
		file = getFileReference(gson);

		try (FileReader reader = new FileReader(file)) {
			if (reader.ready()) {
				metaData = gson.fromJson(reader, new HashMap<String, Integer>().getClass());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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

	/**
	 *
	 * @returns the file with the metadata
	 */
	private File getFileReference(Gson gson) {
		File file = new File("MetaData.json");

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
