/*
 * File: LineItem.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 1/25/2017
 * Assignment: Homework assignment 3
 * 
 * A single product type in a transaction
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * @author Brenna Olson
 *
 * A single product type in a transaction
 */
public class LineItem {
    private Product product;
    private int quantity;
    private int warrantyQuantity;
    
    /**
     * Initialize characteristics of a single product type in a transaction
     * 
     * @param product Product being sold or returned
     * @param quantity Quantity sold or returned of the product
     * @param warrantyQuantity Warranty quantity sold or returned with the 
     *        product
     */
    public LineItem(Product product, int quantity, int warrantyQuantity) {
        this.product = product;
        this.quantity = quantity;
        this.warrantyQuantity = warrantyQuantity;
    }
    
    /**
     * Initialize characteristics of a single product type in a transaction
     * 
     * <p>The product is set to an empty <code>Product</code>, quantity to 0, 
     *    and warranty quantity to 0
     */
    public LineItem() {
        product = new Product();
        quantity = 0;
        warrantyQuantity = 0;
    }
    
    /**
     * Add more items of the same type
     * 
     * @param amount Number of items to add
     */
    public void incrementQuantity(int amount) {
        quantity += amount;
    }
    
    /**
     * Add more warranties for items of the same type
     * 
     * @param amount Number of warranties to add
     */
    public void incrementWarrantyQuantity(int amount) {
        warrantyQuantity += amount;
    }
    
    public Product getProduct() {
        return new Product(product);
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public int getWarrantyQuantity() {
        return warrantyQuantity;
    }
    /**
     * Total cost of all items including warranties
     * 
     * @return Total cost
     */
    public double getTotalCostWithWarranty() {
        return product.getPrice() * quantity + product.getPrice() * warrantyQuantity * 0.1;
    }
}
