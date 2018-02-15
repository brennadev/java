/*
 * File: OverConsumedException.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 4/9/2017
 * Assignment: Homework assignment 4
 * 
 * Exception thrown when a Consumable has more of it consumed than what remains
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Exception thrown when a Consumable has more of it consumed than what remains
 * 
 * @author Brenna Olson
 */
public class OverConsumedException extends IllegalArgumentException {
    /**
     * Create exception intended for use with <code>Consumable</code>'s 
     *      <code>consume</code>
     */
    public OverConsumedException() {
        super("Consumed more than remaining amount");
    }
}
