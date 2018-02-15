/*
 * File: Luggage.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 4/4/2017
 * Assignment: Homework assignment 4
 * 
 * Luggage object
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Luggage object
 * 
 * @author Brenna Olson
 */
public class Luggage implements Identifiable {
    private int id;
    private String color;
    
    /**
     * Create new <code>Luggage</code> object
     * 
     * @param id Unique numeric identifier for the luggage
     * @param color Color of the luggage
     */
    public Luggage(int id, String color) {
        this.id = id;
        this.color = color;
    }
    
    /**
     * Create new <code>Luggage</code> object with default values
     * 
     * <p>The id is set to 0 and the color to an empty string
     */
    public Luggage() {
        id = 0;
        color = "";
    }
    
    /**
     * Display details about a <code>Luggage</code> instance
     * 
     * <p>String format is the following: "Luggage: Id: [id], Color: [color]"
     */
    public void printSummary() {
        StringBuilder luggageSummary = new StringBuilder();
        luggageSummary.append("Luggage: ")
                      .append("Id: ")
                      .append(id)
                      .append(", Color: ")
                      .append(color);
        
        System.out.println(luggageSummary.toString());
    }
    
    public int getId() {
        return id;
    }
}
