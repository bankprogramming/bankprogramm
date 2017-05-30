package de.bankprogramming.view;

import de.bankprogramming.Main;
import de.bankprogramming.controllers.CustomerController;
import de.bankprogramming.util.Bankprogramm;
import de.bankprogramming.wrappers.CustomerWrapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class CustomerFrame extends Stage{

    public CustomerFrame(CustomerWrapper costumer) {
        super();
        FXMLLoader loader = Bankprogramm.getLoader();
        Scene mainScene = null;
        try {
            mainScene = new Scene(loader.load(this.getClass().getResourceAsStream("CustomerFrame.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String css = Main.class.getResource("style/default.css").toExternalForm();
        CustomerController controller = loader.getController();
        mainScene.getStylesheets().add(css);
        setTitle(Bankprogramm.getLangString("application.name.customer"));
        setScene(mainScene);
        controller.setStage(this);
        if(costumer== null){
            controller.newCustomer();
        }else {
            controller.setCostumer(costumer);
        }
    }
}
