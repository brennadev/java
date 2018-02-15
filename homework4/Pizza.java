import java.text.DecimalFormat;

/*
 * File: Pizza.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 4/4/2017
 * Assignment: Homework assignment 4
 * 
 * Pizza object
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Pizza object
 * 
 * @author Brenna Olson
 */
public class Pizza implements Consumable, 
                              Identifiable {
    private int capacity = 8;
    private int id;
    
    private int diameter;
    private String flavor;
    
    /**
     * Create new <code>Pizza</code> object
     * 
     * @param id Unique numeric identifier
     * @param diameter Diameter of pizza
     * @param flavor Flavor of pizza
     */
    public Pizza(int id, int diameter, String flavor) {
        this.id = id;
        this.diameter = diameter; 
        this.flavor = flavor;
    }
    
    /**
     * Create new <code>Pizza</code> object
     * 
     * <p>The pizza's id is set to 0, diameter to 0, and flavor to an empty 
     * string
     */
    public Pizza() {
        id = 0;
        diameter = 0;
        flavor = "";
    }
    
    /**
     * Use a given amount of the pizza
     * 
     * @param amount Number of slices consumed
     * @return Number of slices remaining
     */
    public int consume(int amount) {
        
        capacity -= amount;

        // if the amount consumed is more than the amount remaining before consume was called
        if (capacity < 0) {
            capacity = 0;
            throw new OverConsumedException();
        }
        
        return capacity;
    }
    
    /**
     * Display details about a <code>Pizza</code> instance
     * 
     * <p>String format is the following: "Pizza: Id: [id], Diameter: [diameter], Flavor: [flavor], Remaining Surface Area: [remaining surface area]"
     */
    public void printSummary() {
        StringBuilder pizzaSummary = new StringBuilder();
        pizzaSummary.append("Pizza: ")
                    .append("Id: ")
                    .append(id)
                    .append(", Diameter: ")
                    .append(diameter)
                    .append(", Flavor: ")
                    .append(flavor)
                    .append(", Remaining Surface Area: ")
                    .append(getRemainingSurfaceArea());
        
        System.out.println(pizzaSummary.toString());
    }

    
    /**
     * Number of slices left
     * 
     * @return Number of slices
     */
    public int getRemainingCapacity() {
        return capacity;
    }
    
    /**
     * Number of slices left with "slices" after it
     * 
     * @return <code>String</code> containing "[number of slices] slices"
     */
    public String getRemainingCapacityUnits() {
        StringBuilder units = new StringBuilder();
        units.append(capacity)
             .append(" slices");
        
        return units.toString();
    }
    
    public int getId() {
        return id;
    }
    
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
    
    public double getRemainingSurfaceArea() {
      
        DecimalFormat formatter = new DecimalFormat("#0.00");
      
        return Double.parseDouble(formatter.format(Math.PI * Math.pow((diameter / 2), 2) * ((double)capacity / 8)));
    }
}
