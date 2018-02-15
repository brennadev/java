/*
 * File: RetailTransaction.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 1/25/2017
 * Assignment: Homework assignment 3
 * 
 * Information for 1 transaction from a store
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

import java.util.Map;
import java.util.HashMap;
import java.io.*;

/**
 * Information for 1 transaction from a store
 * 
 * @author Brenna Olson
 */
public class RetailTransaction {
    // amount from all transactions created
    private static double totalSales = 0;
	
	private long transactionId;
	private int registerId;
	private String transactionDate;
	private TransactionTypeEnum transactionType;
	private Map<String, LineItem> lineItems = new HashMap<>();


	/**
	 * Initialize a new transaction with the information passed to 
	 * <code>id</code>, <code>registerId</code>, <code>date</code>, and
	 * <code>type</code>. No items are added to the transaction.
	 * 
	 * @param id Unique number for the transaction
	 * @param registerId Unique number for the register the transaction is 
	 *        completed on
	 * @param date Date and time of the transaction
	 * @param type Whether the transaction is a sale or return
	 */
	public RetailTransaction(long id, int registerId, String date, 
	                         TransactionTypeEnum type) {
	    transactionId = id;
	    this.registerId = registerId;
	    transactionDate = date;
	    transactionType = type;
	}
	
	
	/**
	 * Initialize a new transaction with default values. The transaction's id is
	 * set to 0, register id to 0, date to an empty string, and type to 
	 * <code>UNDEFINED</code>. No items are added to the transaction.
	 */
	public RetailTransaction() {
		transactionId = 0;
		registerId = 0;
		transactionDate = "";
		transactionType = TransactionTypeEnum.UNDEFINED;
	}
	
	/**
	 * Add a new item type to the transaction or update an existing one, 
	 * depending on whether or not the item is already in the transaction
	 * 
	 * @param itemScanned Item to add/update
	 * @param quantity Quantity to add
	 * @param warrantyQuantity Warranty quantity to add
	 */
	public void scanItem(Product itemScanned, int quantity, int warrantyQuantity) {
	    LineItem item = lineItems.get(itemScanned.getProductId());
	  
	    // first check if item is already in lineItems
	    if (item != null) {
	        item.incrementQuantity(quantity);
	        item.incrementWarrantyQuantity(warrantyQuantity);
	    } else {
	        lineItems.put(itemScanned.getProductId(), new LineItem(itemScanned, 
	                      quantity, warrantyQuantity));
	    }
	    
	    double amountAdded = (itemScanned.getPrice() * quantity + 
	                          itemScanned.getPrice() * warrantyQuantity * 0.1) * 
	                          1.0725;
	    
	    if (transactionType == TransactionTypeEnum.SALE) {
	        totalSales += amountAdded;
	    } else if (transactionType == TransactionTypeEnum.RETURN) {
	        totalSales -= amountAdded;
	    }
	}
	

	/**
	 * Total cost for all items in transaction
	 * 
	 * @return Total cost of transaction including 7.25% tax and 10% warranty on
	 *         items with a warranty purchased
	 */
	public double calculateTransactionTotal() {
	    double total = 0;
	    
	    for (LineItem item: lineItems.values()) {
	        total += item.getProduct().getPrice() * item.getQuantity() + 
	                 item.getProduct().getPrice() * item.getWarrantyQuantity() 
	                 * 0.1; 
	    }
	    
	    if (transactionType == TransactionTypeEnum.SALE) {
	        return total * 1.0725;
	    }
	    return total * 1.0725 * -1;
	}
	
	
	/**
	 * Total number of products sold in transaction
	 * 
	 * @return Number of products sold
	 */ 
	public int getNumberOfProductsSold() {
	    // accumulator
	    int totalProductsSold = 0;

	    for (LineItem item: lineItems.values()) {
	        totalProductsSold += item.getQuantity();
	    }
	    
	    return totalProductsSold;
	}
	
	/**
	 * Create receipt for transaction and write it to a file of the name 
	 * receipt_[transaction id]_[register id].txt
	 */
	public void generateReceipt() {
	    StringBuilder receipt = new StringBuilder();
	    double subtotal = 0;
	    
	    // details of transaction itself
	    receipt.append(transactionType)
	           .append(" Transaction: ")
	           .append(transactionId)
	           .append("\nRegister: ")
	           .append(registerId)
	           .append("\nTransaction Date: ")
	           .append(transactionDate)
	           .append("\n----------------------------------------\n");
	    
	    // details for individual items
	    for (LineItem item : lineItems.values()) {
	        receipt.append(item.getProduct().getProductName())
	               .append("\n\tquantity: ")
	               .append(item.getQuantity())
	               .append("\n\tprice: ")
	               .append(item.getProduct().getPrice())
	               .append("\n\twarranties: ")
	               .append(item.getWarrantyQuantity())
	               .append("\n\tsubtotal: ")
	               .append(formatDollarAmount(item.getTotalCostWithWarranty()))
	               .append("\n");
	        subtotal += item.getTotalCostWithWarranty();
	    }
	    
	    // details for total
	    receipt.append("=======================================")
	           .append("\nSubtotal: ")
	           .append(formatDollarAmount(subtotal))
	           .append("\nTax: ")
	           .append(formatDollarAmount(subtotal * 0.0725))
	           .append("\nTOTAL: ")
	           .append(formatDollarAmount(calculateTransactionTotal()));
	           
	    // write to file
	    StringBuilder fileName = new StringBuilder();
	    fileName.append("receipt")
	            .append("_")
	            .append(transactionId)
	            .append("_")
	            .append(registerId)
	            .append(".txt");
	    
	    try {
	        PrintWriter receiptFile = new PrintWriter(fileName.toString());
	        receiptFile.write(receipt.toString());
	        receiptFile.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("File unable to be created");
	    }   
	}

	
	/**
	 * String representation used for output
	 * 
	 * @return <code>String</code> output for files and console
	 */
	public String toString() {
		return String.format("Transaction %d: %d %s totaling %s on register %d", 
				transactionId, getNumberOfProductsSold(), singularPlural(), 
				formatDollarAmount(calculateTransactionTotal()), registerId);
	}
	
	// Used in toString to express quantity correctly
	private String singularPlural() {
		if (getNumberOfProductsSold() == 1) {
			return "item";
		}
		return "items";
	}
	
	// Returns a String of the the amount passed in in dollar format; is  
	// enclosed in parentheses if it's a return
	private String formatDollarAmount(double amount) {
		if (transactionType == TransactionTypeEnum.SALE) {
			return String.format("$%,.2f", amount);
		}
		return String.format("($%,.2f)", Math.abs(amount));
	}
	
	/**
     * <code>String</code> value of the amount of all transactions completed
     * 
     * @return <code>String</code> of the total sales in dollar format; is 
     *         enclosed in parentheses if the amount is negative
     */
    public static String formatTotalSales() {
        if (totalSales >= 0) {
            return String.format("$%,.2f", totalSales);
        }
        return String.format("($%,.2f)", Math.abs(totalSales));
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
	public TransactionTypeEnum getTransactionType() {
		return transactionType;
	}
	
	public String getTransactionDate() {
	    return transactionDate;
	}
	
	public int getRegisterId() {
		return registerId;
	}
	
	public Map<String, LineItem> getLineItems() {
	    return lineItems;
	}
}
