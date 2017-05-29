package de.bankprogramming.wrappers;

import de.bankprogramming.models.Credit;
import de.bankprogramming.models.enums.KindOfPayback;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class CreditWrapper extends LoanWrapper {
    private Credit original;

    private ObjectProperty<KindOfPayback> kop;

    public CreditWrapper(Credit original) {
        super(original);
        this.original = original;
        kop = new SimpleObjectProperty<>();
    }

    @Override
    public Credit getOriginal() {
        return original;
    }

    @Override
    public void updateValues() {
        super.updateValues();
        kop.set(original.getKop());
    }

    public KindOfPayback getKop() {
        return kop.get();
    }

    public ObjectProperty<KindOfPayback> kopProperty() {
        return kop;
    }

    public void setKop(KindOfPayback kop) {
        this.kop.set(kop);
    }
}
