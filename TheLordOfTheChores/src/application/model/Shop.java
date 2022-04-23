/**
 * Author: Joshua Villarreal (uut835)
 * File: Shop.java
 * Purpose: Model for ShopController: holds logic functions for ShopController (updating the user.txt file with 
 * 			equipment, storing information about the user's currency, etc.)
 */

package application.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 * Shop.java contains all the logical operations used in ShopController.java.
 * 
 * @author Joshua Villarreal (uut835)
 */

public class Shop {
	private static final String CURRENT_USER_FILE_NAME = "currentUser.properties";
	private static final File CURRENT_USER_FILE_OBJECT = new File(CURRENT_USER_FILE_NAME);
	private final static String INVENTORY_FILE_NAME = "inventory.properties";
	private final static File INVENTORY_FILE_OBJECT = new File(INVENTORY_FILE_NAME);
	private static final String USER_CURRENCY_FILE_NAME = "userCurrency.properties";
	private static final File USER_CURRENCY_FILE_OBJECT = new File(USER_CURRENCY_FILE_NAME);
	Alert a = new Alert(Alert.AlertType.WARNING);
	Alert a2 = new Alert(Alert.AlertType.CONFIRMATION);
	
	private Properties properties = new Properties();
	
	
	/**
	 * Returns a string of the username currently playing.
	 * 
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public int getCurrency(String username) throws FileNotFoundException, IOException {
		properties.clear();
		
		try(FileInputStream inFile = new FileInputStream(USER_CURRENCY_FILE_OBJECT)) {
			properties.load(inFile);
		}
		catch(FileNotFoundException e) {
			System.out.println(USER_CURRENCY_FILE_NAME + ": file not found");
		}
		
		return Integer.parseInt((String) properties.get(username));
	}
	
	/**
	 * Returns a string of the username currently playing.
	 * 
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public String getCurrentUser() throws FileNotFoundException, IOException {
		properties.clear();
		
		try(FileInputStream inFile = new FileInputStream(CURRENT_USER_FILE_OBJECT)) {
			properties.load(inFile);
		}
		catch(FileNotFoundException e) {
			System.out.println(CURRENT_USER_FILE_NAME + ": file not found");
		}
		
		for(String keys : properties.stringPropertyNames()) {
			return keys;
		}
		
		return "ERROR";
	}
	
	/**
	 * Adds item to inventory.properties file
	 * 
	 * @throws IOException 
	 */
	public void addToInventory(String username, String itemName) throws IOException {
		properties.clear();
		
		try(FileInputStream inFile = new FileInputStream(INVENTORY_FILE_OBJECT)) {
			properties.load(inFile);
			inFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(INVENTORY_FILE_NAME + ": file not found");
		}
		
		String newInventory = properties.get(username) + itemName;
		
		
		
		try(FileOutputStream outFile = new FileOutputStream(INVENTORY_FILE_OBJECT, false)) {
			properties.replace(username, newInventory);
			properties.store(outFile, null);
			outFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(INVENTORY_FILE_NAME + ": file not found");
		}
	}
	
	/**
	 * Subtracts the user's currency and updates "userCurrency.properties" file.
	 * 
	 * @param username
	 * @param amountDeduced
	 * @throws IOException
	 */
	public void deductCurrency(String username, int amountDeduced) throws IOException {
		properties.clear();
		
		try(FileInputStream inFile = new FileInputStream(USER_CURRENCY_FILE_OBJECT)) {
			properties.load(inFile);
			inFile.close();	//close file
		}
		catch(FileNotFoundException e) {
			System.out.println(USER_CURRENCY_FILE_NAME + ": file not found");
		}
		
		try(FileOutputStream outFile = new FileOutputStream(USER_CURRENCY_FILE_OBJECT, false)) {
			properties.replace(username, String.valueOf(Integer.parseInt((String) properties.get(username)) - amountDeduced));
			properties.store(outFile, null);
			outFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(INVENTORY_FILE_NAME + ": file not found");
		}
	}
	
	/**
	 * If the user is determined to have enough currency, then 
	 * deduct 100 currency, add KnightChestpiece to inventory, and update the 
	 * top-left currency label seen by the user.
	 * 
	 * @param currencyLabel
	 * @throws IOException
	 */
	public void buyKnightChestpiece(Label currencyLabel) throws IOException {
		String username = getCurrentUser();
		int currency = getCurrency(username);
		
		
		
		if(currency >= 100) {
			a2.showAndWait();
			ButtonType bt = a2.getResult();
			
			if(bt.equals(ButtonType.OK)) {
				deductCurrency(username, 100);
				addToInventory(username, ",CommonChestpiece v2");
				updateCurrency(currencyLabel);
			} else {
				a.setContentText("Purchase Canceled");
				a.showAndWait();
			}
		} else {
			a.setContentText("Not enough currency");
			a.showAndWait();
		}
	}
	
	/**
	 * If the user is determined to have enough currency, then 
	 * deduct 100 currency, add KnightBoots to inventory, and update the 
	 * top-left currency label seen by the user.
	 * 
	 * @param currencyLabel
	 * @throws IOException
	 */
	public void buyKnightBoots(Label currencyLabel) throws IOException {
		String username = getCurrentUser();
		int currency = getCurrency(username);
				
		
		
		if(currency >= 100) {
			a2.showAndWait();
			ButtonType bt = a2.getResult();
			
			if(bt.equals(ButtonType.OK)) {
				deductCurrency(username, 100);
				addToInventory(username, ",CommonBoots v2");
				updateCurrency(currencyLabel);
			} else {
				a.setContentText("Purchase Canceled");
				a.showAndWait();
			}
		} else {
			a.setContentText("Not enough currency");
			a.showAndWait();
		}
	}
	
	/**
	 * If the user is determined to have enough currency, then 
	 * deduct 100 currency, add KnightHelmet to inventory, and update the 
	 * top-left currency label seen by the user.
	 * 
	 * @param currencyLabel
	 * @throws IOException
	 */
	public void buyKnightHelmet(Label currencyLabel) throws IOException {
		String username = getCurrentUser();
		int currency = getCurrency(username);
			
		
		
		if(currency >= 100) {
			a2.showAndWait();
			ButtonType bt = a2.getResult();
			
			if(bt.equals(ButtonType.OK)) {
				deductCurrency(username, 100);
				addToInventory(username, ",CommonHelmet v2");
				updateCurrency(currencyLabel);
			} else {
				a.setContentText("Purchase Canceled");
				a.showAndWait();
			}
		} else {
			a.setContentText("Not enough currency");
			a.showAndWait();
		}
	}
	
	/**
	 * If the user is determined to have enough currency, then 
	 * deduct 100 currency, add KnightLeggings to inventory, and update the 
	 * top-left currency label seen by the user.
	 * 
	 * @param currencyLabel
	 * @throws IOException
	 */
	public void buyKnightLeggings(Label currencyLabel) throws IOException {
		String username = getCurrentUser();
		int currency = getCurrency(username);
			
		
		
		if(currency >= 100) {
			a2.showAndWait();
			ButtonType bt = a2.getResult();
			
			if(bt.equals(ButtonType.OK)) {
				deductCurrency(username, 100);
				addToInventory(username, ",CommonLeggings v2");
				updateCurrency(currencyLabel);
			} else {
				a.setContentText("Purchase Canceled");
				a.showAndWait();
			}
		} else {
			a.setContentText("Not enough currency");
			a.showAndWait();
		}
	}
	
	/**
	 * If the user is determined to have enough currency, then 
	 * deduct 100 currency, add MercenaryChestpiece to inventory, and update the 
	 * top-left currency label seen by the user.
	 * 
	 * @param currencyLabel
	 * @throws IOException
	 */
	public void buyMercenaryChestpiece(Label currencyLabel) throws IOException {
		String username = getCurrentUser();
		int currency = getCurrency(username);
				
		
		
		if(currency >= 100) {
			a2.showAndWait();
			ButtonType bt = a2.getResult();
			
			if(bt.equals(ButtonType.OK)) {
				deductCurrency(username, 100);
				addToInventory(username, ",CommonChestArmor");
				updateCurrency(currencyLabel);
			} else {
				a.setContentText("Purchase Canceled");
				a.showAndWait();
			}
		} else {
			a.setContentText("Not enough currency");
			a.showAndWait();
		}
	}
	
	/**
	 * If the user is determined to have enough currency, then 
	 * deduct 1000 currency, add SpartanHelmet to inventory, and update the 
	 * top-left currency label seen by the user.
	 * 
	 * @param currencyLabel
	 * @throws IOException
	 */
	public void buySpartanHelmet(Label currencyLabel) throws IOException {
		String username = getCurrentUser();
		int currency = getCurrency(username);
		
		
			
		if(currency >= 1000) {
			a2.showAndWait();
			ButtonType bt = a2.getResult();
			
			if(bt.equals(ButtonType.OK)) {
				deductCurrency(username, 1000);
				addToInventory(username, ",RareHelmet");
				updateCurrency(currencyLabel);
			} else {
				a.setContentText("Puchase Canceled");
				a.showAndWait();
			}
		} else {
			a.setContentText("Not enough currency");
			a.showAndWait();
		}
	}
	
	/**
	 * Updates the currency label by finding the user's old currency
	 * and setting it to new currency.
	 * 
	 * @param currencyLabel
	 * @throws IOException
	 */
	public void updateCurrency(Label currencyLabel) {
		try {
			String username = getCurrentUser();
			String currency = String.valueOf(getCurrency(username));
			currencyLabel.setText(currency);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Displays the sold out message.
	 */
	public void showSoldOutMessage() {
		a.setContentText("Sorry, but the item you want to buy is sold out.\n Please try again later.");
		a.showAndWait();
	}
}
