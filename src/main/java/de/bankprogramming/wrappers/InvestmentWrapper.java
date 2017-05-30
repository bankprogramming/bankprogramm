package de.bankprogramming.wrappers;

import de.bankprogramming.models.Investment;
import de.bankprogramming.models.Product;
import de.bankprogramming.models.enums.Strategy;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class InvestmentWrapper extends ProductWrapper {

    private Investment original;

    private ListProperty<String> portfolio;
    private ObjectProperty<Strategy> strategy;

    public InvestmentWrapper(Investment original, boolean updateValues) {
        super(original, false);
        this.original = original;
        portfolio = new SimpleListProperty<>();
        strategy = new SimpleObjectProperty<>();
        if(updateValues)
            updateValues();
    }

    public InvestmentWrapper(Investment original) {
        this(original, true);
    }

    @Override
    public Investment getOriginal() {
        return original;
    }

    @Override
    public void updateValues() {
        super.updateValues();
        strategy.set(original.getStrategy());
        portfolio.set(FXCollections.observableArrayList(original.getPortfolio()));
    }
}
