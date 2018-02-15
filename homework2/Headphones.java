/*
 * File: Headphones.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 2/2/2017
 * Assignment: Homework assignment 2
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
	private String brand;
	private boolean hasBluetooth;
	
	/**
	 * Initialize characteristics of a pair of headphones
	 * 
	 * @param price Price of the headphones without tax or warranty
	 * @param name Name of the headphones
	 * @param warranty Whether or not the headphones are warranty-eligible
	 * @param brand Brand of the headphones
	 * @param bluetooth Whether or not the headphones have Bluetooth
	 */
	public Headphones(double price, String name, boolean warranty, String brand, 
					  boolean bluetooth) {
		super(price, name, warranty);
		this.brand = brand;
		hasBluetooth = bluetooth;
	}
	
	/**
	 * Initialize characteristics of a pair of headphones to default values
	 * 
	 * <p>The headphones's price is set to $0.00, the name to an empty string, 
	 * the warranty eligibility to false, the brand to an empty string, 
	 * and the Bluetooth capability to false
	 */
	public Headphones() {
		super();
		brand = "";
		hasBluetooth = false;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public boolean hasBluetooth() {
		return hasBluetooth;
	}
}
