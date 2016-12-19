package com.example.user.zooapp;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class Animal {

    private SpeciesType species;
    private String name;
    private ArrayList<EnclosureType> habitats;
    private int hunger;
    private AssignHabitats assignHabitats = new AssignHabitats();

    public Animal(SpeciesType species, String name){
        this.species = species;
        this.name = name;
        this.hunger = 50;

    }

    public SpeciesType getSpecies() {
        return this.species;
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
