/**
 * Author: Isaac Nguyen (rrg053)
 * File: InventoryController.java
 * Purpose: Holds functionality of Inventory.fxml (ex: Listing the items equipped/not equipped)
 */

package application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView helmetIM;	//helmet image
    @FXML
    private ImageView chestIM;	//chest piece image
    @FXML
    private ImageView gauntletsIM;	//guantlet image
    @FXML
    private ImageView legsIM;	//leggings image
    @FXML
    private ImageView bootsIM;	//boots image
    
    @FXML
    private Label equipSuc;// label display that equipment has ben equipped
    
    @FXML
    private Label currencyLabel;//currency label

	@FXML
    private AnchorPane inventoryPane;//anchor pane
	
	private Inventory in = new Inventory();//inventory object 
	
	//home handle those take user back to Home page
    @FXML
    void homeHandle(MouseEvent event) throws IOException {
    	//get main url
    	URL url = new File("src/Main.fxml").toURI().toURL();
    	//get pane
    	inventoryPane = FXMLLoader.load(url);
    	//create scene
    	Scene scene = new Scene(inventoryPane, 800, 800);
    	//create stage
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	//set title
    	window.setTitle("The Lord of the Chores - Homepage");
    	//set scene
    	window.setScene(scene);
    	//display scene
    	window.show();
    }
    //when user clicks on equip it should equip items selected
    @FXML
    void equipItemHandle(ActionEvent event) throws FileNotFoundException{
    	//get equipment selected by user and store them as strings
    	String helmet = helmetList.getSelectionModel().getSelectedItem();
    	String chest = chestList.getSelectionModel().getSelectedItem();
    	String gaunt = gauntList.getSelectionModel().getSelectedItem();
    	String leg = legList.getSelectionModel().getSelectedItem();
    	String boot = bootList.getSelectionModel().getSelectedItem();
    	
    	try {
    		//call equipItem method to equip armor
			in.equipItem(helmet, chest, gaunt, leg, boot);
			//set text when equipment has been equipped
			equipSuc.setText("Equipment has been equipped!");
		//catch for IO exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Image image;
    	String imFile1;
    	String imFile2;
    	String imFile3;
    	String imFile4;
    	String imFile5;
    	if(helmet != null) {
    	imFile1 = "data/" + helmet + ".png";
    	image = new Image(new FileInputStream(imFile1));
		helmetIM.setImage(image);
    	}
    	if(chest != null) {
    		imFile2 = "data/" + chest + ".png";
    		image = new Image(new FileInputStream(imFile2));
			chestIM.setImage(image);
        	}
    	if(gaunt != null) {
    		imFile3 = "data/" + gaunt + ".png";
    		image = new Image(new FileInputStream(imFile3));
    		gauntletsIM.setImage(image);
        	}
    	if(leg != null) {
    		imFile4 = "data/" + leg + ".png";
    		image = new Image(new FileInputStream(imFile4));
			legsIM.setImage(image);
        	}
    	if(boot != null) {
    		imFile5 = "data/" + boot + ".png";
    		image = new Image(new FileInputStream(imFile5));
			bootsIM.setImage(image);
        	}

    }
    //display information when screen is open up
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//clear text
		equipSuc.setText("");
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
		//InputStream imFile = new FileInputStream("data/");
		//helmet.setImage();

	}

}
