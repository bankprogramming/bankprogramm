package de.bankprogramming.wrappers;

import de.bankprogramming.models.Customer;
import de.bankprogramming.models.Product;
import de.bankprogramming.models.enums.Gender;
import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class CustomerWrapper implements Wrapper<Customer> {

    private Customer original;

    private LongProperty customerId;
    private StringProperty name;
    private StringProperty address;
    private StringProperty telNumber;
    private ObjectProperty<LocalDate> dateOfBirth;
    private BooleanProperty validated;
    private ObjectProperty<Gender> gender;

    private ListProperty<ProductWrapper> products;

    public CustomerWrapper(Customer original) {
        this.original = original;
        customerId = new SimpleLongProperty();
        name = new SimpleStringProperty();
        address = new SimpleStringProperty();
        telNumber = new SimpleStringProperty();
        dateOfBirth = new SimpleObjectProperty<>();
        validated = new SimpleBooleanProperty();
        gender = new SimpleObjectProperty<>();
        products = new SimpleListProperty<>();
        if(original!=null)
            updateValues();
    }

    public CustomerWrapper(){
        this(null);
    }

    @Override
    public Customer getOriginal() {
        return original;
    }

    @Override
    public void updateValues() {
        customerId.set(original.getCustomerId());
        name.set(original.getName());
        address.set(original.getAddress());
        telNumber.set(original.getTelNumber());
        dateOfBirth.set(original.getDateOfBirth());
        validated.set(original.isValidated());
        gender.set(original.getGender());
        products.clear();
        for (Product p :
                original.getProducts()) {
            products.add(WrapperHelper.wrapProduct(p));
        }
    }

    public void applyChanges(){
    }

    public long getCustomerId() {
        return customerId.get();
    }

    public LongProperty customerIdProperty() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId.set(customerId);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getTelNumber() {
        return telNumber.get();
    }

    public StringProperty telNumberProperty() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber.set(telNumber);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public ObjectProperty<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public boolean isValidated() {
        return validated.get();
    }

    public BooleanProperty validatedProperty() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated.set(validated);
    }

    public Gender getGender() {
        return gender.get();
    }

    public ObjectProperty<Gender> genderProperty() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender.set(gender);
    }
}
