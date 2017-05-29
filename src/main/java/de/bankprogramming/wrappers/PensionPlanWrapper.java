package de.bankprogramming.wrappers;

import de.bankprogramming.models.PensionPlan;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class PensionPlanWrapper extends InvestmentWrapper {

    private PensionPlan original;

    private DoubleProperty monthlyInput;

    public PensionPlanWrapper(PensionPlan original) {
        super(original);
        this.original = original;
        monthlyInput = new SimpleDoubleProperty();
    }

    @Override
    public PensionPlan getOriginal() {
        return original;
    }

    @Override
    public void updateValues() {
        super.updateValues();
        monthlyInput.set(original.getMonthlyInput());
    }

    public double getMonthlyInput() {
        return monthlyInput.get();
    }

    public DoubleProperty monthlyInputProperty() {
        return monthlyInput;
    }

    public void setMonthlyInput(double monthlyInput) {
        this.monthlyInput.set(monthlyInput);
    }
}
