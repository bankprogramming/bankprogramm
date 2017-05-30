/**
* @ Author: Rick
* @ Creation Date: May 28, 2017
*/
package de.bankprogramming.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import de.bankprogramming.models.Product;

public class ProductHelper {

	private static ProductHelper instance;

	private HashMap<Long, Product> products;

	Gson gson;
	// final File file;

	/**
	 * Constructor
	 */
	public ProductHelper() {
		gson = new Gson();
		// file = getFileReference();
		// if (file.exists()) {
		// loadProducts();
		// } else {
		// // exception
		// }
	}

	/**
	 * 
	 * @returns an instance of the product helper
	 */
	public static ProductHelper getInstance() {
		if (ProductHelper.instance == null) {
			ProductHelper.instance = new ProductHelper();
		}
		return ProductHelper.instance;
	}

	public ArrayList<Product> getAllProducts() {
		return (ArrayList<Product>) products.values();
	}

	/**
	 * 
	 * @param id
	 * @returns the product with the specified id
	 */
	public Product getProduct(Long id) {
		return products.get(id);
	}

	/**
	 * 
	 * @param product
	 * @returns true if the product was successfully added and false if the
	 *          product was null
	 */
	public boolean addProduct(Product product) {
		if (product != null) {
			products.put(product.getProductID(), product);
			// saveProducts();
			return true;
		} else {
			return false;
		}
	}

	public void deleteProduct(Product p) {
		products.remove(p.getProductID());
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

	/**
	 * 
	 */
	// private void loadProducts() {
	// if (file != null) {
	// try (FileReader reader = new FileReader(file)) {
	// products = gson.fromJson(reader, (Type) products);
	// } catch (IOException ioe) {
	// ioe.printStackTrace();
	// }
	// }
	// }

	/**
	 * 
	 */
	// private void saveProducts() {
	// try (FileWriter writer = new FileWriter(file)) {
	// gson.toJson(products, writer);
	// } catch (IOException ioe) {
	// ioe.printStackTrace();
	// }
	// }

}
