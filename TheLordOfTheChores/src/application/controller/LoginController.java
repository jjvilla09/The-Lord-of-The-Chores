/**
 * Author: Isaac Nguyen (rrg053)
 * File: LoginController.java
 * Purpose: Login.fxml functions
 */

package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import application.model.Login;
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

//Controller for the login
public class LoginController {

	@FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Label incorrectLogin;
    @FXML private AnchorPane mainPane;
    
    Login loginModel = new Login();
    
    //handle login when user presses login button
    @FXML
    void loginHandle(ActionEvent event) throws IOException {
    	String user=username.getText();	//get username from user
	    String pass=password.getText();	//get password from user
	    
	    //if login is true then go to Home page
	    if(loginModel.loadLogin(user, pass, incorrectLogin)) {
	    	URL url = new File("src/Main.fxml").toURI().toURL();
	    	mainPane = FXMLLoader.load(url);
	    	Scene scene = new Scene(mainPane, 800, 800);
	    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	window.setScene(scene);
	    	window.setTitle("The Lord of the Chores - Homepage");
	    	window.show();    	 
	    }
    }
    
    //sign up handle when user presses sign up button
    @FXML
    void signUpHandle(ActionEvent event) throws IOException {
    	URL url = new File("src/SignUp.fxml").toURI().toURL();
    	mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane, 600, 400);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.setTitle("The Lord of the Chores - Sign Up");
    	window.show();
    }

}
