/**
* @ Author: Rick
* @ Creation Date: 24.05.2017
*/
package de.bankprogramming.models;

import java.time.LocalDate;

import de.bankprogramming.models.enums.ProductType;

public class Product {

	// fields

	private long productID;
	private LocalDate startDate;
	private LocalDate endDate;
	private ProductType type;

	private long customerID;

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

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

}
