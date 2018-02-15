/*
 * File: Television.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 1/25/2017
 * Assignment: Homework assignment 2
 * 
 * Television carried by a store
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Television carried by a store
 * 
 * @author Brenna Olson
 */
public class Television extends Product {
	private String brand;
	private double screenSize;
	
	/**
	 * Initialize characteristics of a television
	 * 
	 * @param price Price of the television without tax or warranty
	 * @param name Name of the television
	 * @param warranty Whether or not the television is warranty-eligible
	 * @param brand Brand of the television
	 * @param size Size of the television's screen
	 */
	public Television(double price, String name, boolean warranty, String brand,
					  double size) {
		super(price, name, warranty);
		this.brand = brand;
		screenSize = size;
	}
	
	/**
	 * Initialize characteristics of a television to default values
	 * 
	 * <p>The television's price is set to $0.00, the name to an empty string,
	 * the warranty eligibility to false, the brand to an empty string, 
	 * and the size to 0
	 */
	public Television() {
		super();
		brand = "";
		screenSize = 0;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public double getScreenSize() {
		return screenSize;
	}
}
