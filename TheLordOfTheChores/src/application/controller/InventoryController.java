package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// Controller class for the inventory screen
public class InventoryController implements Initializable{
	
    @FXML
    private ListView<String> helmetList;//list view of helmets
    @FXML
    private ListView<String> chestList;//list view of chest pieces    
    @FXML
    private ListView<String> gauntList;//list view of gauntlets
    @FXML
    private ListView<String> legList;//list view of leggings
    @FXML
    private ListView<String> bootList;//list view of boots
    
    @FXML
    private Label currencyLabel;//currency label

	@FXML
    private AnchorPane inventoryPane;//anchor pane
	
	private Inventory in = new Inventory();//inventory object 
	
	//home handle those take user back to Home page
    @FXML
    void homeHandle(MouseEvent event) throws IOException {
    	URL url = new File("src/Main.fxml").toURI().toURL();
    	inventoryPane = FXMLLoader.load(url);
    	Scene scene = new Scene(inventoryPane, 800, 800);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setTitle("The Lord of the Chores - Homepage");
    	window.setScene(scene);
    	window.show();
    }
    //when user clicks on equip it should equip items selected
    @FXML
    void equipItemHandle(ActionEvent event) {
    	//get equipment selected by user and store them as strings
    	String helmet = helmetList.getSelectionModel().getSelectedItem();
    	String chest = chestList.getSelectionModel().getSelectedItem();
    	String gaunt = gauntList.getSelectionModel().getSelectedItem();
    	String leg = legList.getSelectionModel().getSelectedItem();
    	String boot = bootList.getSelectionModel().getSelectedItem();

    	try {
    		//call equipItem method to equip armor
			in.equipItem(helmet, chest, gaunt, leg, boot);
		//catch for IO exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //display information when screen is open up
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//call update currency to display currency
		in.updateCurrency(currencyLabel);
		try {
			// call getInventory to get inventory 
			in.getInventory(helmetList, chestList, gauntList, legList, bootList);
		// file not found exception catch
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//IO exception catch
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
