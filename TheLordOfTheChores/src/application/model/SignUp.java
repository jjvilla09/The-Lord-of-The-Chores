/**
 * Author: Joshua Villarreal (uut835)
 * File: SignUp.java
 * Purpose: Holds logical operations to be used in SignUp.fxml
 */

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
	private static Properties properties = new Properties();
	
	// -------------- FILE NAMES -------------- //
	private static final String USER_PASSWORD_FILE_NAME = "userPassword.properties";
	private static final String ITEMS_EQUIPPED_FILE_NAME = "itemsEquipped.properties";
	private static final String USER_CURRENCY_FILE_NAME = "userCurrency.properties";
	private static final String INVENTORY_FILE_NAME = "inventory.properties";
	
	// -------------- FILE OBJECTS -------------- //
	private static final File INVENTORY_FILE_OBJECT = new File(INVENTORY_FILE_NAME);
	private static final File USER_PASSWORD_FILE_OBJECT = new File(USER_PASSWORD_FILE_NAME);
	private static final File ITEMS_EQUIPPED_FILE_OBJECT = new File(ITEMS_EQUIPPED_FILE_NAME);
	private static final File USER_CURRENCY_FILE_OBJECT = new File(USER_CURRENCY_FILE_NAME);
	
	// -------------- STARTER ITEMS -------------- //
	private static final String STARTER_KIT = "NONE,StarterChestArmor v2,NONE,StarterLeggings v2,NONE";
	private static final String STARTER_INVENTORY = "StarterChestArmor v2,StarterLeggings v2";
	
	/**
	 * Loads the user input (username and password) into a file using Properties
	 * if the username is not registered already and passwords match, then return true.
	 * Otherwise, return false.
	 * 
	 * @throws IOException
	 */
	public boolean loadSignUp(String username, String password, String confirmPassword, Label invalidTextBox) {
		// null/empty check
		if( 	username == null || username.isEmpty() || 
				password == null || password.isEmpty() || 
				confirmPassword == null || confirmPassword.isEmpty()) {
			invalidTextBox.setText("Username and/or password cannot be empty");
			return false;
		}
		
		try(FileInputStream inFile = new FileInputStream(USER_PASSWORD_FILE_OBJECT)) {
			properties.load(inFile);
			inFile.close();
			
			// Put objects from properties file into a locally created HashMap
			for(String keys : properties.stringPropertyNames()) {
				userPassHashMap.put(keys, properties.get(keys).toString());
			}
		}
		catch(FileNotFoundException e) {
			System.out.println(USER_PASSWORD_FILE_NAME + ": file does not exist");
		}
		catch(IOException e2) {
			System.out.println(USER_PASSWORD_FILE_NAME + ": io exception found");
			e2.printStackTrace();
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
		initializeInventory(username);
		
		return true;
	}
	
	/**
	 * initializes credentials in the file "userPassword.properties"
	 * 
	 * @param username
	 * @param password
	 */
	private void initializeCredentials(String username, String password) {
		
		try(FileOutputStream outFile = new FileOutputStream(USER_PASSWORD_FILE_OBJECT, false)) {
			userPassHashMap.put(username, password);
			properties.putAll(userPassHashMap);
			properties.store(outFile, null);
			outFile.close();
		} catch (FileNotFoundException e) {
			System.out.println(USER_PASSWORD_FILE_NAME + ": file not found");
		}
		catch(IOException e2) {
			System.out.println(USER_PASSWORD_FILE_NAME + ": io exception found");
			e2.printStackTrace();
		}
	}
	
	/**
	 * initializes currency in the file "userCurrency.properties"
	 * 
	 * @param username
	 */
	private void initializeCurrency(String username) {
		properties.clear(); // Starts from scratch
		
		try(FileInputStream inFile = new FileInputStream(USER_CURRENCY_FILE_OBJECT)) {
			properties.load(inFile); // Load file data
			inFile.close();	//close file
		}
		catch(FileNotFoundException e) {
			System.out.println(USER_CURRENCY_FILE_NAME + ": file does not exist");
		}
		catch(IOException e2) {
			System.out.println(USER_CURRENCY_FILE_NAME + ": io exception found");
			e2.printStackTrace();
		}
		
		properties.put(username, "0"); // put username into hashmap and initialize it to 0
		
		try(FileOutputStream outFile = new FileOutputStream(USER_CURRENCY_FILE_OBJECT, false)) {
			properties.store(outFile, null); // Store the hashmap into the userCurrency.properties file
			outFile.close();
		} catch(FileNotFoundException e) {
			System.out.println(USER_CURRENCY_FILE_NAME + ": file not found");
		}
		catch(IOException e2) {
			System.out.println(USER_CURRENCY_FILE_NAME + ": io exception found");
			e2.printStackTrace();
		}
	}

	/**
	 * initializes credentials in the file "itemsEquipped.properties"
	 * 
	 * @param username
	 * @throws IOException
	 */
	public static void initializeStarterGear(String username) {
		properties.clear(); // Starts from scratch
		
		try(FileInputStream inFile = new FileInputStream(ITEMS_EQUIPPED_FILE_OBJECT)) {
			properties.load(inFile); // Load file data	
			inFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(ITEMS_EQUIPPED_FILE_NAME + ": file does not exist");
		}
		catch(IOException e2) {
			System.out.println(ITEMS_EQUIPPED_FILE_NAME + ": io exception found");
		}
		
		properties.put(username, STARTER_KIT); // Store armor into hashmap
		
		try(FileOutputStream outFile = new FileOutputStream(ITEMS_EQUIPPED_FILE_OBJECT, false)) {
			properties.store(outFile, null); // Store in properties file
			outFile.close();
		} catch (FileNotFoundException e) {
			System.out.println(ITEMS_EQUIPPED_FILE_NAME + ": file not found");
		}
		catch(IOException e2) {
			System.out.println(ITEMS_EQUIPPED_FILE_NAME + ": io exception found");
			e2.printStackTrace();
		}
	}
	
	/**
	 * initializes inventory in the file "inventory.properties"
	 * 
	 * @param username
	 * @throws IOException
	 */
	public static void initializeInventory(String username) {
		properties.clear(); // Starts from scratch
		
		try(FileInputStream inFile = new FileInputStream(INVENTORY_FILE_OBJECT)) {
			properties.load(inFile); // Load file data	
			inFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(INVENTORY_FILE_NAME + ": file does not exist");
		}
		catch(IOException e2) {
			System.out.println(INVENTORY_FILE_NAME + ": io exception found");
			e2.printStackTrace();
		}
		
		properties.put(username, STARTER_INVENTORY); // Store armor into hashmap
		
		try(FileOutputStream outFile = new FileOutputStream(INVENTORY_FILE_OBJECT, false)) {
			properties.store(outFile, null); // Store in properties file
			outFile.close();
		} catch (FileNotFoundException e) {
			System.out.println(INVENTORY_FILE_NAME + ": file not found");
		}
		catch(IOException e2) {
			System.out.println(INVENTORY_FILE_NAME + ": io exception found");
			e2.printStackTrace();
		}
	}
}
