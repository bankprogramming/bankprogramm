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

	private Customer owner;

	/**
	 *
	 * @param type
	 */
	public Product(ProductType type, Customer owner) {
		this.type = type;
		startDate = LocalDate.now();
		// productID = ModelHelper.getProductID();
		this.owner = owner;
	}

	/**
	 * @return the productID
	 */
	public long getProductID() {
		return productID;
	}

	/**
	 * @param productID
	 *            the productID to set
	 */
	public void setProductID(long productID) {
		this.productID = productID;
	}

	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the type
	 */
	public ProductType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(ProductType type) {
		this.type = type;
	}

	/**
	 * @return the owner
	 */
	public Customer getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(Customer owner) {
		this.owner = owner;
	}

}
