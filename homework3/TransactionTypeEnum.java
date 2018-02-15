/*
 * File: TransactionTypeEnum.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 2/28/2017
 * Assignment: Homework assignment 3
 * 
 * To store whether a transaction is a sale or return
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * To store whether a transaction is a sale or return
 * 
 * <p><code>UNDEFINED</code> is for default constructors in classes that have a
 * <code>TransactionTypeEnum</code> attribute.
 * 
 * @author Brenna Olson
 */
public enum TransactionTypeEnum {
    SALE,
    RETURN,
    
    /**
     * For default constructor use
     */
    UNDEFINED
}
