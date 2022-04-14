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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import application.model.Shop;

/**
 * @author Joshua Villarreal (uut835)
 *
 */

public class ShopController implements Initializable {
	
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
    void buyKnightChestpieceHandle(MouseEvent event) throws IOException {
    	shopModel.buyKnightChestpiece();
    }

    @FXML
    void buyKnightBootsHandle(MouseEvent event) throws FileNotFoundException, IOException {
    	shopModel.buyKnightBoots();
    }

    @FXML
    void buyKnightHelmetHandle(MouseEvent event) throws FileNotFoundException, IOException {
    	shopModel.buyKnightHelmet();
    }

    @FXML
    void buyKnightLeggingsHandle(MouseEvent event) throws FileNotFoundException, IOException {
    	shopModel.buyKnightLeggings();
    }

    @FXML
    void buyMercenaryChestpieceHandle(MouseEvent event) throws FileNotFoundException, IOException {
    	shopModel.buyMercenaryChestpiece();
    }

    @FXML
    void buySpartanHelmetHandle(MouseEvent event) throws FileNotFoundException, IOException {
    	shopModel.buySpartanHelmet();
    }

    @FXML
    void soldOutHandle(MouseEvent event) {
    	shopModel.showSoldOutMessage();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			String username = shopModel.getCurrentUser();
			String currency = String.valueOf(shopModel.getCurrency(username));
			currencyLabel.setText(currency);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

