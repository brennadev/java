/*
 * File: ProductCatalog.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 1/25/2017
 * Assignment: Homework assignment 2
 * 
 * Products carried by a store
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

import java.util.Scanner;

/**
 * Products carried by a store
 * 
 * @author Brenna Olson
 */
public class ProductCatalog {
	private Headphones bluetoothHeadphones;
	private CellPhone cellPhone;
	private Television television;
	private LaptopComputer laptopComputer;
	private HdmiCable hdmiCable;
	
	
	/**
	 * Initialize characteristics of a product catalog
	 * 
	 * <p>All items are set to null and must be initialized later
	 */
	public ProductCatalog() {
		bluetoothHeadphones = null;
		cellPhone = null;
		television = null;
		laptopComputer = null;
		hdmiCable = null;
	}
	
	/**
	 * Add a new item to the catalog
	 * 
	 * @param item String with the following format: product type, price, name, warranty eligible, other attributes in order specified in constructor for specific product type
	 */
	public void addItem(String item) {
		
		try (Scanner newItem = new Scanner(item)) {
			newItem.useDelimiter(",");

			// set the values for parts of the data that are the same across all product types
			String type = newItem.next();
			double price = newItem.nextDouble();
			String name = newItem.next();
			boolean warrantyEligible = newItem.nextBoolean();


			// set the values for parts of the data that are different in individual product types 
			// and assign to the appropriate attribute within ProductCatalog
			switch (type) {
			case "headphones":
				bluetoothHeadphones = new Headphones(price, name, warrantyEligible, newItem.next(), newItem.nextBoolean());
				break;
			case "cell phone":
				cellPhone = new CellPhone(price, name, warrantyEligible, newItem.next());
				break;
			case "television":
				television = new Television(price, name, warrantyEligible, newItem.next(), newItem.nextDouble());
				break;
			case "laptop":
				laptopComputer = new LaptopComputer(price, name, warrantyEligible, newItem.next());
				break;
			case "HDMI cable":
				hdmiCable = new HdmiCable(price, name, warrantyEligible, newItem.nextFloat());
				break;
			}

			newItem.close();
		}
	}
	
	/**
	 * Get price for a given item type
	 * @param itemName Name of the item
	 * @return Price of the item. If <code>itemName</code> doesn't match any 
	 * 		   item in the catalog, a value of 0 is returned.
	 */
	public double getPriceForItemType(String itemName) {
		switch (itemName) {
		case "cell phone":
			return cellPhone.getPrice();
		case "headphones":
			return bluetoothHeadphones.getPrice();
		case "HDMI cable":
			return hdmiCable.getPrice();
		case "laptop":
			return laptopComputer.getPrice();
		case "television":
			return television.getPrice();
		default:
			return 0;
		}
	}
}
