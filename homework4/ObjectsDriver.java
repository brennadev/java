/*
 * File: ObjectsDriver.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 4/4/2017
 * Assignment: Homework assignment 4
 * 
 * Driver class for different object types
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * Driver class for different object types
 * 
 * @author Brenna Olson
 */
public class ObjectsDriver {
  public static void main(String[] args) {
      ArrayList<Identifiable> loadedData = new ArrayList<Identifiable>();
      
      // read data input file
      FileInputStream fstream = null; 
      
      try {
        fstream = new FileInputStream("program_data.dat");
        DataInputStream input = new DataInputStream(fstream);

        boolean isAtEndOfFile = false;

        while (!isAtEndOfFile) {
          try {

            // get code
            char objectCode = input.readChar();
            
            // get id
            int id = input.readInt();

            // get specific fields based on the code
            switch(objectCode) {
              case 'P':
                int diameter = input.readInt();
                String flavor = input.readUTF();
                loadedData.add(new Pizza(id, diameter, flavor));
                break;
              case 'B':
                int startingCapacity = input.readInt();
                loadedData.add(new Battery(id, startingCapacity));
                break;
              case 'L':
                String color = input.readUTF();
                loadedData.add(new Luggage(id, color));
                break;
            }

            
          } catch (EOFException eofe) {
            isAtEndOfFile = true;
            input.close();
          }
        }

      } catch(FileNotFoundException fnfe) {
          System.out.println("File not found.");
          System.exit(1);
        
      } catch(IOException ioe) {
        System.out.println("Unable to read file.");
        System.exit(1);
             
      } finally {
          if (fstream != null) {
            try {
                fstream.close();
            } catch(IOException ioe) {
                System.out.println("File cannot be closed.");
                System.exit(1);
            }
          }
      }
      
      
      // process consumption of objects
      File consumptionInstructions = null;

      try {
          consumptionInstructions = new File("consumption_instructions.txt");
          Scanner consumptionInputScanner = new Scanner(consumptionInstructions);
          
          // go one line at a time
          for(int lineNumber = 1; consumptionInputScanner.hasNext(); lineNumber++) {
               String line = consumptionInputScanner.nextLine();
               String[] tokens = line.split(",");
               int id = Integer.parseInt(tokens[0]);
               int amountToConsume = Integer.parseInt(tokens[1]);
               
               boolean isInLoadedData = false;
               StringBuilder message = new StringBuilder();
               message.append(lineNumber)
               .append(" - ")
               .append(id);
               
               // see if an element in loadedData is the one to be added; drop
               // out of loop after finding an object whose id matches
               for(int i = 0; i < loadedData.size() && !isInLoadedData; i++) {
                   // check if the object's id matches the id found in the file
                   if (loadedData.get(i).getId() == id) {
                       isInLoadedData = true;
                       
                       // perform consume - object is a Consumable
                       if (loadedData.get(i) instanceof Consumable) {
                           try {
                               ((Consumable)loadedData.get(i)).consume(amountToConsume);
                               message.append(" has ")
                                      .append(((Consumable)loadedData.get(i)).getRemainingCapacityUnits())
                                      .append(" remaining.");
                               System.out.println(message.toString());
                               
                           // not enough capacity
                           } catch(OverConsumedException oce) {
                               message.append(" didn't have enough and now is empty.");
                               System.out.println(message.toString());
                           }
                       // object isn't a Consumable    
                       } else {
                           message.append(" not consumable.");
                           System.out.println(message.toString());
                       }
                   }
               }
               
               // object isn't in loadedData
               if (!isInLoadedData) {
                   message.append(" not found");
                   System.out.println(message.toString());
               }
          }

          consumptionInputScanner.close();
      } catch(FileNotFoundException fnfe) {
          System.out.println("File not found.");
          System.exit(1);
      } 
      
      System.out.println("-------------------------------");
      
      // display summary for each object
      for (Identifiable object : loadedData) {
          object.printSummary();
      }
  }
}
