package application.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javafx.scene.control.Label;

public class Login {
	private HashMap<String, String> userPassHashMap = new HashMap<>();
	private static HashMap<String,String> currUser = new HashMap<>();
	private static Properties properties = new Properties();
	//private static Properties properties2 = new Properties();
	//public ArrayList<Login> login =new ArrayList<Login>();
	
	// -------------- FILE STUFF -------------- //
	private static final String USER_PASSWORD_FILE_NAME = "userPassword.properties";
	private static final String CURRENT_USER_FILE_NAME = "currentUser.properties";
	private static final File CURRENT_USER_FILE_OBJECT = new File(CURRENT_USER_FILE_NAME);
	private static final File USER_PASSWORD_FILE_OBJECT = new File(USER_PASSWORD_FILE_NAME);
	
	/**
	 * Loads the user input (username and password) into a file using Properties
	 * if the username and password is NOT null or empty.
	 * 
	 * @throws IOException
	 */
	public boolean loadLogin(String username, String password, Label incorrectLogin) throws IOException {
		
		// null/empty check
		if( username == null || username.isEmpty() || password == null || password.isEmpty()) {
			incorrectLogin.setText("Username and/or password cannot be empty");
			return false;
		}
		
		try(FileInputStream inFile = new FileInputStream(USER_PASSWORD_FILE_OBJECT)) {
			properties.load(inFile);
			
			// Put objects from properties file into a locally created HashMap
			for(String keys : properties.stringPropertyNames()) {
				userPassHashMap.put(keys, properties.get(keys).toString());
			}
			
			inFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(USER_PASSWORD_FILE_NAME + ": file does not exist");
		}
		
		// Check that the username and password are correct
		if(userPassHashMap.containsKey(username)) {
			if(userPassHashMap.get(username).equals(password)) {
				initializeCurrentUser(username); // Place the user in the currentUser.properties file
				return true;
			} else {
				incorrectLogin.setText("Incorrect passowrd");
				return false;
			}
		}
		
		incorrectLogin.setText("Username does not exist");
		return false;
	}
	
	/**
	 * Place the username into the currentUser.properties file.
	 * 
	 * @param username
	 * @throws IOException
	 */
	public static void initializeCurrentUser(String username) throws IOException {
		properties.clear(); // properties HashMap still contains the mappings from userPassword.properties (on Line 42), so we must clear it. 
		try(FileOutputStream outFile = new FileOutputStream(CURRENT_USER_FILE_OBJECT, false)) {
			currUser.put(username, username);
			properties.putAll(currUser);
			properties.store(outFile, null);
			outFile.close();
		} catch (FileNotFoundException e) {
			System.out.println(CURRENT_USER_FILE_NAME + ": file not found");
			e.printStackTrace();
		}
	}
}
