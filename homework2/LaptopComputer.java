/*
 * File: LaptopComputer.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 2/2/2017
 * Assignment: Homework assignment 2
 * 
 * Laptop carried by a store
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Laptop carried by a store
 * 
 * @author Brenna Olson
 */
public class LaptopComputer extends Product {
	private String brand;
	
	/**
	 * Initialize characteristics of a laptop
	 * 
	 * @param price Price of the laptop without tax or warranty
	 * @param name Name of the laptop
	 * @param warranty Whether or not the laptop is warranty-eligible
	 * @param brand Brand of the laptop
	 */
	public LaptopComputer(double price, String name, boolean warranty,
						  String brand) {
		super(price, name, warranty);
		this.brand = brand;
	}
	
	/**
	 * Initialize characteristics of a laptop to default values
	 * 
	 * <p>The laptop's price is set to $0.00, the name to an empty string, 
	 * the warranty eligibility to false, and the brand to an empty string
	 */
	public LaptopComputer() {
		super();
		brand = "";
	}
	
	public String getBrand() {
		return brand;
	}
}
