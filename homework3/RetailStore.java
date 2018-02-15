/*
 * File: RetailStore.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 1/25/2017
 * Assignment: Homework assignment 3
 * 
 * Driver class for tracking sales and returns of a store's products
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

import java.io.*;
import java.util.Scanner;

/**
 * Driver class for tracking sales and returns of a store's products
 * 
 * @author Brenna Olson
 */
public class RetailStore {		

	/**
	 * Get input from a file named retail_store.txt with 
	 * <code>ProductCatalog</code> data followed by 
	 * <code>RetailTransaction</code> data and write to an output file named
	 * transaction_summary.txt, calculating the total sales at a store, and 
	 * generate a receipt for each transaction.
	 * 
	 * <p>The input file format is as follows:
	 * 
	 * <p>Product catalog (products in no particular order):
	 * 
	 * <ul>
	 * <li><code>CellPhone</code>:  	cell phone,[product id],[price],[name],[warranty eligible],[brand],[carrier]
	 * <li><code>Headphones</code>: 	headphones,[product id],[price],[name],[warranty eligible],[brand],[bluetooth capable]
	 * </ul>
	 * 
	 * <p>Retail transaction:
	 * <ul>
	 * <li>Transaction,[transaction id],[register id],[transaction date/time],[sale/return]
	 * <li>(repeated for every item) [product id],[quantity],[number of warranties]
	 * <li>End Transaction
	 * </ul>
	 * 
	 * <p>The output file format is as follows:
	 * <ul>
	 * <li>(repeated for every transaction) Transaction [transaction id]: [quantity] items totaling [total] on register [register id]
	 * <li>Total Sales: [total for all transactions]
	 * </ul>
	 */
	public static void main(String[] args) {
		ProductCatalog catalog = new ProductCatalog();

		try {

			File inputFile = new File("retail_store.txt");
			PrintWriter outputFile = new PrintWriter("transaction_summary.txt");

			try (Scanner scanner = new Scanner(inputFile)) {
				RetailTransaction transaction = new RetailTransaction();

				scanner.useDelimiter(",");

				// get product catalog
				while (!scanner.hasNext("Transaction")) {
					catalog.addProduct(getCatalogItem(scanner.nextLine()));
				}
				
				// get transactions
				while (scanner.hasNext()) {
					
				    // skip the word "transaction"
				    scanner.next();

					String next = scanner.nextLine();
					transaction = newTransaction(next.substring(1));
					next = scanner.nextLine();

					while (!next.equals("End Transaction")) {					  
					    addTransactionItem(next, transaction, catalog);
					    next = scanner.nextLine();
					}
					transaction.generateReceipt();
					System.out.println(transaction);
					outputFile.println(transaction);
				}

				// display total/write total to file
				System.out.println(String.format("Total Sales: %s", 
						RetailTransaction.formatTotalSales()));
				outputFile.println(String.format("Total Sales: %s", 
						RetailTransaction.formatTotalSales()));
				
				scanner.close();
			} 
			outputFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	
	/**
	 * Set up and return <code>Product</code> instance to be stored in a 
	 * <code>ProductCatalog</code>
	 * 
	 * @param item Product to be stored in catalog with the following format:
	 *             <p>[product type],[product id],[price],[name],[warranty eligible],[brand],[attributes unique to product]
	 * @return The <code>Product</code> instance to be added to the catalog
	 */
	private static Product getCatalogItem(String item) {
	    Product product = new Product();

	    try (Scanner newItem = new Scanner(item)) {
	        newItem.useDelimiter(",");

	        // set values for parts of the data that are the same across all product types
	        String type = newItem.next();
	        String id = newItem.next().trim();
	        double price = newItem.nextDouble();
            String name = newItem.next();
            boolean warrantyEligible = newItem.nextBoolean();
            String brand = newItem.next();
            
            // set values for parts of the data that are different between product types
            switch (type) {
            case "cell phone":
                product = new CellPhone(id, price, name, warrantyEligible, 
                                        brand, newItem.next());
                break;
             case "headphones":
                product = new Headphones(id, price, name, warrantyEligible, 
                                         brand, newItem.nextBoolean());
                break;    
            }
            newItem.close();
	    }
	    return product;
	}
	
	/**
	 * Set up and return a <code>RetailTransaction</code> instance. It does not
	 * add any items to the transaction.
	 * 
	 * @param transaction Transaction to be created with the following format:
	 *                    <p>[transaction id],[register id],[transaction date/time],[sale/return]
	 * @return The <code>RetailTransaction</code> instance with the values in 
	 *         <code>transaction</code>
	 */
	private static RetailTransaction newTransaction(String transaction) {
	    String[] tokens = transaction.split(",");
	    return new RetailTransaction(Long.parseLong(tokens[0]), 
	        Integer.parseInt(tokens[1]), tokens[2], 
	        (tokens[3].equals("sale") ? TransactionTypeEnum.SALE : TransactionTypeEnum.RETURN));
	}
	
	/**
	 * Set up a product to be added to a transaction and add it to the 
	 * transaction
	 * @param item Item to be added to the transaction with the following format:
	 *             <p>[product id],[quantity],[number of warranties]
	 * @param transaction <code>RetailTransaction</code> instance to add the
	 *                    item to
	 * @param catalog <code>ProductCatalog</code> instance <code>item</code> can
	 *                be looked up in
	 */
	private static void addTransactionItem(String item, 
	                                       RetailTransaction transaction, 
	                                       ProductCatalog catalog) {
	    String[] tokens = item.split(",");
	    transaction.scanItem(catalog.findProductByID(tokens[0]), 
	        Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
	}
}
