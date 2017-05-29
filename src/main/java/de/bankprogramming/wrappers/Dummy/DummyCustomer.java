package de.bankprogramming.wrappers.Dummy;

import de.bankprogramming.models.Customer;
import de.bankprogramming.models.enums.Gender;
import de.bankprogramming.wrappers.CustomerWrapper;

import java.time.LocalDate;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class DummyCustomer extends CustomerWrapper{

    public DummyCustomer(Customer original) {
        super(original);
    }

    public DummyCustomer(){
        this(null);
        updateValues();
    }

    @Override
    public void updateValues() {
        setName("Tom");
        setAddress("Addresse");
        setTelNumber("2090138091");
        setDateOfBirth(LocalDate.now());
        setGender(Gender.AH64);
        setValidated(true);
        setCustomerId(1);
    }
}
