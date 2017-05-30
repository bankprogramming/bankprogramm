package de.bankprogramming.wrappers;

import de.bankprogramming.models.Mortgage;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class MortgageWrapper extends LoanWrapper {

    private Mortgage original;

    private DoubleProperty loanToValueLimit;
    private DoubleProperty fee;
    private DoubleProperty repaymentPenalty;
    private StringProperty insurance;

    public MortgageWrapper(Mortgage original) {
        super(original, false);
        this.original = original;
        loanToValueLimit = new SimpleDoubleProperty();
        fee = new SimpleDoubleProperty();
        repaymentPenalty = new SimpleDoubleProperty();
        insurance = new SimpleStringProperty();
        updateValues();
    }

    @Override
    public Mortgage getOriginal() {
        return original;
    }

    @Override
    public void updateValues() {
        super.updateValues();
        loanToValueLimit.set(original.getLoanToValueLimit());
        fee.set(original.getFee());
        repaymentPenalty.set(original.getRepaymentPenalty());
        insurance.set(original.getInsurance());
    }

    public double getLoanToValueLimit() {
        return loanToValueLimit.get();
    }

    public DoubleProperty loanToValueLimitProperty() {
        return loanToValueLimit;
    }

    public void setLoanToValueLimit(double loanToValueLimit) {
        this.loanToValueLimit.set(loanToValueLimit);
    }

    public double getFee() {
        return fee.get();
    }

    public DoubleProperty feeProperty() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee.set(fee);
    }

    public double getRepaymentPenalty() {
        return repaymentPenalty.get();
    }

    public DoubleProperty repaymentPenaltyProperty() {
        return repaymentPenalty;
    }

    public void setRepaymentPenalty(double repaymentPenalty) {
        this.repaymentPenalty.set(repaymentPenalty);
    }

    public String getInsurance() {
        return insurance.get();
    }

    public StringProperty insuranceProperty() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance.set(insurance);
    }
}
