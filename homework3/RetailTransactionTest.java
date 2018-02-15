/*
 * File: RetailTransactionTest.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 1/25/2017
 * Assignment: Homework assignment 3
 * 
 * RetailTransaction unit tests
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class RetailTransactionTest {

  @Test
  public void testScanItem1() {
      RetailTransaction transaction = new RetailTransaction(1, 1, 
                                                            "2016-12-12 15:43:23", 
                                                            TransactionTypeEnum.SALE);
      CellPhone item = new CellPhone("123", 199.99, "iPhone 4s", true, "Apple", 
                                     "Verizon");
      transaction.scanItem(item, 2, 0);
      assertTrue(transaction.getLineItems().keySet()
                 .contains(item.getProductId()));
  }
  
  @Test
  public void testScanItem2() {
      RetailTransaction transaction = new RetailTransaction(2, 235, 
                                                            "2017-02-23 03:32:43", 
                                                            TransactionTypeEnum.RETURN);
      Headphones item1 = new Headphones("2", 249.99, "Bose QC25", true, "Bose", 
                                        false);
      Headphones item2 = new Headphones("1112", 299.99, "Bose QC35", true, "Bose", 
                                        true);
      transaction.scanItem(item1, 5, 0);
      transaction.scanItem(item2, 3, 2);
      assertTrue(transaction.getLineItems().keySet()
                 .contains(item1.getProductId()));
      assertTrue(transaction.getLineItems().keySet()
                 .contains(item2.getProductId()));
  }

  @Test
  public void testCalculateTransactionTotal1() {
      RetailTransaction transaction = new RetailTransaction(1, 1, 
                                                            "2017-01-01 11:23:32", 
                                                            TransactionTypeEnum.SALE);
      Headphones item1 = new Headphones("2", 249.99, "Bose QC25", true, "Bose", 
                                        false);
      Headphones item2 = new Headphones("1112", 299.99, "Bose QC35", true, 
                                        "Bose", true);
      transaction.scanItem(item1, 5, 0);
      transaction.scanItem(item2, 3, 2);
      assertTrue(transaction.calculateTransactionTotal() == 2370.137055);
  }
  
  public void testCalculateTransactionTotal2() {
      RetailTransaction transaction = new RetailTransaction(2, 235, 
                                                            "2017-02-23 03:32:43", 
                                                            TransactionTypeEnum.RETURN);
      CellPhone item1 = new CellPhone("123", 199.99, "iPhone 4s", true, "Apple", 
                                      "Verizon");
      Headphones item2 = new Headphones("1112", 299.99, "Bose QC35", true, 
                                        "Bose", true);
      transaction.scanItem(item1, 3, 1);
      transaction.scanItem(item2, 6, 2);
      assertTrue(transaction.calculateTransactionTotal() == 2659.7002575);
  }

  @Test
  public void testGetNumberOfProductsSold1() {
      RetailTransaction transaction = new RetailTransaction(1, 1, 
                                                            "2017-01-01 11:23:32", 
                                                            TransactionTypeEnum.SALE);
      CellPhone item1 = new CellPhone();
      Headphones item2 = new Headphones();
      transaction.scanItem(item1, 2, 0);
      transaction.scanItem(item2, 5, 0);
      assertEquals(transaction.getNumberOfProductsSold(), 7);
  }
  
  @Test
  public void testGetNumberOfProductsSold2() {
      RetailTransaction transaction = new RetailTransaction(1, 1, 
                                                            "2016-04-02 18:27:54", 
                                                            TransactionTypeEnum.SALE);
      CellPhone item1 = new CellPhone();
      Headphones item2 = new Headphones();
      transaction.scanItem(item1, 3, 0);
      transaction.scanItem(item2, 7, 0);
      transaction.scanItem(item1, 6, 0);
      assertEquals(transaction.getNumberOfProductsSold(), 16);
  }
  
  @Test
  public void testGetNumberOfProductsSold3() {
      RetailTransaction transaction = new RetailTransaction(1, 2, 
                                                            "2017-02-23 06:25:12", 
                                                            TransactionTypeEnum.RETURN);
      CellPhone item1 = new CellPhone("111", 199.99, "iPhone 4s", true, "Apple", 
                                      "Verizon");
      CellPhone item2 = new CellPhone();
      Headphones item3 = new Headphones("2", 249.99, "Bose QC25", true, "Bose", 
                                        false);
      Headphones item4 = new Headphones("1112", 299.99, "Bose QC35", true, 
                                        "Bose", true);
      Headphones item5 = new Headphones();
      transaction.scanItem(item1, 1, 1);
      transaction.scanItem(item2, 3, 0);
      transaction.scanItem(item3, 2, 0);
      transaction.scanItem(item4, 5, 4);
      transaction.scanItem(item5, 4, 0);
      assertEquals(transaction.getNumberOfProductsSold(), 15);
  }

}
