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


    @FXML private AnchorPane mainPane;
    @FXML private Label currentUserLabel;
    @FXML private Label currencyLabel;
    
    //create properties variable for properties class
    private Properties properties = new Properties();
    //create object for Shop class
	Shop shopModel = new Shop();
	
	//opens quest board scene when user click on quest board button
    @FXML
    void questBoardHandle(ActionEvent event) throws IOException {
    	//gets url for quest board
    	URL url = new File("src/QuestBoard.fxml").toURI().toURL();
    	//load pane
    	mainPane = FXMLLoader.load(url);
    	//create scene
    	Scene scene = new Scene(mainPane);
    	//create stage
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	//set scene
    	window.setScene(scene);
    	//set title
    	window.setTitle("The Lord of the Chores - Quest Board");
    	//display scene
    	window.show();
    }
    
    //opens inventory scene when user click on quest board button
    @FXML
    void inventoryHandle(ActionEvent event) throws IOException {
    	//gets url for inventory
    	URL url = new File("src/Inventory.fxml").toURI().toURL();
    	//load pane
  	   	mainPane = FXMLLoader.load(url);
  	   	//create scene
       	Scene scene = new Scene(mainPane, 800, 800);
       	//create stage
       	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
       	//set scene
       	window.setScene(scene);
       	//display scene
       	window.show();
    }
    //opens shop scene when user click on quest board button
    @FXML
    void shopHandle(ActionEvent event) throws IOException {
    	//gets url for shop
    	URL url = new File("src/Shop.fxml").toURI().toURL();
    	//load pane
   		mainPane = FXMLLoader.load(url);
   		//create scene
    	Scene scene = new Scene(mainPane, 800, 800);
    	//create stage
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	//set scene
    	window.setScene(scene);
    	//display scene
    	window.show();
    }
    //display information when screen is open up
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
		
		try {
			String username = shopModel.getCurrentUser();
			String currency = String.valueOf(shopModel.getCurrency(username));
			currencyLabel.setText(currency);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Enumeration<Object> test = properties.elements();
		currentUserLabel.setText("Current User: " + test.nextElement().toString());
	}
}
