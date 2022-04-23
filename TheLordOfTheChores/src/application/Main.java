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

/**
 * @author Isaac Nguyen (rrg053)
 * UTSA CS 3443 - Lab 4
 * Spring 2022
 */
// Main class that extends Application which JavaFX application extends
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//gets login url
			URL url = new File("src/Login.fxml").toURI().toURL();
			//loads pane
	    	AnchorPane root = FXMLLoader.load(url);
	    	//create scene
			Scene scene = new Scene(root,600,400);
			//set scene
			primaryStage.setScene(scene);
			//set title
			primaryStage.setTitle("The Lord of the Chores - Login");
			//display scene
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
