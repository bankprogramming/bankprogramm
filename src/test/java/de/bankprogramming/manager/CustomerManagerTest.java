package de.bankprogramming.manager;

import static org.junit.Assert.*;

import de.bankprogramming.models.Customer;
import de.bankprogramming.models.Mortgage;
import de.bankprogramming.models.Product;
import de.bankprogramming.models.enums.Gender;
import de.bankprogramming.wrappers.MortgageWrapper;
import de.bankprogramming.wrappers.ProductWrapper;
import de.bankprogramming.wrappers.WrapperHelper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.IllegalFormatException;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class CustomerManagerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void TestNewCustomer(){
        thrown.expect(IllegalArgumentException.class);

        CustomerManager manager = new CustomerManager();
        Customer c = manager.addNewCustomer("dads", "Tom", "Tom", LocalDate.now(),true, Gender.AH64);

    }

    @Test
    public void TestWrapProduct(){
        Mortgage m = new Mortgage(null,null, 10000.0, 0.5, 1.0,"dsaads", Period.ofDays(200));

        ProductWrapper w = WrapperHelper.wrapProduct(m);

        System.out.println(w.getClass().getName());

        assertTrue(w instanceof MortgageWrapper);
    }
}
