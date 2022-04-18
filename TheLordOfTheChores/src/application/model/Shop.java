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
 * @author Joshua Villarreal (uut835)
 *
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
	
	public void deductCurrency(String username, int amountDeduced) throws IOException {
		properties.clear();
		
		try(FileInputStream inFile = new FileInputStream(USER_CURRENCY_FILE_OBJECT)) {
			properties.load(inFile);
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
	 * If current users currency is equal to or greater than item price, them add item to inventory.properties file.
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
				addToInventory(username, ",KnightChestpiece");
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

	public void buyKnightBoots(Label currencyLabel) throws IOException {
		String username = getCurrentUser();
		int currency = getCurrency(username);
				
		
		
		if(currency >= 100) {
			a2.showAndWait();
			ButtonType bt = a2.getResult();
			
			if(bt.equals(ButtonType.OK)) {
				deductCurrency(username, 100);
				addToInventory(username, ",KnightBoots");
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

	public void buyKnightHelmet(Label currencyLabel) throws IOException {
		String username = getCurrentUser();
		int currency = getCurrency(username);
			
		
		
		if(currency >= 100) {
			a2.showAndWait();
			ButtonType bt = a2.getResult();
			
			if(bt.equals(ButtonType.OK)) {
				deductCurrency(username, 100);
				addToInventory(username, ",KnightHelmet");
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

	public void buyKnightLeggings(Label currencyLabel) throws IOException {
		String username = getCurrentUser();
		int currency = getCurrency(username);
			
		
		
		if(currency >= 100) {
			a2.showAndWait();
			ButtonType bt = a2.getResult();
			
			if(bt.equals(ButtonType.OK)) {
				deductCurrency(username, 100);
				addToInventory(username, ",KnightLeggings");
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

	public void buyMercenaryChestpiece(Label currencyLabel) throws IOException {
		String username = getCurrentUser();
		int currency = getCurrency(username);
				
		
		
		if(currency >= 100) {
			a2.showAndWait();
			ButtonType bt = a2.getResult();
			
			if(bt.equals(ButtonType.OK)) {
				deductCurrency(username, 100);
				addToInventory(username, ",MercenaryChestpiece");
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

	public void buySpartanHelmet(Label currencyLabel) throws IOException {
		String username = getCurrentUser();
		int currency = getCurrency(username);
		
		
			
		if(currency >= 1000) {
			a2.showAndWait();
			ButtonType bt = a2.getResult();
			
			if(bt.equals(ButtonType.OK)) {
				deductCurrency(username, 1000);
				addToInventory(username, ",SpartanHelmet");
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
	
	public void showSoldOutMessage() {
		a.setContentText("Sorry, but the item you want to buy is sold out. Please try again later.");
		a.showAndWait();
	}
}
