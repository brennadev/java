/*
 * File: GenerateFiles.java
 * Student: Brenna Olson
 * Course: CSCI 1125-30
 * Date: 4/18/2017
 * Assignment: Homework assignment 4
 * 
 * Driver to generate files for homework 4
 *
 * Copyright © 2017 Brenna Olson. All rights reserved.
 * REUSE AND REDISTRIBUTION NOTICE: You may not modify or redistribute this code in any form including, but not limited to, source or binary. You may download it for informational purposes only.
 */

import java.io.*;

/**
 * Driver to generate files for homework 4
 * 
 * @author Brenna Olson
 */
public class GenerateFiles {
    public static void main(String [] args) {
      
        // Program Data files
        FileOutputStream fstream1 = null;
        FileOutputStream fstream2 = null;
        
        try {
            fstream1 = new FileOutputStream("test_program_data_1.dat");
            DataOutputStream programData1 = new DataOutputStream(fstream1);
            
            fstream2 = new FileOutputStream("test_program_data_2.dat");
            DataOutputStream programData2 = new DataOutputStream(fstream2);
            
            // first data file
            programData1.writeChar('P');
            programData1.writeInt(123);
            programData1.writeInt(5);
            programData1.writeUTF("Sausage");
            
            programData1.writeChar('L');
            programData1.writeInt(34);
            programData1.writeUTF("Black");
            
            programData1.writeChar('B');
            programData1.writeInt(55);
            programData1.writeInt(100);
            
            programData1.writeChar('L');
            programData1.writeInt(89);
            programData1.writeUTF("Blue");
            
            programData1.writeChar('B');
            programData1.writeInt(23);
            programData1.writeInt(520);
            
            programData1.writeChar('P');
            programData1.writeInt(38);
            programData1.writeInt(10);
            programData1.writeUTF("Pepperoni");
            
            
            // second data file
            programData2.writeChar('L');
            programData2.writeInt(21);
            programData2.writeUTF("Red");
            
            programData2.writeChar('B');
            programData2.writeInt(53);
            programData2.writeInt(894);
            
            programData2.writeChar('P');
            programData2.writeInt(36);
            programData2.writeInt(20);
            programData2.writeUTF("Cheese");
            
            programData2.writeChar('B');
            programData2.writeInt(45);
            programData2.writeInt(232);
            
            programData2.writeChar('P');
            programData2.writeInt(12);
            programData2.writeInt(2);
            programData2.writeUTF("Pineapple");
            
            programData1.close();
            programData2.close();
          
        } catch(IOException ioe) {
            System.out.println("Error opening file.");
            System.exit(1);
        } 
        
        // Consumption Instructions files
        PrintWriter consumptionInstructions1 = null;
        PrintWriter consumptionInstructions2 = null;
          
        try {
            // first instructions file
            consumptionInstructions1 = new PrintWriter("consumption_instructions_1.txt");
            consumptionInstructions1.println("55,50");
            consumptionInstructions1.println("36,2");
            consumptionInstructions1.println("89,1");
            consumptionInstructions1.println("123,3");
            consumptionInstructions1.println("55,25");
            
            // second instructions file
            consumptionInstructions2 = new PrintWriter("consumption_instructions_2.txt");
            consumptionInstructions2.println("38,2");
            consumptionInstructions2.println("45,100");
            consumptionInstructions2.println("45,300");
            consumptionInstructions2.println("89,2");
            
        } catch(FileNotFoundException fnfe) {
            System.out.println("File not found.");
            System.exit(1);
        } finally {
            if (consumptionInstructions1 != null) {
                consumptionInstructions1.close();
                
            }
            
            if (consumptionInstructions2 != null) {
                consumptionInstructions2.close();
            }
        }
    }
}
