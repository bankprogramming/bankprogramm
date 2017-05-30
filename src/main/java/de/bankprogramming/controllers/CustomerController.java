package de.bankprogramming.controllers;

import com.google.inject.Inject;
import de.bankprogramming.manager.CustomerManager;
import de.bankprogramming.models.JuniorCurrentAccount;
import de.bankprogramming.models.enums.Gender;
import de.bankprogramming.ui.AccountSection;
import de.bankprogramming.view.CustomerFrame;
import de.bankprogramming.wrappers.AccountWrapper;
import de.bankprogramming.wrappers.CustomerWrapper;
import de.bankprogramming.wrappers.JuniorCurrentAccountWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class CustomerController implements Initializable{

    //region FXML FIELDS
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField telTextField;
    @FXML
    private DatePicker birthDatePicker;
    @FXML
    private ToggleButton validatedToggleButton;
    @FXML
    private ChoiceBox<Gender> genderChoiceBox;
    @FXML
    private HBox productPane;
    //endregion

    private CustomerWrapper customer;
    private CustomerManager manager;
    private AccountSection section;
    
    @Inject
    public CustomerController(CustomerManager manager) {
        this.manager = manager;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderChoiceBox.setItems(FXCollections.observableArrayList(Gender.values()));

        section = new AccountSection();
        section.setAccount(new JuniorCurrentAccountWrapper(null, false));
        productPane.getChildren().add(section);
        productPane.setHgrow(section, Priority.ALWAYS);
    }

    public void newCustomer(){
        customer = new CustomerWrapper();
        bind();
    }

    private void bind() {
        nameTextField.textProperty().bindBidirectional(customer.nameProperty());
        addressTextField.textProperty().bindBidirectional(customer.addressProperty());
        telTextField.textProperty().bindBidirectional(customer.telNumberProperty());
        birthDatePicker.valueProperty().bindBidirectional(customer.dateOfBirthProperty());
        validatedToggleButton.selectedProperty().bindBidirectional(customer.validatedProperty());
        genderChoiceBox.valueProperty().bindBidirectional(customer.genderProperty());
    }

    public void setCostumer(CustomerWrapper wrapper){
        customer = wrapper;
        bind();
    }

    public void setStage(CustomerFrame customerFrame) {

    }

    @FXML
    public void onSave(ActionEvent event){
        //manager.addNewCustomer(customer.getName(), customer.getAddress(), customer.getTelNumber(), customer.getDateOfBirth(), customer.isValidated(), customer.getGender());
    }

    @FXML
    public void onCancel(ActionEvent event){

    }
}
