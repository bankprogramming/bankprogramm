package de.bankprogramming.wrappers;

import de.bankprogramming.models.Transaction;
import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Created by Czichotzki on 28.05.2017.
 */
public class TransactionWrapper implements Wrapper<Transaction>{

    private Transaction original;

    private DoubleProperty amount;

    private LongProperty targetID;
    private LongProperty targetAccount;

    private LongProperty sourceID;
    private LongProperty sourceAccount;

    private ObjectProperty<LocalDate> timestamp;
    private ObjectProperty<LocalDate> triggerDate;

    public TransactionWrapper(Transaction original) {
        this.original = original;
        targetID = new SimpleLongProperty();
        targetAccount = new SimpleLongProperty();
        sourceID = new SimpleLongProperty();
        sourceAccount = new SimpleLongProperty();
        amount = new SimpleDoubleProperty();
        timestamp = new SimpleObjectProperty<>();
        triggerDate = new SimpleObjectProperty<>();
        updateValues();
    }

    @Override
    public Transaction getOriginal() {
        return original;
    }

    @Override
    public void updateValues() {
        targetID.set(original.getTargetID());
        targetAccount.set(original.getTargetAccount());
        sourceID.set(original.getSourceID());
        sourceAccount.set(original.getSourceAccount());
        amount.set(original.getAmount());
        timestamp.set(original.getTimestamp());
        triggerDate.set(original.getTriggerDate());
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

    public long getTargetID() {
        return targetID.get();
    }

    public LongProperty targetIDProperty() {
        return targetID;
    }

    public void setTargetID(long targetID) {
        this.targetID.set(targetID);
    }

    public long getTargetAccount() {
        return targetAccount.get();
    }

    public LongProperty targetAccountProperty() {
        return targetAccount;
    }

    public void setTargetAccount(long targetAccount) {
        this.targetAccount.set(targetAccount);
    }

    public long getSourceID() {
        return sourceID.get();
    }

    public LongProperty sourceIDProperty() {
        return sourceID;
    }

    public void setSourceID(long sourceID) {
        this.sourceID.set(sourceID);
    }

    public long getSourceAccount() {
        return sourceAccount.get();
    }

    public LongProperty sourceAccountProperty() {
        return sourceAccount;
    }

    public void setSourceAccount(long sourceAccount) {
        this.sourceAccount.set(sourceAccount);
    }

    public LocalDate getTimestamp() {
        return timestamp.get();
    }

    public ObjectProperty<LocalDate> timestampProperty() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp.set(timestamp);
    }

    public LocalDate getTriggerDate() {
        return triggerDate.get();
    }

    public ObjectProperty<LocalDate> triggerDateProperty() {
        return triggerDate;
    }

    public void setTriggerDate(LocalDate triggerDate) {
        this.triggerDate.set(triggerDate);
    }
}
