package application.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javafx.scene.control.Label;

public class SignUp {
	private HashMap<String, String> userPassHashMap = new HashMap<String,String>();
	private static HashMap<String, String> inventory = new HashMap<String, String>();
	private static Properties properties = new Properties();
	// -------------- FILE STUFF -------------- //
	private static final String USER_PASSWORD_FILE_NAME = "userPass.properties";
	private static final String INVENTORY_FILE_NAME = "inventory.properties";
	private static final File USER_PASSWORD_FILE_OBJECT = new File(USER_PASSWORD_FILE_NAME);
	private static final File INVENTORY_FILE_OBJECT = new File(INVENTORY_FILE_NAME);
	private static final String STARTER_KIT = "NONE,StarterChestpiece,NONE,StarterLeggings,NONE";
	
	
	/**
	 * Loads the user input (username and password) into a file using Properties
	 * if the username is not registered already and passwords match, then return true.
	 * Otherwise, return false.
	 * 
	 * @throws IOException
	 */
	public boolean loadSignUp(String username, String password, String confirmPassword, Label invalidTextBox) throws IOException {
		// null/empty check
		if( 	username == null || username.isEmpty() || 
				password == null || password.isEmpty() || 
				confirmPassword == null || confirmPassword.isEmpty()) {
			invalidTextBox.setText("Username and/or password cannot be empty");
			return false;
		}
		
		try {
			properties.load(new FileInputStream(USER_PASSWORD_FILE_OBJECT));
		}
		catch(FileNotFoundException e) {
			System.out.println("File does not exist");
		}
		
		// Put objects from properties file into a locally created HashMap
		for(String keys : properties.stringPropertyNames()) {
			userPassHashMap.put(keys, properties.get(keys).toString());
		}
		
		if(userPassHashMap.containsKey(username)) {
			invalidTextBox.setText("Username already exists");
			return false;
		} else 
		if(!password.equals(confirmPassword)) {
			invalidTextBox.setText("Passwords do not match");
			return false;
		}
		
		// All checks out
		// Store the username and password into the userPass.properties file. return true.
		userPassHashMap.put(username, password);
		properties.putAll(userPassHashMap);
		
		try(FileOutputStream outFile = new FileOutputStream(USER_PASSWORD_FILE_OBJECT, true)) {
			properties.store(outFile, null);
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		initializeStarterGear(username);
		
		return true;
	}
	
	public static void initializeStarterGear(String username) throws IOException{
		try(FileOutputStream outFile = new FileOutputStream(INVENTORY_FILE_OBJECT, true)) {
			inventory.put(username, STARTER_KIT);
			properties.putAll(inventory);
			properties.store(outFile, null);
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
