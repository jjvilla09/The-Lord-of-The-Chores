/**
 * Author: Nikhil Kapoor (yct482)
 * File: MainController.java
 * Purpose: Holds functionality for the Main.fxml screen (ex: transitioning into the different screens)
 */

package application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
import application.model.Shop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//Controller class for the main screen
public class MainController implements Initializable {
	
    @FXML private AnchorPane mainPane;	//anchor pane
    @FXML private Label currentUserLabel;	//current user label
    @FXML private Label currencyLabel;	// currency label
    
    //create properties variable for properties class
    private Properties properties = new Properties();
    
    //create object for Shop class
	Shop shopModel = new Shop();
	
	//opens quest board scene when user click on quest board button
    @FXML
    void questBoardHandle(ActionEvent event) throws IOException {
    	URL url = new File("src/QuestBoard.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.setTitle("The Lord of the Chores - Quest Board");
    	window.show();
    }
    
    //opens inventory scene when user click on quest board button
    @FXML
    void inventoryHandle(ActionEvent event) throws IOException {
    	URL url = new File("src/Inventory.fxml").toURI().toURL();
  	   	mainPane = FXMLLoader.load(url);
       	Scene scene = new Scene(mainPane, 800, 800);
       	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
       	window.setScene(scene);
       	window.show();
    }
    
    //opens shop scene when user click on quest board button
    @FXML
    void shopHandle(ActionEvent event) throws IOException {
    	URL url = new File("src/Shop.fxml").toURI().toURL();
   		mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane, 800, 800);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    //display information when screen is open up
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//load current user properties file
		try(FileInputStream inFile = new FileInputStream(new File("currentUser.properties"))) {
			properties.load(inFile);
			inFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Fatal Error: File not found");
			e.printStackTrace();
		}
		catch(IOException e2) {
			System.out.println("Fatal Error: IOException");
			e2.printStackTrace();
		}
		
		//get current user and add to string
		String username = shopModel.getCurrentUser();
		
		//get currency and add to string
		String currency = String.valueOf(shopModel.getCurrency(username));
		
		//display currency
		currencyLabel.setText(currency);
		
		//get the current user
		Enumeration<Object> test = properties.elements();
		
		//display current user
		currentUserLabel.setText("Current User: " + test.nextElement().toString());
	}
}
