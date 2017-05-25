/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.helper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class ModelHelper {

	/**
	 *
	 * @returns the product id or -1 if there was an error during determining
	 *          the id
	 */
	public static long getProductID() {

		final File file = getFileReference();
		try (JsonReader reader = new JsonReader(new FileReader(file))) {
			int currentID = -1;
			if (reader.hasNext()) {
				currentID = reader.nextInt();
				int prodID = currentID + 1;

				try (JsonWriter writer = new JsonWriter(new FileWriter(file))) {
					// writer.
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 *
	 * @return
	 */
	private static File getFileReference() {
		File file = new File("MetaData.json");
		if (!file.exists()) {
			try {
				file.createNewFile();
				try (JsonWriter writer = new JsonWriter(new FileWriter(file))) {

				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return new File("");

	}

}
