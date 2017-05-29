/**
* @ Author: Rick
* @ Creation Date: May 28, 2017
*/
package de.bankprogramming.helper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;

import de.bankprogramming.models.Product;

public class ProductHelper {

	private static ProductHelper instance;

	private HashMap<Long, Product> products;

	Gson gson;
	final File file;

	/**
	 *
	 */
	public ProductHelper() {
		gson = new Gson();
		file = getFileReference();
	}

	/**
	 *
	 * @return
	 */
	public static ProductHelper getInstance() {
		if (ProductHelper.instance == null) {
			ProductHelper.instance = new ProductHelper();
		}
		return ProductHelper.instance;
	}

	public Product getProduct(Long id) {
		return products.get(id);
	}

	/*
	 * private
	 */

	/**
	 *
	 * @returns the file containing the products
	 */
	private File getFileReference() {
		File file = new File("Product.json");

		if (!file.exists()) {
			try {
				file.createNewFile();

				// write default content to file
				try (FileWriter writer = new FileWriter(file)) {
					HashMap<Long, Product> map = new HashMap<>();
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

	private void loadProducts() {
		if (file != null) {
			try (FileReader reader = new FileReader(file)) {
				products = gson.fromJson(reader, (Type) products);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
