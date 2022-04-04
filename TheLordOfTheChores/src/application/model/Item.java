package application.model;

public class Item {
	private final String name;
	private final String description;
	private final Rarity rarity;
	private final ItemType itemType;
	
	public Item(String name, String description, Rarity rarity, ItemType itemType) {
		this.name = name;
		this.description = description;
		this.rarity = rarity;
		this.itemType = itemType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the rarity
	 */
	public Rarity getRarity() {
		return rarity;
	}

	/**
	 * @return the itemType
	 */
	public ItemType getItemType() {
		return itemType;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", description=" + description + ", rarity=" + rarity + ", itemType=" + itemType
				+ "]";
	}
}
