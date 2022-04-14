package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author Joshua Villarreal (uut835)
 *
 */

public class Shop {
	private final static String ITEMS_FILE_NAME = "data/Items.csv";
	private final static String INVENTORY_FILE_NAME = "data/inventory.txt";
	private final static File INVENTORY_FILE_OBJECT = new File(INVENTORY_FILE_NAME);
	private HashMap<String, String> inventory = new HashMap<>();
	private Properties properties = new Properties();
	private ArrayList<Item> Items = new ArrayList<>();
	private ArrayList<Item> ItemsInStock = new ArrayList<>();
	
	/**
	 * Reads a file of items in the format name, description, rarity, and item type
	 * and puts them in an ArrayList of items
	 * 
	 * Note to self: must find a way to store these as persistent objects.
	 */
	public void readItemsFromFile() {
		File itemsFile = new File(ITEMS_FILE_NAME);
		String itemsFilePath = itemsFile.getAbsolutePath();
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(itemsFilePath));
			br.readLine();
			String line = br.readLine(); 
			
			while(line != null) {
				String[] attributes = line.split(",");
				Item item = new Item(attributes[0], attributes[1], findItemRarity(attributes[2]), findItemType(attributes[3]));
				Items.add(item);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: " + ": file" + ITEMS_FILE_NAME +  "not found");
			e.printStackTrace();
		} catch (IOException e2) {
			System.out.println("ERROR: " + ": file" + ITEMS_FILE_NAME +  "failed to read");
			e2.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
		}
	}
	
	/**
	 * Returns an itemType enum based on the String s parameter.
	 * 
	 * @param s
	 * @return
	 */
	private ItemType findItemType(String s) {
		switch(s.toLowerCase()) {
		case "chestpiece":
			return ItemType.CHESTPIECE;
		case "leggings":
			return ItemType.LEGGINGS;
		case "helmet":
			return ItemType.HELMET;
		case "shoes":
			return ItemType.SHOES;
		case "gaunlets":
			return ItemType.GAUNLETS;
		}
		
		return null;
	}
	
	/**
	 * Returns a Rarity enum based on the String s parameter 
	 * 
	 * @param s
	 * @return
	 */
	private Rarity findItemRarity(String s) {
		switch(s.toLowerCase()) {
		case "common":
			return Rarity.COMMON;
		case "uncommon":
			return Rarity.UNCOMMON;
		case "rare":
			return Rarity.RARE;
		case "lengendary":
			return Rarity.LEGENDARY;
		}
		
		return null;
	}
	
	/**
	 * If user has enough money, then the item is added to inventory
	 * 
	 * Otherwise, print error message
	 */
	public void validateAndBuyItem() {
		
	}
	
	/**
	 * Adds item to inventory
	 */
	public void addToInventory() {
		
	}
}
