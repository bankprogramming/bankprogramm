package de.bankprogramming.util.ioc;

import de.bankprogramming.util.Bankprogramm;
import javafx.util.Callback;

/**
 * Created by Czichotzki on 28.05.2017.
 */
public class GuiceControllerFactory implements Callback<Class<?>,Object> {
    @Override
    public Object call(Class<?> param) {
        return Bankprogramm.injector.getInstance(param);
    }
}
