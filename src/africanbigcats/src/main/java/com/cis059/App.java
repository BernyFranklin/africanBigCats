package com.cis059;

import java.util.*;

public class App {
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
    }   // End of main

}   // End of App
