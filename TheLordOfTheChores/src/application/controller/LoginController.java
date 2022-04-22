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

	@FXML private TextField username;// username textfield
    @FXML private PasswordField password;// password passwordfield
    @FXML private Label incorrectLogin;// incorrect login label
    @FXML private AnchorPane mainPane;// anchor pane
    
    Login loginModel = new Login();// object for Login class
    
    //handle login when user presses login button
    @FXML
    void loginHandle(ActionEvent event) throws IOException {
    	String user=username.getText();	//get username from user
	    String pass=password.getText();	//get password from user
	    
	    //if login is true then go to Home page
	    if(loginModel.loadLogin(user, pass, incorrectLogin)) {
	    	//get main url
	    	URL url = new File("src/Main.fxml").toURI().toURL();
	    	//load pane
	    	mainPane = FXMLLoader.load(url);
	    	//create scene
	    	Scene scene = new Scene(mainPane, 800, 800);
	    	//create stage
	    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	//set scene
	    	window.setScene(scene);
	    	//set title
	    	window.setTitle("The Lord of the Chores - Homepage");
	    	//display scene
	    	window.show();    	 
	    }
    }
    
    //sign up handle when user presses sign up button
    @FXML
    void signUpHandle(ActionEvent event) throws IOException {
    	//get sign up url
    	URL url = new File("src/SignUp.fxml").toURI().toURL();
    	//load pane
    	mainPane = FXMLLoader.load(url);
    	//create scene
    	Scene scene = new Scene(mainPane, 600, 400);
    	//create stage
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	//set scene
    	window.setScene(scene);
    	//set title
    	window.setTitle("The Lord of the Chores - Sign Up");
    	//display scene
    	window.show();
    }

}
