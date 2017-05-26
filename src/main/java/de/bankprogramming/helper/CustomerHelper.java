/**
* @ Author: Rick
* @ Creation Date: May 26, 2017
*/
package de.bankprogramming.helper;

public class CustomerHelper {

	private static CustomerHelper instance;

	private CustomerHelper() {
		// TODO Auto-generated constructor stub
	}

	public static CustomerHelper getInstance() {
		if (CustomerHelper.instance == null) {
			CustomerHelper.instance = new CustomerHelper();
		}
		return CustomerHelper.instance;
	}

	public long getCustomerID() {
		return 0L;
	}
}
