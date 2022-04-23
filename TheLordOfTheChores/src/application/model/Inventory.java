package application.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
/**
 * @author Isaac Nguyen (rrg053)
 * UTSA CS 3443 - Lab 4
 * Spring 2022
 */

//Inventory class to see what equipment user has in their inventory and be able to equip them
public class Inventory {
	//properties files to store and retrieve user information
	private static final String CURRENT_USER_FILE_NAME = "currentUser.properties";
	private static final File CURRENT_USER_FILE_OBJECT = new File(CURRENT_USER_FILE_NAME);
	private final static String INVENTORY_FILE_NAME = "inventory.properties";
	private final static File INVENTORY_FILE_OBJECT = new File(INVENTORY_FILE_NAME);
	private static final String USER_CURRENCY_FILE_NAME = "userCurrency.properties";
	private static final File USER_CURRENCY_FILE_OBJECT = new File(USER_CURRENCY_FILE_NAME);
	private static final String ITEMS_EQUIPPED_FILE_NAME = "itemsEquipped.properties";
	private static final File ITEMS_EQUIPPED_FILE_OBJECT = new File(ITEMS_EQUIPPED_FILE_NAME);
	
	//create properties variable for properties class
	private Properties properties = new Properties();
	//HashMap for inventory
	private HashMap<String, String> inventory = new HashMap<>();
	
	//gets the the currency of the user
	public int getCurrency(String username) throws FileNotFoundException, IOException {
		properties.clear();
		//load currency properties file
		try(FileInputStream inFile = new FileInputStream(USER_CURRENCY_FILE_OBJECT)) {
			properties.load(inFile);
		}
		//FileNotFoundException catch
		catch(FileNotFoundException e) {
			System.out.println(USER_CURRENCY_FILE_NAME + ": file not found");
		}
		//return value 
		return Integer.parseInt((String) properties.get(username));
	}
	
	//gets the current user 
	public String getCurrentUser() throws FileNotFoundException, IOException {
		properties.clear(); // clear properties
		//load current user file
		try(FileInputStream inFile = new FileInputStream(CURRENT_USER_FILE_OBJECT)) {
			properties.load(inFile);
		}
		//FileNotFoundException catch
		catch(FileNotFoundException e) {
			System.out.println(CURRENT_USER_FILE_NAME + ": file not found");
		}
		
		//get user
		for(String keys : properties.stringPropertyNames()) {
			return keys;
		}
		//otherwise return error
		return "ERROR";
	}
	//updated currency value
	public void updateCurrency(Label currencyLabel) {
		
		try {
			String username = getCurrentUser();//get the current user 
			String currency = String.valueOf(getCurrency(username));//get current currency value
			currencyLabel.setText(currency);//set new value to screen
		//catch File not found exception
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		// catch IO exception
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//get Inventory items stored in inventory properties file
	public void getInventory(ListView<String> helmetList, ListView<String> chestList, ListView<String> gauntList, ListView<String> legList, ListView<String> bootList) throws FileNotFoundException, IOException {
		properties.clear(); // clear properties
		
		String user = getCurrentUser();//gets the current user
		//load inventory file
		try(FileInputStream inFile = new FileInputStream(INVENTORY_FILE_OBJECT)) {
			properties.load(inFile);
			// add users name and inventory to HashMap
			for(String keys : properties.stringPropertyNames()) {
				inventory.put(keys, properties.get(keys).toString());
			}
			String inv = inventory.get(user);// create inventory string to for user inventory
			String split[] = inv.split(",");//split each item by the comma separating them
			//go through each item and place them in their respective List
			for(int i = 0; i < split.length; i++) {
				//add item to helmet list
				if(split[i].contains("Helmet")){
					helmetList.getItems().add(split[i]);
				}
				//add item to Chest piece list
				if(split[i].contains("Chest")){
					chestList.getItems().add(split[i]);
				}
				//add item to Gauntlets list
				if(split[i].contains("Gauntlets")){
					gauntList.getItems().add(split[i]);
				}
				//add item to Leggings list
				if(split[i].contains("Leggings")){
					legList.getItems().add(split[i]);
				}
				//add item to Boots list
				if(split[i].contains("Boots")){
					bootList.getItems().add(split[i]);
				}
			}
			//close file
			inFile.close();
		}
		//File not found exception catch
		catch(FileNotFoundException e) {
			System.out.println(INVENTORY_FILE_NAME + ": file not found");
		}
		
	}
	// equip items selected by user
	public void equipItem(String helmet,String chest,String gaunt,String leg,String boot)  throws IOException{
		properties.clear(); // clear properties
		
		String user = getCurrentUser();	//get current user
		String equipment;	//variable to hold string of all item
		//if helmet not selected do not equip
		if( helmet == null) {
			helmet = "NONE";
		}
		//if chest piece not selected do not equip
		if( chest == null) {
			chest = "NONE";
		}
		//if gauntlets not selected do not equip
		if( gaunt == null) {
			gaunt = "NONE";
		}
		//if leggings not selected do not equip
		if( leg == null) {
			leg = "NONE";
		}
		//if boots not selected do not equip
		if( boot == null) {
			boot = "NONE";
		}
		//add all equip items to one string with comma separators
		equipment = helmet + "," + chest + "," + gaunt + "," + leg + "," + boot ;
		// load equipped items file
		try(FileInputStream inFile = new FileInputStream(ITEMS_EQUIPPED_FILE_OBJECT)) {
			properties.load(inFile); // Load file data	
			inFile.close();	//close file
		}
		//File not found exception catch
		catch(FileNotFoundException e) {
			System.out.println(ITEMS_EQUIPPED_FILE_NAME + ": File does not exist");
		}
		
		properties.put(user,equipment); // Store equipment into hash map
		
		//write to equipped items file
		try(FileOutputStream outFile = new FileOutputStream(ITEMS_EQUIPPED_FILE_OBJECT, false)) {
			properties.store(outFile, null); // Store info in properties file
			outFile.close();	//close file
		//File not found exception catch
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


}
