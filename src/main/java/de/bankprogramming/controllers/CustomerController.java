package de.bankprogramming.controllers;

import com.google.inject.Inject;
import de.bankprogramming.view.CustomerFrame;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class CustomerController implements Initializable{

    //region FXML FIELDS
    
    //endregion
    
    @Inject
    public CustomerController() {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void setStage(CustomerFrame customerFrame) {
    }
}
