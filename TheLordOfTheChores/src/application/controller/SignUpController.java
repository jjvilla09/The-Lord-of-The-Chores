/**
 * Author: Isaac Nguyen (rrg053)
 * File: LoginController.java
 * Purpose: SignUp.fxml functions
 */

package application.controller;

import java.io.File;
import java.io.IOException;
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

// controller for sign up
public class SignUpController {
	
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private PasswordField confirmPassword;
    @FXML private Label invalid;
	@FXML private AnchorPane mainPane;
	private SignUp signUpModel = new SignUp();

	//handle for login if user presses login button
	@FXML
	void haveLoginHandle(ActionEvent event) throws IOException {
		URL url = new File("src/Login.fxml").toURI().toURL();
		mainPane = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane, 600, 400);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.setTitle("The Lord of the Chores - Login");
		window.show();
	}
	
	//handle for sign up if user presses sign up button
	@FXML
	void SignUpHandle(ActionEvent event) throws IOException {
		String user=username.getText();	//get username from user
	    String pass=password.getText();	//get password from user
	    String confirmpass=confirmPassword.getText();	//get confirmed password from user
	    
	    //if login is correct go to character creation screen
	    if(signUpModel.loadSignUp(user, pass, confirmpass, invalid)) {
	    	URL url = new File("src/CharCreation.fxml").toURI().toURL();
    		mainPane = FXMLLoader.load(url);
    		Scene scene = new Scene(mainPane, 800, 800);
    		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		window.setScene(scene);
    		window.setTitle("The Lord of the Chores - Character Creation");
    		window.show();
	    }
	}
}
