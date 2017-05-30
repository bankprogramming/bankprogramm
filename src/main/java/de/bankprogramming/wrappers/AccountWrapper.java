package de.bankprogramming.wrappers;

import de.bankprogramming.models.Account;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class AccountWrapper extends ProductWrapper {

    private Account original;

    private DoubleProperty balance;
    private DoubleProperty limit;
    private DoubleProperty interestRate;

    private BooleanProperty locked;

    public AccountWrapper(Account original, boolean updateValues) {
        super(original, false);
        this.original = original;
        balance = new SimpleDoubleProperty();
        limit = new SimpleDoubleProperty();
        interestRate = new SimpleDoubleProperty();
        locked = new SimpleBooleanProperty();
        if(updateValues)
            updateValues();
    }

    public AccountWrapper(Account original){
        this(original, true);
    }


    @Override
    public Account getOriginal() {
       return original;
    }

    @Override
    public void updateValues() {
        super.updateValues();
        balance.set(getOriginal().getBalance());
        limit.set(getOriginal().getLimit());
        interestRate.set(getOriginal().getInterestRate());
        locked.set(getOriginal().isLocked());
    }

    public double getBalance() {
        return balance.get();
    }

    public DoubleProperty balanceProperty() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance.set(balance);
    }

    public double getLimit() {
        return limit.get();
    }

    public DoubleProperty limitProperty() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit.set(limit);
    }

    public double getInterestRate() {
        return interestRate.get();
    }

    public DoubleProperty interestRateProperty() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate.set(interestRate);
    }

    public boolean isLocked() {
        return locked.get();
    }

    public BooleanProperty lockedProperty() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked.set(locked);
    }
}
