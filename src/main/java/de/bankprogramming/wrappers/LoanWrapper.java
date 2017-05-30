package de.bankprogramming.wrappers;

import de.bankprogramming.models.Loan;
import de.bankprogramming.models.Mortgage;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.Period;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class LoanWrapper extends ProductWrapper {

    private Loan original;

    private DoubleProperty amount;
    private DoubleProperty interestRate;
    private ObjectProperty<Period> duration;

    public LoanWrapper(Loan original, boolean updateValues) {
        super(original, false);
        this.original = original;
        amount = new SimpleDoubleProperty();
        interestRate = new SimpleDoubleProperty();
        duration = new SimpleObjectProperty<>();
        if(updateValues)
            updateValues();
    }

    public LoanWrapper(Loan original) {
        this(original, true);
    }

    @Override
    public Loan getOriginal() {
        return original;
    }

    @Override
    public void updateValues() {
        super.updateValues();
        amount.set(original.getAmount());
        interestRate.set(original.getInterestRate());
        duration.set(original.getDuration());
    }

    public double getAmount() {
        return amount.get();
    }

    public DoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
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

    public Period getDuration() {
        return duration.get();
    }

    public ObjectProperty<Period> durationProperty() {
        return duration;
    }

    public void setDuration(Period duration) {
        this.duration.set(duration);
    }
}
