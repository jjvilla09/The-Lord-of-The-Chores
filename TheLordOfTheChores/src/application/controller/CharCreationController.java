/**
 * Author: Tony Formbly
 * File: CharCreationController.java
 * Purpose: This class controls the Character Creation screen, CharCreation.fxml (Not finished)
 */

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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class CharCreationController {
	

	@FXML private Button orc;
	
	@FXML private Button createNewCharButton;

	@FXML private TextArea text;
	
	@FXML private Button halfling;

	@FXML private AnchorPane charCreationPane;
	
	@FXML private Button human;
	
	@FXML private Button elf;
	
	@FXML private Button wizard;
	
	@FXML private Button dwarf;
	
	@FXML
	void createNewChar(ActionEvent event) throws IOException {
		URL url = new File("src/Login.fxml").toURI().toURL();
		charCreationPane = FXMLLoader.load(url);
		Scene scene = new Scene(charCreationPane, 600, 400);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.setTitle("The Lord of the Chores - Login");
		window.show();
	}
	
	@FXML
	void halflingB(ActionEvent event) {
		text.clear();
		text.appendText("\t\t\tThe Halfling character.\n"
				+ " Choosing to go through life in a carefree manner.\n"
				+ " The Halfing will go about completing task given to \n"
				+ " them, without seeking them out.\n"
				+ " Excelling in short term goals and \n" 
				+ " keeping a very positive outlook on the near future.");
	    }
	
	@FXML
	void humanB(ActionEvent event) {
		text.clear();
		text.appendText("\t\t\tThe Human character.\n"
				+ " Humans are inventice and seeking of greater task.\n"
				+ " They strive to better themselves and their surroundings.\n"
				+ " Hardworking and able to multitask very well.\n Humans have a very"
				+ " high self efficacy."); 
	    }
	
	@FXML
	void elfB(ActionEvent event) {
		text.clear();
		text.appendText("\t\t\tThe Elf character.\n"
				+ " Elves are very calm and examining of situations.\n"
				+ " Wtih a long lifespan they have gained much wisdom and"
				+ " foresight.\n Allowing them to excel in planning and"
				+ " completing long term goals.");
	    }
	
	@FXML
	void orcB(ActionEvent event) {
		text.clear();
		text.appendText("\t\t\tThe Orc character. \n"
				+ " Very single minded and driven.\n"
				+ " The orc will complete any task given to them"
				+ " in a timely manner.\n Not the best at multitasking"
				+ "or planning ahead.\n But very good at taking down one task"
				+ "at a time and completing checklist.");
	    }
	
	@FXML
	void dwarfB(ActionEvent event) {
		text.clear();
		text.appendText("\t\t\tThe Dwarf character. \n"
				+ " Very hard working and diligent in their work.\n"
				+ "Sometimes dwarves are overly determined in their work\n"
				+ "and forget to rest or slowdown on completing task.\n"
				+ " The dwarf excels in group work and cares that the\n"
				+ " overall goal is completed." );
	    }
	
	@FXML
	void wizardB(ActionEvent event) {
		text.clear();
		text.appendText("\t\t\tThe Wizard character. \n"
				+ "Wizards are very unique in the way they view the world\n"
				+ "They set goals that are abstract but helpful to their\n"
				+ "long term goal and overall success. Wizards are wise\n"
				+ "and understand how to use their uniqueness to overcome\n"
				+ "any problems.");
	    }

	}



