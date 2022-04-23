/**
 * Author: Nikhil Kapoor (yct482)
 * File: QuestBoard.java
 * Purpose: holds functions for the QuestBoardController class to use for the Quest Board's functionality
 */

package application.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class QuestBoard {
	
	// Strings and File static objects for the properties class
	private static final String CURRENT_USER_FILE_NAME = "currentUser.properties";
	private static final File CURRENT_USER_FILE_OBJECT = new File(CURRENT_USER_FILE_NAME);
	private final static String INVENTORY_FILE_NAME = "inventory.properties";
	private static final String USER_CURRENCY_FILE_NAME = "userCurrency.properties";
	private static final File USER_CURRENCY_FILE_OBJECT = new File(USER_CURRENCY_FILE_NAME);
	
	private Properties properties = new Properties(); // -properties: Properties
	
	// createQuest: creates a Quest object from a String array
	public Quest createQuest(String[] metadata) {
		String title = metadata[0]; // holds the title
		String diff = metadata[1]; // String var to hold the difficulty
		int rwd = 0; // integer for reward
		
		// switch case for the reward
		switch (metadata[1]) {
		case "Easy":
			rwd = 100;
			break;
		case "Normal":
			rwd = 250;
			break;
		case "Hard":
			rwd = 500;
			break;
		} // end of switch case
		
		return new Quest(title, diff, rwd); // returns a new Quest class object
	} // end of createQuest

	// addCurrency: method for adding rewards to user currency
	public void addCurrency(String username, int amountGained) throws IOException {
		properties.clear();
		
		// try/catch to retrieve the correct user
		try(FileInputStream inFile = new FileInputStream(USER_CURRENCY_FILE_OBJECT)) {
			properties.load(inFile);
			inFile.close();	//close file
		}
		catch(FileNotFoundException e) {
			System.out.println(USER_CURRENCY_FILE_NAME + ": file not found");
		}
		
		// try/catch to add the money to the properties file
		try(FileOutputStream outFile = new FileOutputStream(USER_CURRENCY_FILE_OBJECT, false)) {
			properties.replace(username, String.valueOf(Integer.parseInt((String) properties.get(username)) + amountGained));
			properties.store(outFile, null);
			outFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(INVENTORY_FILE_NAME + ": file not found");
		}
	} // end of addCurrency
} // end of QuestBoard class
