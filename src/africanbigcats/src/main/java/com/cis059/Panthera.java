package com.cis059;

// Start of Panthera
public class Panthera extends PantheraGPS {
    // constructor
    public Panthera(String name) {
        // call the super-class (parent) to instatiate it
        super(name);
        // initialize attributes
        this.setSpecies("panthera");
    }   // End of constructor

    // serializes attributes into a string
    @Override // override superclass method
    public String toString() {
        // Locals
        String s;
        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + this.name();
        s += ", ";
        s += "species: " + this.species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += " }";
        return s;
    }   // End of toString

}   // End of Panthera
