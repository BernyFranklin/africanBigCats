/*
 *  Frank Bernal
 *  CIS-059 Object Oriented Programming
 *  African Big Cats V.1.1
 *  Start:      25 August 2022
 *  Part 1:     25 August 2022
 *  Part 2:     16 September 2022
 */

package com.cis059;

// Import utilities
import java.util.*;

// Start of App
public class App {

    // Start of main
    public static void main( String[] args ) {
        // Code imported from assignement

        // Create new menu object
        Menu appMenu = new Menu();
        // Initialize command
        char command = '_';
        // New list
        LinkedList<Panthera> catList = new LinkedList<>(); 

        // loop until user quits
        while (command != 'q') {
            // print the menu
            appMenu.print();
            // get a command
            System.out.print("Enter a command: ");
            command = appMenu.getCommand();
            // execute a commmand
            appMenu.executeCommand(command, catList);
            // move the cats to new positions in africa
            appMenu.update(catList);
        }   // End of loop

    }   // End of main

}   // End of App
