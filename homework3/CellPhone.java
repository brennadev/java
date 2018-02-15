/*
 * File: CellPhone.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 1/25/2017
 * Assignment: Homework assignment 3
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
	 * @param productId Alphanumeric value unique to product
	 * @param price Price of the phone without tax or warranty
	 * @param name Name of the phone
	 * @param warranty Whether or not the phone is warranty-eligible
	 * @param brand: Brand of the phone
	 * @param carrier Carrier for the phone
	 */
	public CellPhone(String productId, double price, String name, 
	                 boolean warranty, String brand, String carrier) {
		super(productId, price, name, warranty, brand);
		this.carrier = carrier;
	}
	
	/**
	 * Initialize characteristics of a cell phone to default values
	 * 
	 * <p>The phone's product ID is set to an empty string, price to $0.00, name
	 * to an empty string, warranty eligibility to false, brand to an empty
	 * string, and carrier to an empty string.
	 */
	public CellPhone() {
		super();
		carrier = "";
	}
	
	public String getCarrier() {
		return carrier;
	}
	
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
}
