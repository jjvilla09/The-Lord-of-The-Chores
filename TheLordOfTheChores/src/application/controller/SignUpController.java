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
	
	@FXML private TextField username;	//username textfield
	@FXML private PasswordField password;	//password passwordfield	
	@FXML private PasswordField confirmPassword;	//confirmation password passwordfield
	
    @FXML private Label invalid;	//invalid label
    
	@FXML private AnchorPane mainPane;	//anchor pane
	
	private SignUp signUpModel = new SignUp();	//sign up object for SignUp class

	//handle for login if user presses login button
	@FXML
	void haveLoginHandle(ActionEvent event) throws IOException {
		//get login url
		URL url = new File("src/Login.fxml").toURI().toURL();
		//load pane
		mainPane = FXMLLoader.load(url);
		//create scene
		Scene scene = new Scene(mainPane, 600, 400);
		//create stage
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		//set scene
		window.setScene(scene);
		//set title
		window.setTitle("The Lord of the Chores - Login");
		//display scene
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
	    	//get character creation url
	    	URL url = new File("src/CharCreation.fxml").toURI().toURL();
	    	//load pane
    		mainPane = FXMLLoader.load(url);
    		//create scene
    		Scene scene = new Scene(mainPane, 800, 800);
    		//create stage
    		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		//set scene
    		window.setScene(scene);
    		//set title
    		window.setTitle("The Lord of the Chores - Character Creation");
    		//display scene
    		window.show();
	    }
	}
}
