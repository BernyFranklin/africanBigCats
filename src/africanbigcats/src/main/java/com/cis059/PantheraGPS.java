

package com.cis059;

import java.util.Random;

// Start of PamtheraGPS
public class PantheraGPS {
    // constants
    private final Integer maxLongitude = 1000;
    private final Integer maxLatitude = 1000;
    protected final float minSpeed = 0f;
    protected final float maxSpeed = 50.0f;
    // attributes
    private String name;
    private String species;
    private Float longitude;
    private Float latitude;
    private Random longitudeRandom;
    private Random latitudeRandom;
    private Boolean sleepsInTrees;
    // constructor
    public PantheraGPS(String name) {
        // initialize attributes
        this.name = name;
        this.species = "pantheraGPS";
        this.sleepsInTrees = false;
        // seed the random number generators for repeatable results
        this.longitudeRandom = new Random();
        this.longitudeRandom.setSeed(this.seed(name + "longitude"));
        this.latitudeRandom = new Random();
        this.latitudeRandom.setSeed(this.seed(name + "latitude"));
        // move the panthera into it's initial position
        this.longitude = longitudeRandom.nextFloat() * maxLongitude;
        this.latitude = latitudeRandom.nextFloat() * maxLatitude;
    }   // End of constructor

    // serializes attributes into a string
    public String toString() {
        // Locals
        String s;
        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + name;
        s += ", ";
        s += "species: " + this.species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += " }";
        return s;
    }   // End of toString

    // getters

    // Start of name
    public String name() {
        return this.name;
    }   // End of name

    // Start of species
    public String species() {
        return this.species;
    }   // End of species

    // Start of sleepsInTrees
    public Boolean sleepsInTrees() {
        return this.sleepsInTrees;
    }   // End of sleepsInTrees

    // setters

    // Start of setSpecies
    public void setSpecies(String species) {
        this.species = species;
    }   // End of setSpecies

    // Start of setSleepsInTrees
    public void setSleepsInTrees(Boolean sleepsInTrees) {
        this.sleepsInTrees = sleepsInTrees;
    }   // End of setSleepsInTrees

    // make a seed, based on the name
    private Integer seed(String s) {
        Integer seed = 0;
        for (Integer i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            seed += (int) ch;
        }   // End of for
        return seed;
    }   // End of seed

    // Start of move
    public void move() {
        this.longitude += longitudeRandom.nextFloat() * maxSpeed;
        this.latitude += latitudeRandom.nextFloat() * maxSpeed;
    }   // End of move

    // longitude of the panthera
    public Float longitude() {
        return longitude;
    }   // End longitude

    // latitude of the panthera
    public Float latitude() {
        return latitude;
    }   // End latitude

}   // End of PantheraGPS
