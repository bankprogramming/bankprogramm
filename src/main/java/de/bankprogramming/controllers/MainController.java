package de.bankprogramming.controllers;

import com.google.inject.Inject;
import de.bankprogramming.manager.CustomerManager;
import de.bankprogramming.models.Account;
import de.bankprogramming.models.Customer;
import de.bankprogramming.models.enums.Gender;
import de.bankprogramming.view.CustomerFrame;
import de.bankprogramming.wrappers.CustomerWrapper;
import de.bankprogramming.wrappers.Dummy.DummyCustomer;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class MainController implements Initializable{

    private Stage stage;

    //region FXML FIELDS
    @FXML
    private TableView<CustomerWrapper> customerTableView;
    @FXML
    private TableColumn<CustomerWrapper, Number> idColumn;
    @FXML
    private TableColumn<CustomerWrapper, String> nameColumn;
    @FXML
    private TableColumn<CustomerWrapper, String> addressColumn;
    @FXML
    private TableColumn<CustomerWrapper, String> telColumn;
    @FXML
    private TableColumn<CustomerWrapper, LocalDate> birthColumn;
    @FXML
    private ChoiceBox<Account> srcAccountChoiceBox;
    @FXML
    private ChoiceBox<Account> desAccountChoiceBox;
    @FXML
    private TextField transAmount;
    @FXML
    private DatePicker transDate;
    //endregion


    //Properties
    private ListProperty<CustomerWrapper> customerList;
    private ObjectProperty<CustomerWrapper> selectedCustomer;
    private CustomerManager manager;

    @Inject
    public MainController(CustomerManager manager) {
        customerList = new SimpleListProperty<>(FXCollections.observableList(new ArrayList<>()));
        selectedCustomer = new SimpleObjectProperty<>();
        this.manager = manager;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerTableView.itemsProperty().bind(customerList);
        selectedCustomer.bind(customerTableView.getSelectionModel().selectedItemProperty());

        idColumn.setCellValueFactory(param -> param.getValue().customerIdProperty());
        nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        addressColumn.setCellValueFactory(param -> param.getValue().addressProperty());
        birthColumn.setCellValueFactory(param -> param.getValue().dateOfBirthProperty());
        telColumn.setCellValueFactory(param -> param.getValue().telNumberProperty());

        updateList();
    }

    public void updateList() {
        customerList.clear();
        List<Customer> list = manager.listCustomers();
        for (Customer c: manager.listCustomers()
             ) {
            customerList.add(new CustomerWrapper(c));
        }
    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    //region FXML EVENTS
    @FXML
    public void onSelectSrc(ActionEvent event){

    }

    @FXML
    public void onSelectDest(ActionEvent event){

    }

    @FXML
    public void onTransfer(ActionEvent event){

    }

    @FXML
    public void onClean(ActionEvent event){

    }

    @FXML
    public void onAddCustomer(ActionEvent event){
        CustomerFrame frame = new CustomerFrame(null);
        frame.showAndWait();
        updateList();
    }
    //endregion

}
