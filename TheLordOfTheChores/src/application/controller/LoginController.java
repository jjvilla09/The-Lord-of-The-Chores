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

public class LoginController {

    @FXML
    private PasswordField password;

    @FXML
    private Label incorrectLogin;

    @FXML
    private TextField username;
    
    @FXML
    private AnchorPane mainPane;


    @FXML
    void loginHandle(ActionEvent event) throws IOException {
    	//get url file
    	URL url = new File("src/Main.fxml").toURI().toURL();
    	//load pane
    	mainPane = FXMLLoader.load(url);
    	//create new scene
    	Scene scene = new Scene(mainPane, 800, 800);
    	//set stage
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	//set scene
    	window.setScene(scene);
    	window.setScene(scene);
    	// QuestBoardBranch: set title
    	window.setTitle("The Lord of the Chores - Homepage");
    	//display scene
    	window.show();

    }
    @FXML
    void signUpHandle(ActionEvent event) throws IOException {
    	//get url file
    	URL url = new File("src/SignUp.fxml").toURI().toURL();
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
    	window.setTitle("The Lord of the Chores - Sign Up");
    	//display scene
    	window.show();
    }

}
