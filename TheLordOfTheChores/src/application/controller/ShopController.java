/**
 * Author: Joshua Villarreal (uut835)
 * File: ShopController.java
 * Purpose: Holds functions to be used for Shop.fxml (ex: dynamically updating the user's currency after buying items)
 */

package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import application.model.Shop;

/**
 * @author Joshua Villarreal (uut835)
 *
 */

public class ShopController implements Initializable {
	
	Alert a = new Alert(null);
	private Shop shopModel = new Shop();
	@FXML private AnchorPane shopPane;	//pane
	@FXML private AnchorPane mainPane;	//pane
	@FXML private Label currencyLabel;

	
    @FXML
    void homeHandle(MouseEvent event) throws IOException {
    	URL url = new File("src/Main.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane, 800, 800);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setTitle("The Lord of the Chores - Login");
    	window.setScene(scene);
    	window.show();
    }
    
    @FXML
    void handleHelp(MouseEvent event) {
		System.out.println("toHelpImage pressed");
		a.setAlertType(AlertType.INFORMATION);
		
		a.setContentText("The main goal of The Lord of the Chores is to encourage gamers to take up"
				+ "any hobbies or daily goals to improve both physical and mental health. \n\n"
				+ "This is the shop. After completing enough quests, purchase items with the gold earned"
				+ "to customize your character.\n\n"
				+ "HOW TO:\n"
				+ "Step 1: Complete quests.\n"
				+ "Step 2: Earn enough gold to buy some gear. The higher the rarity, the better! (and the more "
				+ "expensive...).\n"
				+ "Step 3: Equip the cool looking gear you just bought in the inventory screen."
				+ "\n\nAnd that's it! See you around adventurer!");
		a.showAndWait();
    	
    }
    
    @FXML
    void buyKnightChestpieceHandle(MouseEvent event) throws IOException {
    	shopModel.buyKnightChestpiece(currencyLabel);
    }

    @FXML
    void buyKnightBootsHandle(MouseEvent event) throws FileNotFoundException, IOException {
    	shopModel.buyKnightBoots(currencyLabel);
    }

    @FXML
    void buyKnightHelmetHandle(MouseEvent event) throws FileNotFoundException, IOException {
    	shopModel.buyKnightHelmet(currencyLabel);
    }

    @FXML
    void buyKnightLeggingsHandle(MouseEvent event) throws FileNotFoundException, IOException {
    	shopModel.buyKnightLeggings(currencyLabel);
    }

    @FXML
    void buyMercenaryChestpieceHandle(MouseEvent event) throws FileNotFoundException, IOException {
    	shopModel.buyMercenaryChestpiece(currencyLabel);
    }

    @FXML
    void buySpartanHelmetHandle(MouseEvent event) throws FileNotFoundException, IOException {
    	shopModel.buySpartanHelmet(currencyLabel);
    }

    @FXML
    void soldOutHandle(MouseEvent event) {
    	shopModel.showSoldOutMessage();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		shopModel.updateCurrency(currencyLabel);
	}
}

