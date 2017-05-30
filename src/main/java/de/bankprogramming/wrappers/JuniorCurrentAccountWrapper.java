package de.bankprogramming.wrappers;

import de.bankprogramming.models.Account;
import de.bankprogramming.models.Customer;
import de.bankprogramming.models.JuniorCurrentAccount;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class JuniorCurrentAccountWrapper extends AccountWrapper {

	private JuniorCurrentAccount original;

	private ObjectProperty<Customer> guardian;
	private IntegerProperty maxAge;

	public JuniorCurrentAccountWrapper(JuniorCurrentAccount original, boolean updateValues) {
		super(original, false);
		this.original = original;
		guardian = new SimpleObjectProperty<>();
		maxAge = new SimpleIntegerProperty();
		if(updateValues)
			updateValues();
	}

	public JuniorCurrentAccountWrapper(JuniorCurrentAccount original){
		this(original, true);
	}

	@Override
	public Account getOriginal() {
		return original;
	}

	@Override
	public void updateValues() {
		super.updateValues();
		guardian.set(original.getGuardian());
		maxAge.set(original.getMaxAge());
	}

	public Customer getGuardian() {
		return guardian.get();
	}

	public SimpleObjectProperty<Customer> guardianProperty() {
		return (SimpleObjectProperty<Customer>) guardian;
	}

	public void setGuardian(Customer guardian) {
		this.guardian.set(guardian);
	}

	public int getMaxAge() {
		return maxAge.get();
	}

	public IntegerProperty maxAgeProperty() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge.set(maxAge);
	}
}
