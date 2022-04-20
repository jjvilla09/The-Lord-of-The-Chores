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

public class Inventory {
	private static final String CURRENT_USER_FILE_NAME = "currentUser.properties";
	private static final File CURRENT_USER_FILE_OBJECT = new File(CURRENT_USER_FILE_NAME);
	private final static String INVENTORY_FILE_NAME = "inventory.properties";
	private final static File INVENTORY_FILE_OBJECT = new File(INVENTORY_FILE_NAME);
	private static final String USER_CURRENCY_FILE_NAME = "userCurrency.properties";
	private static final File USER_CURRENCY_FILE_OBJECT = new File(USER_CURRENCY_FILE_NAME);
	private static final String ITEMS_EQUIPPED_FILE_NAME = "itemsEquipped.properties";
	private static final File ITEMS_EQUIPPED_FILE_OBJECT = new File(ITEMS_EQUIPPED_FILE_NAME);
	
	private Properties properties = new Properties();
	private HashMap<String, String> inventory = new HashMap<>();
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
	public void getInventory(ListView<String> helmetList,ListView<String> chestList,ListView<String> legList,ListView<String> bootList) throws FileNotFoundException, IOException {
		properties.clear();
		String user = getCurrentUser();
		try(FileInputStream inFile = new FileInputStream(INVENTORY_FILE_OBJECT)) {
			properties.load(inFile);
			for(String keys : properties.stringPropertyNames()) {
				inventory.put(keys, properties.get(keys).toString());
			}
			String inv = inventory.get(user);
			System.out.print(inventory.get(user));
			String split[] = inv.split(",");
			for(int i = 0; i < split.length; i++) {
				if(split[i].contains("Helmet")){
					helmetList.getItems().add(split[i]);
				}
				if(split[i].contains("Chest")){
					chestList.getItems().add(split[i]);
				}
				if(split[i].contains("Leggings")){
					legList.getItems().add(split[i]);
				}
				if(split[i].contains("Boots")){
					bootList.getItems().add(split[i]);
				}
			}
			inFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(INVENTORY_FILE_NAME + ": file not found");
		}
		
	}
	public void equipItem(String helmet,String chest,String leg,String boot)  throws IOException{
		properties.clear(); // Starts from scratch
		String user = getCurrentUser();
		String equipment;
		if( helmet.equals("")) {
			helmet = "NONE";
		}
		if( chest.equals("")) {
			chest = "NONE";
		}
		if( leg.equals("")) {
			leg = "NONE";
		}
		if( boot.equals("")) {
			boot = "NONE";
		}
		equipment = helmet + "," + chest + "," + leg + "," + boot ;
		System.out.println(equipment);
		try(FileInputStream inFile = new FileInputStream(ITEMS_EQUIPPED_FILE_OBJECT)) {
			properties.load(inFile); // Load file data	
		}
		catch(FileNotFoundException e) {
			System.out.println(ITEMS_EQUIPPED_FILE_NAME + ": File does not exist");
		}
		
		properties.put(user,equipment); // Store armor into hashmap
		
		try(FileOutputStream outFile = new FileOutputStream(ITEMS_EQUIPPED_FILE_OBJECT, false)) {
			properties.store(outFile, null); // Store in properties file
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
