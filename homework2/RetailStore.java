/*
 * File: RetailStore.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 1/25/2017
 * Assignment: Homework assignment 2
 * 
 * Driver class for tracking sales and returns of a store's products
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Driver class for tracking sales and returns of a store's products
 * 
 * @author Brenna Olson
 */
public class RetailStore {

	public static void main(String[] args) {
		ProductCatalog catalog = new ProductCatalog();
		
		// read product catalog
		InputOutput.readInputWriteOutput(catalog);
	}
}
