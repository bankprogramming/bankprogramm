package de.bankprogramming;

import de.bankprogramming.util.Bankprogramm;
import de.bankprogramming.view.MainFrame;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by puruckel on 23.05.2017.
 */
public class Main extends Application {

	public static void main(String[] args) {
		Bankprogramm.init();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		MainFrame mainFrame = new MainFrame(primaryStage);
		mainFrame.show();
	}
}
