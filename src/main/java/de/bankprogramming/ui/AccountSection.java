package de.bankprogramming.ui;

import de.bankprogramming.models.Account;
import de.bankprogramming.models.JuniorCurrentAccount;
import de.bankprogramming.util.Bankprogramm;
import de.bankprogramming.wrappers.AccountWrapper;
import de.bankprogramming.wrappers.JuniorCurrentAccountWrapper;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class AccountSection extends AnchorPane{

    private AccountWrapper account;

    @FXML
    private TextField limitTextField;
    @FXML
    private TextField interestTextField;
    @FXML
    private TextField guardianTextField;
    @FXML
    private ToggleButton closedToggleButton;
    @FXML
    private VBox juniorPane;


    public AccountSection() {
        FXMLLoader loader = Bankprogramm.getLoader();
        try {
            loader.setRoot(this);
            loader.setController(this);
            loader.load(this.getClass().getResourceAsStream("AccountSection.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        juniorPane.setVisible(false);
    }

    public AccountWrapper getAccount() {
        return account;
    }

    public void setAccount(AccountWrapper account) {
        this.account = account;
        juniorPane.setVisible(false);
        limitTextField.textProperty().bindBidirectional(account.limitProperty(), new NumberStringConverter());
        interestTextField.textProperty().bindBidirectional(account.interestRateProperty(), new NumberStringConverter());
        closedToggleButton.selectedProperty().bindBidirectional(account.lockedProperty());
        if(account instanceof JuniorCurrentAccountWrapper){
            guardianTextField.setText(((JuniorCurrentAccountWrapper)account).guardianProperty().getName());
            juniorPane.setVisible(true);
        }
    }

    @FXML
    public void onSelectGuardian(ActionEvent event){

    }
}
