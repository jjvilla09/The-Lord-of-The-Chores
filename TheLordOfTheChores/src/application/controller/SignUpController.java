package application.controller;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import application.model.SignUp;
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
	private TextField username;
	
	@FXML
	private PasswordField password;	
	
	@FXML
	private PasswordField confirmPassword;	
	
    @FXML
    private Label invalid;

	@FXML
	private AnchorPane mainPane;

	

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
		
		String user=username.getText();
	    String pass=password.getText();
	    String confirmpass=confirmPassword.getText();
	    invalid.setText("");
	    if(user.equals(null) || user.isEmpty() ||pass.equals(null) || pass.isEmpty()) {
	    	invalid.setText("complete sign up");
	    }
	    else {
	    	if(pass.equals(confirmpass))
	    	{
	    		SignUp su = new SignUp(user,pass);
	    		su.storePassword();
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
	    	else
	    	{
	    		invalid.setText("password does not match");	
	    	}
	    }

	}

}
