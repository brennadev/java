/*
 * File: CellPhone.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 1/25/2017
 * Assignment: Homework assignment 2
 * 
 * Cell phone carried by a store
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Cell phone carried by a store
 * 
 * @author Brenna Olson
 */
public class CellPhone extends Product {
	private String carrier;
	
	/**
	 * Initialize characteristics of a cell phone
	 * 
	 * @param price Price of the phone without tax or warranty
	 * @param name Name of the phone
	 * @param warranty Whether or not the phone is warranty-eligible
	 * @param carrier Carrier name
	 */
	public CellPhone(double price, String name, boolean warranty,
					 String carrier) {
		super(price, name, warranty);
		this.carrier = carrier;
	}
	
	/**
	 * Initialize characteristics of a cell phone to default values
	 * 
	 * <p>The phone's price is set to $0.00, the name to an empty string, 
	 * the carrier to an empty string, and the warranty eligibility to false
	 */
	public CellPhone() {
		super();
		carrier = "";
	}
	
	public String getCarrier() {
		return carrier;
	}
}
