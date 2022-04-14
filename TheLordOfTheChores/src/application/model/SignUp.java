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
	//private HashMap<String, String> currentUser = new HashMap<String, String>();
	//private static HashMap<String, String> inventory = new HashMap<String, String>();
	private static Properties properties = new Properties();
	//private static Properties properties2 = new Properties();
	
	// -------------- FILE STUFF -------------- //
	private static final String USER_PASSWORD_FILE_NAME = "userPassword.properties";
	private static final String INVENTORY_FILE_NAME = "inventory.properties";
	private static final String USER_CURRENCY_FILE_NAME = "userCurrency.properties";
	private static final File USER_PASSWORD_FILE_OBJECT = new File(USER_PASSWORD_FILE_NAME);
	private static final File INVENTORY_FILE_OBJECT = new File(INVENTORY_FILE_NAME);
	private static final File USER_CURRENCY_FILE_OBJECT = new File(USER_CURRENCY_FILE_NAME);
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
		
		try(FileInputStream inFile = new FileInputStream(USER_PASSWORD_FILE_OBJECT)) {
			properties.load(inFile);
			
			// Put objects from properties file into a locally created HashMap
			for(String keys : properties.stringPropertyNames()) {
				userPassHashMap.put(keys, properties.get(keys).toString());
			}
		}
		catch(FileNotFoundException e) {
			System.out.println(USER_PASSWORD_FILE_NAME + ": file does not exist");
		}
		
		// Validate Credentials
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
		initializeCredentials(username, password);
		initializeStarterGear(username);
		initializeCurrency(username);
		
		return true;
	}
	
	private void initializeCredentials(String username, String password) throws IOException {
		try(FileOutputStream outFile = new FileOutputStream(USER_PASSWORD_FILE_OBJECT, false)) {
			userPassHashMap.put(username, password);
			properties.putAll(userPassHashMap);
			properties.store(outFile, null);
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void initializeCurrency(String username) throws IOException {
		properties.clear(); // Starts from scratch
		
		try(FileInputStream inFile = new FileInputStream(USER_CURRENCY_FILE_OBJECT)) {
			properties.load(inFile); // Load file data
		}
		catch(FileNotFoundException e) {
			System.out.println(USER_CURRENCY_FILE_NAME + ": file does not exist");
		}
		
		properties.put(username, "0"); // put username into hashmap and initialize it to 0
		
		try(FileOutputStream outFile = new FileOutputStream(USER_CURRENCY_FILE_OBJECT, false)) {
			properties.store(outFile, null); // Store the hashmap into the userCurrency.properties file
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void initializeStarterGear(String username) throws IOException{
		properties.clear(); // Starts from scratch
		
		try(FileInputStream inFile = new FileInputStream(INVENTORY_FILE_OBJECT)) {
			properties.load(inFile); // Load file data	
		}
		catch(FileNotFoundException e) {
			System.out.println(INVENTORY_FILE_NAME + ": File does not exist");
		}
		
		properties.put(username, STARTER_KIT); // Store armor into hashmap
		
		try(FileOutputStream outFile = new FileOutputStream(INVENTORY_FILE_OBJECT, false)) {
			properties.store(outFile, null); // Store in properties file
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
