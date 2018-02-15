/*
 * File: Consumable.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 4/4/2017
 * Assignment: Homework assignment 4
 * 
 * Anything that has a capacity and is able to reduce capacity in some way
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Anything that has a capacity and is able to reduce capacity in some way
 * 
 * @author Brenna Olson
 */
public interface Consumable {
  
    /**
     * Use a given amount of the object
     * 
     * @param amount Amount to use in the object's units
     * @return Remaining capacity of the object in its units
     */
    public int consume(int amount);
    
    /**
     * Amount remaining of an object
     * 
     * @return Amount remaining of an object in its units
     */
    public int getRemainingCapacity();
    
    /**
     * Amount remaining of an object with details about its units
     * 
     * @return <code>String</code> with the object's remaining capacity and a
     *         textual description of the object's units after the capacity
     */
    public String getRemainingCapacityUnits();
}
