package de.bankprogramming.wrappers;

import de.bankprogramming.models.Card;
import javafx.beans.property.*;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class CardWrapper extends ProductWrapper {
    private Card original;

    private DoubleProperty yearlyFee;
    private StringProperty cardStyle;

    private IntegerProperty limit;

    private BooleanProperty international;
    private BooleanProperty locked;

    public CardWrapper(Card original, boolean updateValues) {
        super(original, false);
        this.original = original;
        yearlyFee = new SimpleDoubleProperty();
        cardStyle = new SimpleStringProperty();
        limit = new SimpleIntegerProperty();
        international = new SimpleBooleanProperty();
        locked = new SimpleBooleanProperty();
        if(updateValues)
            updateValues();
    }

    public CardWrapper(Card original){
        this(original, true);
    }

    @Override
    public Card getOriginal() {
        return original;
    }

    @Override
    public void updateValues() {
        super.updateValues();
        yearlyFee.set(getOriginal().getYearlyFee());
        cardStyle.set(getOriginal().getCardStyle());
        limit.set(getOriginal().getLimit());
        international.set(getOriginal().isInternational());
        locked.set(getOriginal().isLocked());
    }

    public double getYearlyFee() {
        return yearlyFee.get();
    }

    public DoubleProperty yearlyFeeProperty() {
        return yearlyFee;
    }

    public void setYearlyFee(double yearlyFee) {
        this.yearlyFee.set(yearlyFee);
    }

    public String getCardStyle() {
        return cardStyle.get();
    }

    public StringProperty cardStyleProperty() {
        return cardStyle;
    }

    public void setCardStyle(String cardStyle) {
        this.cardStyle.set(cardStyle);
    }

    public int getLimit() {
        return limit.get();
    }

    public IntegerProperty limitProperty() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit.set(limit);
    }

    public boolean isInternational() {
        return international.get();
    }

    public BooleanProperty internationalProperty() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international.set(international);
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
