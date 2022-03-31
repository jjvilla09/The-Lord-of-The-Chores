package application.controller;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignUpController {

	   @FXML
	   private Label incorrectLogin;

	    @FXML
	    private PasswordField confirmPassword;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private AnchorPane mainPane;

	    @FXML
	    private TextField username;

	    @FXML
	    void haveLoginHandle(ActionEvent event) throws IOException {
	    	//get url file
	    	URL url = new File("src/Login.fxml").toURI().toURL();
	    	//load pane
	    	mainPane = FXMLLoader.load(url);
	    	//create new scene
	    	Scene scene = new Scene(mainPane, 600, 400);
	    	//set stage
	    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	//set scene
	    	window.setScene(scene);
	    	window.setScene(scene);
	    	// QuestBoardBranch: set title
	    	window.setTitle("The Lord of the Chores - Login");
	    	//display scene
	    	window.show();
	    }

	    @FXML
	    void SignUpHandle(ActionEvent event) throws IOException {
	    	//get url file
	    	URL url = new File("src/Login.fxml").toURI().toURL();
	    	//load pane
	    	mainPane = FXMLLoader.load(url);
	    	//create new scene
	    	Scene scene = new Scene(mainPane, 600, 400);
	    	//set stage
	    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	//set scene
	    	window.setScene(scene);
	    	window.setScene(scene);
	    	// QuestBoardBranch: set title
	    	window.setTitle("The Lord of the Chores - Login");
	    	//display scene
	    	window.show();
	    }

}
