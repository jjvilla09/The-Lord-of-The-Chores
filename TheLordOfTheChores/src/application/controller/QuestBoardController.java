/**
 * Creator: Nikhil Kapoor (yct482)
 * File: QuestBoardController.java
 * Purpose: Controls the Quest Board scene, using QuestBoard class objects to allow
 * users to create quests, complete them, and receive rewards.
 */
package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.Quest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class QuestBoardController implements Initializable {
	
	@FXML
    private ChoiceBox<String> diffChoice; // -diffChoice: ChoiceBox<String>
	
	@FXML
    private TextField questNameTF; // -questNameTF: TextField
	
	@FXML
    private AnchorPane questBoardPane;	// -questBoardPane: AnchorPane
	
	@FXML
    private ImageView toHomeImage, toHelpImage; // -toHomeImage, -toHelpImage: ImageView
	
	@FXML
    private Button createNewQuestButton; // -createNewQuestButton: Button
	
	@FXML
	private Alert a = new Alert(AlertType.NONE); // -a: Alert
	
	private String[] diff = {"Easy", "Normal", "Hard"};
	
	// setting up quest ChoiceBox
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		diffChoice.getItems().addAll(diff);
	}
	
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
    		
    		System.out.println("createNewQuestButton pressed");
    		if (questNameTF.getText().isEmpty()) {
    			a.setAlertType(AlertType.ERROR);
    			a.setContentText("ERROR: One of the two fields isn't complete. Please fill in all "
    					+ "fields before creating the quest.");
    			a.showAndWait();
    		}
    	}
    }
    
    @FXML
    void handleHelp(MouseEvent event) {
    	if (event.getSource() == toHelpImage) {
    		System.out.println("toHelpImage pressed");
    		a.setAlertType(AlertType.INFORMATION);
    		a.setContentText("The main goal of The Lord of the Chores is to encourage gamers to take up\n"
    				+ "any hobbies or daily goals to improve both physical and mental health. Here, at TLOTC Inc.,\n"
    				+ "we want the user to create their own quests to better encourage completion.\n\n"
    				+ "HOW TO:\n"
    				+ "Step 1: Enter the Title of the Quest. It can be anything.\n"
    				+ "Step 2: Select a difficulty, from Easy, Medium, and Hard. The difficulty determines"
    				+  " the amount of Gold obtained from completing the quest.\n"
    				+ "Step 3: Press the Create New Quest button after filling in these two fields and the quest"
    				+ " should create a quest down at the bottom. You can only create one quest at a time, so don't"
    				+ " try and double-dip!\n"
    				+ "\n\nHappy Trails!");
    		a.showAndWait();
    	}
    }

}

