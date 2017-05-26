/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.models;

import java.time.LocalDate;

import de.bankprogramming.models.enums.ProductType;

public class Product {

	// fields

	public long productID;
	public LocalDate startDate;
	public LocalDate endDate;
	public ProductType type;

	public long customerID;

	/**
	 *
	 * @param type
	 */
	public Product(ProductType type, long customerID) {
		this.type = type;
		startDate = LocalDate.now();
		// productID = ModelHelper.getProductID();
		this.customerID = customerID;
	}
}
