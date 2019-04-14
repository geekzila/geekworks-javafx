package com.geekzila.books;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ariv
 * 
 * Main application Starts here..........
 */
public class LoginApplication extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		/**
		 * Load login Document and show it to User. This is main application starts as Root.
		 */
		Parent root = FXMLLoader.load(getClass().getResource("/com/geekzila/books/view/FXMLDocument.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
