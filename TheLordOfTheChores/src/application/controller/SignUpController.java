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

public class SignUpController {
	
	private SignUp signUpModel = new SignUp();
	@FXML private TextField username;
	@FXML private PasswordField password;	
	@FXML private PasswordField confirmPassword;	
    @FXML private Label invalid;
	@FXML private AnchorPane mainPane;

	@FXML
	void haveLoginHandle(ActionEvent event) throws IOException {
		URL url = new File("src/Login.fxml").toURI().toURL();
		mainPane = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane, 600, 400);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.setScene(scene);
		window.setTitle("The Lord of the Chores - Login");
		window.show();
	}

	@FXML
	void SignUpHandle(ActionEvent event) throws IOException {
		String user=username.getText();
	    String pass=password.getText();
	    String confirmpass=confirmPassword.getText();
	    
	    if(signUpModel.loadSignUp(user, pass, confirmpass, invalid)) {
	    	URL url = new File("src/Login.fxml").toURI().toURL();
    		mainPane = FXMLLoader.load(url);
    		Scene scene = new Scene(mainPane, 600, 400);
    		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		window.setScene(scene);
    		window.setScene(scene);
    		window.setTitle("The Lord of the Chores - Login");
    		window.show();
	    }
	}
}
