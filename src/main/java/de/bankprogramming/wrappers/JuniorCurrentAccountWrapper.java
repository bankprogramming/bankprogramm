package de.bankprogramming.wrappers;

import de.bankprogramming.models.Account;
import de.bankprogramming.models.JuniorCurrentAccount;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class JuniorCurrentAccountWrapper extends AccountWrapper{

    private JuniorCurrentAccount original;

    private LongProperty guardian;
    private IntegerProperty maxAge;

    public JuniorCurrentAccountWrapper(JuniorCurrentAccount original) {
        super(original);
        this.original = original;
        guardian = new SimpleLongProperty();
        maxAge = new SimpleIntegerProperty();
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

    public long getGuardian() {
        return guardian.get();
    }

    public LongProperty guardianProperty() {
        return guardian;
    }

    public void setGuardian(long guardian) {
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
