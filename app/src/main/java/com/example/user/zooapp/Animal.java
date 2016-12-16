package com.example.user.zooapp;

/**
 * Created by user on 16/12/2016.
 */
public class Animal {

    private String species;
    private String name;
    private int hunger;

    public Animal(String species, String name){
        this.species = species;
        this.name = name;
        this.hunger = 50;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public void feedAnimal(int food) {
        this.hunger += food;
    }
}
