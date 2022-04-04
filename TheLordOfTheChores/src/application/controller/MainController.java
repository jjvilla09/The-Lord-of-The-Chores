package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private AnchorPane mainPane;

    @FXML
    void questBoardHandle(ActionEvent event) throws IOException {
    	//get url file
    	URL url = new File("src/QuestBoard.fxml").toURI().toURL();
    	//load pane
    	mainPane = FXMLLoader.load(url);
    	//create new scene
    	Scene scene = new Scene(mainPane);
    	//set stage
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	//set scene
    	window.setScene(scene);
    	// QuestBoardBranch: set title
    	window.setTitle("The Lord of the Chores - Quest Board");
    	//display scene
    	window.show();
    }

    @FXML
    void inventoryHandle(ActionEvent event) throws IOException {
    	//get url file
    	URL url = new File("src/Inventory.fxml").toURI().toURL();
       	//load pane
  	   	mainPane = FXMLLoader.load(url);
       	//create new scene
       	Scene scene = new Scene(mainPane, 800, 800);
       	//set stage
       	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
       	//set scene
       	window.setScene(scene);
       	//display scene
       	window.show();
    }

    @FXML
    void shopHandle(ActionEvent event) throws IOException {
    	//get url file
    	URL url = new File("src/Shop.fxml").toURI().toURL();
   		//load pane
   		mainPane = FXMLLoader.load(url);
    	//create new scene
    	Scene scene = new Scene(mainPane, 800, 800);
    	//set stage
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	//set scene
    	window.setScene(scene);
    	//display scene
    	window.show();
    }

}
