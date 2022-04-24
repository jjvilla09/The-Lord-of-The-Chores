/**
 * Author: Isaac Nguyen (rrg053)
 * File: Main.java
 * Purpose: Holds functionality to launch the application.
 */

package application;
	
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

// Main class that extends Application which JavaFX application extends
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/Login.fxml").toURI().toURL();
	    	AnchorPane root = FXMLLoader.load(url);
			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("The Lord of the Chores - Login");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
