package de.bankprogramming.util.ioc;

import com.google.inject.AbstractModule;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Czichotzki on 28.05.2017.
 */
public class MainIocModule extends AbstractModule {

    private Locale globalLocale;
    private ResourceBundle resourceBundle;

    public MainIocModule(){
        globalLocale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("de.bankprogramming.lang.lang", globalLocale);
    }

    @Override
    protected void configure() {
        bind(Locale.class).toInstance(globalLocale);
        bind(ResourceBundle.class).toInstance(resourceBundle);
    }
}
