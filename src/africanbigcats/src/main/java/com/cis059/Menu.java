package com.cis059;

// Import utilities
import java.util.*;

// Start of Menu
public class Menu {

    // attributes
    private Scanner input;

    // constructor
    public Menu() {
        // initialize attributes
        this.input = new Scanner(System.in);
    }   // End of Menu constructor

    // print() displays the menu to the user
    public void print() {
        printLine();
        System.out.println("African Big Cats App");
        printLine();
        printCommand('c',"[C]reates a big cat");
        printCommand('d',"[D]eletes a big cat");
        printCommand('f',"[F]inds a big cat");
        printCommand('l',"[L]ists all big Cats");
        printCommand('q',"[Q]uits");
        printLine();
    }   // End of print()

    // printLine() prints a dashed line across screen
    private static void printLine() {
        
        System.out.println("----------------------------------------------------------" );
    }   // End of printLine()

    // printCommand() formats and prints a string for command options
    private static void printCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }   // End of printCommand()

    // getCommand() reads input from the scanner object and returns a char
    public Character getCommand() {
        Character command = '_';
        // Reads user input
        String rawInput = input.nextLine();
        
        // if string is > 0 chars
        if (rawInput.length() > 0) {
            // Convert to lowercase
            rawInput = rawInput.toLowerCase();
            // Convert to char
            command = rawInput.charAt(0);
        }   // End of if

        // Return char
        return command;
    }   // End of getCommand()

    // executeCommand() runs through the options and executes the appropriate method
    public Boolean executeCommand(Character command, LinkedList<Panthera> catList) {
        Boolean success = true;
        
        // Enter switch for valid options
        switch(command) {
            case 'c':
                executeCreate(catList);
                break;
            case 'd':
                executeDelete(catList);
                break;
            case 'f':
                executeFind(catList);
                break;
            case 'l':
                executeList(catList);
                break;
            case 'q':
                executeQuit();
                break;
            default:
            // Error checking
                System.out.println("ERROR: Unknown commmand");
                success = false;
          }
        return success;
    }   // End of executeCommand()

    // update() takes catList and updates the location of each cat
    public void update(LinkedList<Panthera> catList) {
        // iterates through each cat object and moves them
        for (Panthera cat: catList) {
            cat.move();
        }
    }   // End of update()

    // executeQuit() quits the app
    public void executeQuit() {
        // close the scannner
        input.close();
        System.out.println();
        printLine();
        System.out.println("Thank you for using the African Big Cats App!");
        printLine();
        System.out.println();
    }   // End of executeQuit()

    // getNewCat() creates a new cat object with a name and appropriate species
    public Panthera getNewCat(String name) {
        
        // Locals
        char cat = ' ';
        Panthera dummyLoad = new Panthera(name);   // Used as a placeholder until valid species seleted

        // Call selectCat method
        cat = selectCat();

        // Create correct cat
        switch (cat) {
            case 't':
                Panthera tiger = new Tiger(name); 
                return tiger;
            case 'l':
                Panthera lion = new Lion(name);
                return lion;
            case 'j':
                Panthera jaguar = new Jaguar(name);
                return jaguar;
            default:
                System.out.println("Invalid selection");
                break;
        }   // End of switch

        // Should never execute
        return dummyLoad;
    }   // End of getNewCat

    // executeCreate() prompts user for cat name, checks for unique name, and species
    public void executeCreate(LinkedList<Panthera> catList) {
        // Flag for unique name
        boolean unique = false;
        String name = "";
        
        // get the name, loop until unique name found
        while (!unique) {
            System.out.println();
            System.out.print("Enter a name for the big cat to create: ");
            name = input.nextLine();
            
            // Call function for unique names
            unique = isUnique(name, catList);

            // If Name isn't unique alert user
            if (!unique) {
                System.out.println("That name is already in use, please enter a different name");
            }
            System.out.println();

        }   // End of loop

        // Sends name to new cat object
        Panthera cat = getNewCat(name);
        // Adds cat to list
        catList.add(cat);
    }   // End of executeCreate()
    
    // executeList() displays all cats on list
    public void executeList(LinkedList<Panthera> catList) {
        System.out.println();
        printLine();
        System.out.println("African Big Cat List");
        printLine();
        Panthera cat;
        if (catList.size() > 0) {
            for (Integer i = 0; i < catList.size(); i++) {
                cat = catList.get(i);
                System.out.println(cat);
            }
        } else {
            System.out.println("There are no African Big Cats. :(");
        }
        System.out.println();
    }   // End of executeList()

    // selectCat() requests species selection and only accepts t, l ,j
    public char selectCat () {
        // Locals
        boolean valid = false;           // Flag for menu loop
        char cat = ' ';                  // Initialize cat
        char[] cats = {'t', 'l', 'j'};   // Valid inputs

        // Loop menu until valid input detected
        while (!valid) {
            String str = "";
            printLine();
            System.out.printf ("Please select the species of the cat\n");
            printCommand('t', "[T]iger");
            printCommand('l', "[L]ion");
            printCommand('j', "[J]aguar");
            printLine();
            System.out.println("Enter selection: ");
            // Read input
            str = input.nextLine();
            // Convert to lower
            str = str.toLowerCase();
            // Send 1st char as selection
            cat = str.charAt(0);

            // Iterate through array and compare if selection was valid
            for (int i = 0; i < cats.length; i++) {
                if (cat == cats[i]) {valid = true;}
            }   // End of for

            // If not valid, print error
            if (!valid) {
                System.out.printf ("\nInvalid cat selection, please try again\n\n");
            }   // End of validity check
        }   // End of menu loop

        // Return valid input
        return cat;
    }   // End of selectCat

    // isUnique() compares input name across all names in list, returns bool
    public boolean isUnique (String name, LinkedList<Panthera> catList) {
        boolean unique = true;

        for (Panthera cat: catList) {
            if (name.equalsIgnoreCase(cat.name())) {unique = false;}
        }
        return unique;
    }   // End of isUnique

    // executeDelete() finds input name and removes that cat from the list
    public void executeDelete(LinkedList<Panthera> catList) {
        String name = "";

        System.out.println();
        System.out.print("Enter a name for the big cat to delete: ");
        name = input.nextLine();
            
        for (Panthera cat: catList) {
            if (name.equals(cat.name())) {
                catList.remove(cat);
            }   // End of if
        }   // End of for
    }   // End of executeDelete

    // executeFind() searches for partial match and returns all cats with match
    public void executeFind(LinkedList<Panthera> catList) {
        String name = "";
        boolean found = false;
        System.out.println();
        System.out.print("Enter a name for the big cat to find: ");
        name = input.nextLine();
        printLine();
        System.out.printf("\nThe follwing big cats were found containing \'%s\'\n", name);
        printLine();
        for (Panthera cat: catList) {
            if (cat.name().contains(name)) {
                System.out.println(cat);
                found = true;
            }
        }   // End of for

        if (!found) {
            System.out.println("No Results");
        }  // End of not found

    }   // End of executeFind

}   // End of Menu 
