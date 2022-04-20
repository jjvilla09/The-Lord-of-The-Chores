package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import application.model.Inventory;
import application.model.Shop;
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

public class InventoryController implements Initializable{
	

    @FXML
    private ListView<String> chestList;

    @FXML
    private ListView<String> legList;

    @FXML
    private ListView<String> helmetList;

    @FXML
    private ListView<String> bootList;

    @FXML
    private Label currencyLabel;
	@FXML
    private AnchorPane inventoryPane;	//pane
	
	private Inventory in = new Inventory();
	
    @FXML
    void homeHandle(MouseEvent event) throws IOException {
    	URL url = new File("src/Main.fxml").toURI().toURL();
    	inventoryPane = FXMLLoader.load(url);
    	Scene scene = new Scene(inventoryPane, 800, 800);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setTitle("The Lord of the Chores - Login");
    	window.setScene(scene);
    	window.show();
    }
    @FXML
    void equipItemHandle(ActionEvent event) {
    	String helmet = helmetList.getSelectionModel().getSelectedItem();
    	String chest = chestList.getSelectionModel().getSelectedItem();
    	String leg = legList.getSelectionModel().getSelectedItem();
    	String boot = bootList.getSelectionModel().getSelectedItem();
    	try {
			in.equipItem(helmet, chest, leg, boot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		in.updateCurrency(currencyLabel);
		try {
			in.getInventory(helmetList, chestList, legList, bootList);
	    	chestList.getSelectionModel().getSelectedItem();
	    	helmetList.getSelectionModel().getSelectedItem();
	    	legList.getSelectionModel().getSelectedItem();
	    	bootList.getSelectionModel().getSelectedItem();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
