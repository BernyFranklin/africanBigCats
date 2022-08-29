package com.cis059;

// Start of Jaguar
public class Jaguar extends Panthera{

    // Constructor
    public Jaguar(String name) {
        // call the super-class (parent) to instatiate it
        super(name);
        // initialize attributes
        this.setSpecies("jaguar");
        this.setSleepsInTrees(true);
    }   // End of constructor

    // serializes attributes into a string
    @Override // override superclass method
    public String toString() {
        // Locals
        String s;
        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + name();
        s += ", ";
        s += "species: " + species();
        s += ", ";
        s += "longitude: " + longitude();
        s += ", ";
        s += "latitude: " + latitude();
        s += ", ";
        s += "fur: " + fur();
        s += ", ";
        s += "sleeps in trees: " + sleepsInTrees();
        s += " }";
        return s;
    }   // End of toString

    // fur() returns the cat's fur pattern
    public String fur() {
        return "spots";
    }   // End of fur

}   // End of Jaguar
