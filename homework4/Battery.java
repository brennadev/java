import java.text.DecimalFormat;

/*
 * File: Battery.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 4/4/2017
 * Assignment: Homework assignment 4
 * 
 * Battery object
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

/**
 * Battery object
 * 
 * @author Brenna Olson
 */

public class Battery implements Consumable, 
                                Identifiable {
    private final int MAX_CAPACITY = 3000;
    private int capacity;
    private int id;
    
    /**
     * Create a new <code>Battery</code> object
     * 
     * @param id Unique numeric identifier
     * @param capacity Starting capacity for the battery
     */
    public Battery(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
    
    /**
     * Create a new <code>Battery</code> object
     * 
     * <p>The battery's id is set to 0 and the capacity to the max capacity
     */
    public Battery() {
        id = 0;
        capacity = MAX_CAPACITY;
    }

    /**
     * Use a given amount of the battery
     * 
     * @param amount Amount used
     * @return Amount remaining
     */
    public int consume(int amount) {
        capacity -= amount;

        // if the amount consumed is more than the amount remaining before 
        // consume was called
        if (capacity < 0) {
            capacity = 0;
            throw new OverConsumedException();
        }
      
        return capacity;
    }
    
    /**
     * Display details about a <code>Battery</code> instance
     * 
     * <p>String format is the following: "Battery: Id: [id], Percent Left: [percent left]"
     */
    public void printSummary() {
        StringBuilder batterySummary = new StringBuilder();
        batterySummary.append("Battery: ")
                      .append("Id: ")
                      .append(id)
                      .append(", Percent Left: ")
                      .append(getPercentBatteryLeft())
                      .append("%");
        
        
        System.out.println(batterySummary.toString());
    }
    
    public int getRemainingCapacity() {
        return capacity;
    }
    
    /**
     * Battery capacity with mAH after it
     * 
     * @return <code>String</code> containing "[capacity remaining] mAH"
     */
    public String getRemainingCapacityUnits() {
        StringBuilder units = new StringBuilder();
        
        units.append(capacity)
             .append(" mAH");
        
        return units.toString();
    }
  
    public double getPercentBatteryLeft() {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return Double.parseDouble(formatter.format((double)capacity / MAX_CAPACITY * 100));
    }
    
    public int getId() {
        return id;
    }
}
