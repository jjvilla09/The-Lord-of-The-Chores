package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import application.model.Shop;

/**
 * @author Joshua Villarreal (uut835)
 *
 */

public class ShopController implements Initializable {
	
	private Shop shopModel = new Shop();
	
	@FXML
    private AnchorPane shopPane;	//pane
	
	@FXML
    private AnchorPane mainPane;	//pane
	
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
    void buyHandle(MouseEvent event) {
    	shopModel.validateAndBuyItem();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		shopModel.readItemsFromFile();
	}
}

