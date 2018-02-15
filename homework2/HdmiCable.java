/*
 * File: HdmiCable.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 2/2/2017
 * Assignment: Homework assignment 2
 * 
 * HDMI cable carried by a store
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * HDMI cable carried by a store
 * 
 * @author Brenna Olson
 */
public class HdmiCable extends Product {
	private float lengthInFeet;
	
	/**
	 * Initialize characteristics of an HDMI cable
	 * 
	 * @param price Price of the cable without tax or warranty
	 * @param name Name of the cable
	 * @param warranty Whether or not the cable is warranty-eligible
	 * @param length Length of the cable
	 */
	public HdmiCable(double price, String name, boolean warranty, 
					 float length) {
		super(price, name, warranty);
		lengthInFeet = length;
	}
	
	/**
	 * Initialize characteristics of an HDMI cable to default values
	 * 
	 * <p>The cable's price is set to $0.00, the name to an empty string, 
	 * the warranty eligibility to false, and the length to 0 feet
	 */
	public HdmiCable() {
		super();
		lengthInFeet = 0;
	}
	
	public float getLengthInFeet() {
		return lengthInFeet;
	}
}
