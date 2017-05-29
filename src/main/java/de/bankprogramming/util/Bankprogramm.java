package de.bankprogramming.util;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.bankprogramming.ui.ExceptionAlert;
import de.bankprogramming.util.ioc.GuiceControllerFactory;
import de.bankprogramming.util.ioc.MainIocModule;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;

import java.util.ResourceBundle;

/**
 * Created by Czichotzki on 28.05.2017.
 */
public class Bankprogramm {

    public static Injector injector;

    public static void init(){
        injector = Guice.createInjector(new MainIocModule());
    }

    public static FXMLLoader getLoader(){
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(new GuiceControllerFactory());
        loader.setResources(injector.getInstance(ResourceBundle.class));
        return loader;
    }

    public static String getLangString(String key){
        return injector.getInstance(ResourceBundle.class).getString(key);
    }

    public static void handleException(Exception e){
        e.printStackTrace();
        if(Platform.isFxApplicationThread()){
            Alert alert = new ExceptionAlert(e);
            alert.showAndWait();
        }
    }
}
