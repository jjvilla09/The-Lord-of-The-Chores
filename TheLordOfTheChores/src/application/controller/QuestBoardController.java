package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class QuestBoardController {
	
	@FXML
    private AnchorPane questBoardPane;	// -questBoardPane: AnchorPane
	
	@FXML
    private ImageView toHomeImage; // -toHomeImage: ImageView
	
	@FXML
    private Button createNewQuestButton; // -createNewQuestButton: Button
	
    @FXML
    void toHomeHandle(MouseEvent event) throws IOException {
    	if (event.getSource() == toHomeImage) {
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
    	//window.setScene(scene);
    	// QuestBoardBranch: set title
    	window.setTitle("The Lord of the Chores - Homepage");
    	//display scene
    	window.show();
    	}
    }

    @FXML
    void createNewQuest(ActionEvent event) {
    	if (event.getSource() == createNewQuestButton) {
    		System.out.println("Hey look at me!");
    	}
    }

}

