/**
 * Author: Nikhil Kapoor (yct482)
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
import application.model.QuestBoard;
import application.model.Shop;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class QuestBoardController implements Initializable {
	
	@FXML private ChoiceBox<String> diffChoice;
	@FXML private TextField questNameTF;
	@FXML private ListView<Quest> questList;
	@FXML private AnchorPane questBoardPane;
	@FXML private ImageView toHomeImage, toHelpImage;
	@FXML private Button createNewQuestButton, completeQuestBtn;
	@FXML private Alert a = new Alert(AlertType.NONE);
	private String[] diff = {"Easy", "Normal", "Hard"};
	QuestBoard qb = new QuestBoard();
	
	// setting up quest ChoiceBox
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		diffChoice.getItems().addAll(diff);
	}
	
    @FXML
    void toHomeHandle(MouseEvent event) throws IOException {
    	if (event.getSource() == toHomeImage) {
    	URL url = new File("src/Main.fxml").toURI().toURL();
    	questBoardPane = FXMLLoader.load(url);
    	Scene scene = new Scene(questBoardPane, 800, 800);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.setTitle("The Lord of the Chores - Homepage");
    	window.show();
    	}
    }
    
    @FXML
    void createNewQuest(ActionEvent event) {
    	if (event.getSource() == createNewQuestButton) {
    		System.out.println("createNewQuestButton pressed");
    		try {
	    		if (questNameTF.getText().isEmpty() || diffChoice.getValue().isEmpty()) {
	    			a.setAlertType(AlertType.ERROR);
	    			a.setContentText("ERROR: One of the two fields isn't complete. Please fill in all "
	    					+ "fields before creating the quest.");
	    			a.showAndWait();
	    		} else {
	    			String[] v = { questNameTF.getText(), diffChoice.getValue() };
	    			questList.getItems().add(qb.createQuest(v));
	    		}
    		}
    		catch(NullPointerException e) {
    			a.setAlertType(AlertType.ERROR);
    			a.setContentText("ERROR: One of the two fields isn't complete. Please fill in all "
    					+ "fields before creating the quest.");
    			a.showAndWait();
    		}
    	} 
    } 
    
    @FXML
    void completeQuest(ActionEvent event) {
    	if (event.getSource() == completeQuestBtn) {
    		System.out.println("completeQuestBtn pressed");
    		if (questList.getItems().isEmpty()) {
    			a.setAlertType(AlertType.ERROR);
    			a.setContentText("ERROR: No quest has been entered. Please create a quest before clicking on this.");
    			a.showAndWait();
    		} 
    		else {
    			int total = 0;
    			for (int i = 0; i < questList.getItems().size(); i++) {
    				total += questList.getItems().get(i).getqReward();
    			}
    			Shop sp = new Shop();
    			String usr = sp.getCurrentUser();
    			qb.addCurrency(usr, total);
    			a.setAlertType(AlertType.INFORMATION);
    			a.setContentText("Congratulations, you've completed " + questList.getItems().size() + " quests! Well done, brave adventurer!");
    			a.showAndWait();
    			questList.getItems().clear();
    		} // end of nested else
    	} // end of if statement
    } // end of completeQuest
    
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
    				+ " should create a quest down at the bottom. You can create as many quests as you like!\n"
    				+ "Step 4: After creating a quest, the right side should display the quest you just created. To actually complete it, "
    				+ "click on the \"Complete Quests\" button and all the quests in the list should be completed, and you will be rewarded the "
    				+ "sum-total of the quests!"
    				+ "\n\nAnd it's as simple as that! Good luck adventuring!");
    		a.showAndWait();
    	}
    }
}

