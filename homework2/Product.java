/*
 * File: Product.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 2/1/2017
 * Assignment: Homework assignment 2
 * 
 * Characteristics common to all products sold in a store
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Characteristics of a product sold in a store. This class is made to be 
 * subclassed to add attributes specific to a given product type.
 * 
 * @author Brenna Olson
 */
public class Product {
	private double price;
	private String productName;
	private boolean warrantyEligible;
	
	/**
	 * Initialize common characteristics of a product
	 * 
	 * @param price Price of the product without tax or warranty
	 * @param name Name of the product
	 * @param warranty Whether or not the product is warranty-eligible
	 */
	public Product(double price, String name, boolean warranty) {
		this.price = price;
		productName = name;
		warrantyEligible = warranty;
	}
	
	/**
	 * Initialize common characteristics of a product
	 * 
	 * <p>The product's price is set to $0.00, the name to an empty string, and 
	 * the warranty eligibility to false
	 */
	public Product() {
		price = 0;
		productName = "";
		warrantyEligible = false;
	}

	public double getPrice() {
		return price;
	}
	

	public String getProductName() {
		return productName;
	}
	
	public boolean isWarrantyEligible() {
		return warrantyEligible;
	}
}
