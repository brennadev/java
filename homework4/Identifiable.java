/*
 * File: Identifiable.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 4/4/2017
 * Assignment: Homework assignment 4
 * 
 * Details about an object
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Details about an object
 * 
 * @author Brenna Olson
 */
public interface Identifiable {
    /**
     * Unique numeric value for an item
     * 
     * @return Integer of a unique numeric value for the item
     */
    public int getId();
    
    /**
     * Display details about the object
     */
    public void printSummary();
}
