/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.models;

import java.util.Date;

import de.bankprogramming.models.enums.ProductType;

public class Product {

	// fields

	public long productID;
	public Date startDate;
	public Date beginDate;
	public ProductType type;

	public long customerID;

	/**
	 *
	 * @param type
	 */
	public Product(ProductType type) {
		this.type = type;
		startDate = new Date(System.currentTimeMillis());
	}
}
