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
public class InventoryController implements Initializable {
	
    @FXML private ListView<String> helmetList;
    @FXML private ListView<String> chestList;    
    @FXML private ListView<String> gauntList;
    @FXML private ListView<String> legList;
    @FXML private ListView<String> bootList;
    @FXML private ImageView helmetIM;
    @FXML private ImageView chestIM;
    @FXML private ImageView gauntletsIM;
    @FXML private ImageView legsIM;
    @FXML private ImageView bootsIM;
    @FXML private Label equipSuc;
    @FXML private Label currencyLabel;
	@FXML private AnchorPane inventoryPane;
	private Inventory in = new Inventory();
	
	// home handle those take user back to Home page
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
    
    // when user clicks on equip it should equip items selected
    @FXML
    void equipItemHandle(ActionEvent event) throws FileNotFoundException{
    	//get equipment selected by user and store them as strings
    	String helmet = helmetList.getSelectionModel().getSelectedItem();
    	String chest = chestList.getSelectionModel().getSelectedItem();
    	String gaunt = gauntList.getSelectionModel().getSelectedItem();
    	String leg = legList.getSelectionModel().getSelectedItem();
    	String boot = bootList.getSelectionModel().getSelectedItem();
    	
    	
		// call equipItem method to equip armor
		in.equipItem(helmet, chest, gaunt, leg, boot);
		// set text when equipment has been equipped
		equipSuc.setText("Equipment has been equipped!");
		
    	Image image;	//image class
    	String imFile1;	// helmet file
    	String imFile2;	//chest piece file
    	String imFile3;	//gauntlet file
    	String imFile4;	//legging file
    	String imFile5;	//boots
    	
    	//if helmet is not empty get image
    	if(helmet != null) {
	    	imFile1 = "data/" + helmet + ".png";
	    	image = new Image(new FileInputStream(imFile1));
			helmetIM.setImage(image);
    	}  	
    	//if chest piece is not empty get image
    	if(chest != null) {
    		imFile2 = "data/" + chest + ".png";
    		image = new Image(new FileInputStream(imFile2));
			chestIM.setImage(image);
        }
    	//if gauntlets are not empty get image
    	if(gaunt != null) {
    		imFile3 = "data/" + gaunt + ".png";
    		image = new Image(new FileInputStream(imFile3));
    		gauntletsIM.setImage(image);
        }
    	//if leggings are not empty get image
    	if(leg != null) {
    		imFile4 = "data/" + leg + ".png";
    		image = new Image(new FileInputStream(imFile4));
			legsIM.setImage(image);
        }
    	//if boots are not empty get image
    	if(boot != null) {
    		imFile5 = "data/" + boot + ".png";
    		image = new Image(new FileInputStream(imFile5));
			bootsIM.setImage(image);
        }
    }
    
    //display information when screen is open up
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		equipSuc.setText("");
		in.updateCurrency(currencyLabel);
		in.getInventory(helmetList, chestList, gauntList, legList, bootList);
	}

}
