package de.bankprogramming.view;

import de.bankprogramming.Main;
import de.bankprogramming.controllers.MainController;
import de.bankprogramming.models.Product;
import de.bankprogramming.util.Bankprogramm;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Czichotzki on 29.05.2017.
 */
public class MainFrame {

    private Stage primaryStage;

    public MainFrame(Stage primaryStage){
        this.primaryStage = primaryStage;
        FXMLLoader loader = Bankprogramm.getLoader();
        Scene mainScene = null;
        try {
            mainScene = new Scene(loader.load(this.getClass().getResourceAsStream("MainFrame.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String css = Main.class.getResource("style/default.css").toExternalForm();
        MainController controller = loader.getController();
        mainScene.getStylesheets().add(css);
        primaryStage.setTitle(Bankprogramm.getLangString("application.name"));
        primaryStage.setScene(mainScene);
        controller.setStage(primaryStage);
    }

    public void show() {
        primaryStage.show();
    }
}
