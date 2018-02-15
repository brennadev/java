/*
 * File: InputOutput.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 2/1/2017
 * Assignment: Homework assignment 2
 * 
 * Handle file input and output for a ProductCatalog instance and 
 * RetailTransaction instances
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */
import java.io.*;
import java.util.Scanner;

/**
 * Handle file input for a <code>ProductCatalog</code> instance and 
 * <code>RetailTransaction</code> instances
 * 
 * @author Brenna Olson
 */
public class InputOutput {
	
	/**
	 * Get input from a file named retail_store.txt with 
	 * <code>ProductCatalog</code> data followed by 
	 * <code>RetailTransaction</code> data and write to an output file named
	 * transaction_summary.txt, calculating the total sales at a store
	 * 
	 * <p>The input file format is as follows:
	 * 
	 * <p>Product catalog (products in no particular order):
	 * 
	 * <ul>
	 * <li><code>CellPhone</code>:  	cell phone,[price],[name],[warranty eligible],[carrier]
	 * <li><code>Headphones</code>: 	headphones,[price],[name],[warranty eligible],[brand],[bluetooth capable]
	 * <li><code>Television</code>: 	television,[price],[name],[warranty eligible],[brand],[screen size]
	 * <li><code>LaptopComputer</code>: laptop,[price],[name],[warranty eligible],[brand]
	 * <li><code>HdmiCable</code>: 		HDMI cable,[price],[name],[warranty eligible],[length in feet]
	 * </ul>
	 * 
	 * <p>Retail transaction:
	 * <ul>
	 * <li>Transaction,[transaction id],[register id],[sale/return]
	 * <li>(repeated for every item) [product type],[quantity],[number of warranties]
	 * <li>End Transaction
	 * </ul>
	 * 
	 * <p>The output file format is as follows:
	 * <ul>
	 * <li>(repeated for every transaction) Transaction [transaction id]: [quantity] items totaling [total] on register [register id]
	 * <li>Total Sales: [total for all transactions]
	 * </ul>
	 * 
	 * @param catalog <code>ProductCatalog</code> instance for the products 
	 * 		          contained in the input file
	 */
	public static void readInputWriteOutput(ProductCatalog catalog) {
		
		try {

			File inputFile = new File("retail_store.txt");
			PrintWriter outputFile = new PrintWriter("transaction_summary.txt");

			try (Scanner scanner = new Scanner(inputFile)) {
				RetailTransaction transaction;
				
				scanner.useDelimiter(",");

				// get product catalog
				while (!scanner.hasNext("Transaction")) {
					catalog.addItem(scanner.nextLine());
				}

				while (scanner.hasNext()) {
					// get attributes that belong to the transaction itself
					transaction = new RetailTransaction(scanner.nextLine().substring(12));
					
					// get each item in the transaction
					String next = scanner.nextLine();
					while (!next.equals("End Transaction")) {
						transaction.addItem(next, catalog);
						next = scanner.nextLine();
					}
					
					// display transactions/write transactions to file
					System.out.println(transaction);
					outputFile.println(transaction);
				}
				
				// display total/write total to file
				System.out.println(String.format("Total Sales: %s", RetailTransaction.formatTotalSales()));
				outputFile.println(String.format("Total Sales: %s", RetailTransaction.formatTotalSales()));
				scanner.close();
			} 
			outputFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}
