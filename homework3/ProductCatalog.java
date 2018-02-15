/*
 * File: ProductCatalog.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 1/25/2017
 * Assignment: Homework assignment 3
 * 
 * Products carried by a store
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

import java.util.Map;
import java.util.HashMap;

/**
 * Products carried by a store
 * 
 * @author Brenna Olson
 */
public class ProductCatalog {

	private Map<String, Product> products = new HashMap<>();
	
	/**
	 * Find a product contained in the catalog
	 * 
	 * @param productId ID of product to find
	 * @return Product that matches the ID contained in <code>productId</code> 
	 *         if the catalog contains the item; else, <code>null</code> is
	 *         returned
	 */
	public Product findProductByID(String productId) {
	    return new Product(products.get(productId));
	}

	/**
	 * Add a new product to the catalog
	 * 
	 * <p>Product will not be added to the catalog if its <code>productId</code> 
	 * is null, <code>productId</code> is empty, already in the catalog, or is
	 * not an instance of <code>CellPhone</code> or <code>Headphones</code>.
	 * 
	 * @param product <code>Product</code> instance to be added to the catalog
	 */
	public void addProduct(Product product) {
	    if (!(product.getProductId() == null) && 
	        !product.getProductId().equals("") &&
	        !products.containsKey(product.getProductId()) && 
	        (product instanceof CellPhone || product instanceof Headphones)) {
	        products.put(product.getProductId(), product);
	    }
	}
}
