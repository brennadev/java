/*
 * File: Product.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 2/1/2017
 * Assignment: Homework assignment 3
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
    private String productId;
	private double price;
	private String productName;
	private boolean warrantyEligible;
	private String brand;
	
	/**
	 * Initialize common characteristics of a product
	 * 
	 * @param productId Alphanumeric value unique to product
	 * @param price Price of the product without tax or warranty
	 * @param name Name of the product
	 * @param warranty Whether or not the product is warranty-eligible
	 * @param brand Brand of the product
	 */
	public Product(String productId, double price, String name, boolean warranty,
	               String brand) {
	    this.productId = productId;
	    this.price = price;
		productName = name;
		warrantyEligible = warranty;
		this.brand = brand;
	}
	
	/**
	 * Initialize common characteristics of a product
	 * 
	 * <p>The product's product ID is set to an empty string, price to $0.00, 
	 * name to an empty string, warranty eligibility to false, and brand to an
	 * empty string.
	 */
	public Product() {
	    productId = "";
		price = 0;
		productName = "";
		warrantyEligible = false;
		brand = "";
	}
	
	
	/**
	 * Initialize a <code>Product</code> by making a copy of an existing
	 * <code>Product</code> instance
	 * 
	 * @param productCopy <code>Product</code> instance to copy
	 */
	public Product(Product productCopy) {
	    this.productId = productCopy.productId;
	    this.price = productCopy.price;
	    this.productName = productCopy.productName;
	    this.warrantyEligible = productCopy.warrantyEligible;
	    this.brand = productCopy.brand;
	}

	public String getProductId() {
	    return productId;
	}
	
	public void setProductId(String id) {
	    productId = id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public boolean isWarrantyEligible() {
		return warrantyEligible;
	}
	
	public void setWarrantyEligible(boolean warrantyEligible) {
		this.warrantyEligible = warrantyEligible;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String newBrand) {
	    brand = newBrand;
	}
}
