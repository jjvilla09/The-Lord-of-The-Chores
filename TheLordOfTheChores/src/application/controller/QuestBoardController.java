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

public class QuestBoardController {
	
	@FXML
    private AnchorPane questBoardPane;	//pane
	
    @FXML
    void homeHandle(ActionEvent event) throws IOException {
    	//get url file
    	URL url = new File("src/Main.fxml").toURI().toURL();
    	//load pane
    	questBoardPane = FXMLLoader.load(url);
    	//create new scene
    	Scene scene = new Scene(questBoardPane, 800, 800);
    	//set stage
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	//set scene
    	window.setScene(scene);
    	//display scene
    	window.show();
    }

}

