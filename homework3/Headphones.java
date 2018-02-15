/*
 * File: Headphones.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 2/2/2017
 * Assignment: Homework assignment 3
 * 
 * Headphones carried by a store
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Headphones carried by a store
 * 
 * @author Brenna Olson
 */
public class Headphones extends Product {
	private boolean hasBluetooth;
	
	/**
	 * Initialize characteristics of a pair of headphones
	 * 
	 * @param productId Alphanumeric value unique to product
	 * @param price Price of the headphones without tax or warranty
	 * @param name Name of the headphones
	 * @param warranty Whether or not the headphones are warranty-eligible
	 * @param brand Brand of the headphones
	 * @param bluetooth Whether or not the headphones have Bluetooth
	 */
	public Headphones(String productId, double price, String name,
	                  boolean warranty, String brand, boolean bluetooth) {			  
		super(productId, price, name, warranty, brand);
		hasBluetooth = bluetooth;
	}
	
	/**
	 * Initialize characteristics of a pair of headphones to default values
	 * 
	 * <p>The headphones's product ID is set to an empty string, price to $0.00,
	 * name to an empty string, warranty eligibility to false, brand to an empty
	 * string, and Bluetooth capability to false.
	 */
	public Headphones() {
		super();
		hasBluetooth = false;
	}
	
	public boolean hasBluetooth() {
		return hasBluetooth;
	}
	
	public void setHasBluetoothFlag(boolean hasBluetooth) {
		this.hasBluetooth = hasBluetooth;
	}
}
