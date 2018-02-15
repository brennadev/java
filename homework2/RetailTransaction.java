/*
 * File: RetailTransaction.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 1/25/2017
 * Assignment: Homework assignment 2
 * 
 * Information for 1 transaction from a store
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

import java.util.Scanner;

/**
 * Information for 1 transaction from a store
 * 
 * @author Brenna Olson
 */
public class RetailTransaction {
	
	// total from all transactions
	private static double totalSales = 0;
	
	private long transactionId;
	private String transactionType;
	private double total;
	private int numberOfItems;
	private int registerId;
	
	/**
	 * Initialize a new transaction using a <code>String</code> with the 
	 * necessary values. The total and number of items are both initialized
	 * to 0.
	 * 
	 * @param transaction String in the format 
	 * 		  [transaction id],[register id],[transaction type] 
	 */
	public RetailTransaction(String transaction) {
		try (Scanner scanner = new Scanner(transaction)) {
			scanner.useDelimiter(",");
			
			transactionId = scanner.nextLong();
			registerId = scanner.nextInt();
			transactionType = scanner.next();
		}
		
		total = 0;
		numberOfItems = 0;
	}
	
	/**
	 * Initialize a new transaction with default values. The transaction's id is
	 * set to 0, the transaction type to an empty string, the total to 0, the
	 * number of items to 0, and the register id to 0.
	 */
	public RetailTransaction() {
		transactionId = 0;
		transactionType = "";
		total = 0;
		numberOfItems = 0;
		registerId = 0;
	}

	/**
	 * Add a new item to the transaction. Tax and warranty will be added to cost 
	 * as needed.
	 * 
	 * @param item Item to be added to transaction. The <code>String</code> 
	 * 		  should be of the format [product type],[quantity],[warranty quantity].
	 * @param catalog Product catalog used for this transaction
	 */
	public void addItem(String item, ProductCatalog catalog) {
		try (Scanner scanner = new Scanner(item)) {
			scanner.useDelimiter(",");
			
			addItem(catalog.getPriceForItemType(scanner.next()), 
					scanner.nextInt(), scanner.nextInt());
			scanner.close();
		}
	}
	
	/*
	 * Add a new item to the transaction. Tax and warranty costs are 
	 * automatically added. If the transaction is a return, the price passed in 
	 * is subtracted.
	 * 
	 * price: Price of the item
	 * quantity: Quantity of item purchased/returned
	 * warrantyQuantity: Number of warranties purchased
	 */
	private void addItem(double price, int quantity, int warrantyQuantity) {
		double newAmount = (price * quantity + price * warrantyQuantity * 0.1)
							* 1.0725;
		numberOfItems += quantity;
		
		if (transactionType.equals("sale")) {
			total += newAmount;
			totalSales += newAmount;
		} else {
			total -= newAmount;
			totalSales -= newAmount;
		}
	}	
	
	/**
	 * String representation used for output
	 * 
	 * @return <code>String</code> output for files and console
	 */
	public String toString() {
		return String.format("Transaction %d: %d %s totaling %s on register %d", 
				this.transactionId, this.numberOfItems, singularPlural(), 
				formatTotal(), this.registerId);
	}
	
	// Used in toString to express quantity correctly
	private String singularPlural() {
		if (numberOfItems == 1) {
			return "item";
		}
		return "items";
	}
	
	// Returns a String of the total in dollar format; is enclosed in 
	// parentheses if it's a return
	private String formatTotal() {
		if (transactionType.equals("sale")) {
			return String.format("$%,.2f", this.total);
		}
		return String.format("($%,.2f)", Math.abs(this.total));
	}
	
	/**
	 * <code>String</code> value of the amount of all transactions completed
	 * 
	 * @return <code>String</code> of the total sales in dollar format; is 
	 * 		   enclosed in parentheses if the amount is negative
	 */
	public static String formatTotalSales() {
		if (totalSales >= 0) {
			return String.format("$%,.2f", totalSales);
		}
		return String.format("($%,.2f)", Math.abs(totalSales));
	}
	
	
	/**
	 * Value of all transactions completed
	 * 
	 * @return Value of all transactions
	 */
	public static double getTotalSales() {
		return totalSales;
	}
	
	/**
	 * Unique identifier for the transaction
	 * 
	 * @return Transaction identifier
	 */
	public long getTransactionId() {
		return transactionId;
	}
	
	/**
	 * Whether the transaction is a sale or return
	 * 
	 * @return "sale" if sale; "return" if return
	 */
	public String getTransactionType() {
		return transactionType;
	}
	
	/**
	 * Purchase total
	 * 
	 * @return Purchase total including warranty (if applicable) and tax
	 */
	public double getTotal() {
		return total;
	}
	
	/**
	 * Quantity of items sold
	 * 
	 * @return Quantity sold
	 */
	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	/**
	 * Register used to process sale/return
	 * 
	 * @return Register number
	 */
	public int getRegisterId() {
		return registerId;
	}
}
