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
			//get url file 
			URL url = new File("src/Main.fxml").toURI().toURL();
			//load pane
	    	AnchorPane root = FXMLLoader.load(url);
	    	//create new scene
			Scene scene = new Scene(root,800,800);
			//set scene
			primaryStage.setScene(scene);
			// QuestBoardBranch: set title
			primaryStage.setTitle("The Lord of the Chores: Hub Area");
			//display scene
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//lauches application
		launch(args);
	}
}
