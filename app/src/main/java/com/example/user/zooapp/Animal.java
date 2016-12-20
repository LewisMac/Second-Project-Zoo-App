package com.example.user.zooapp;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class Animal {

//    private SpeciesType species;
    private SpeciesType species;
    private String name;
    private int hunger;
    private int id;
    private int enclosureId;

    public Animal(SpeciesType species, String name){
        this.species = species;
//        this.speciesString = species;
        this.name = name;
        this.hunger = 50;

    }

    public Animal(int id, int species, String name, int enclosureId){
//        this.speciesString = species;
        this.species = SpeciesType.values()[species];
        this.name = name;
        this.hunger = 50;
        this.id = id;
        this.enclosureId = enclosureId;
    }

    public String getSpecies() {
        return this.species.toString();
    }

    public SpeciesType getSpeciesType(){
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

    public int getId(){
        return this.id;
    }

    public int getEnclosureId(){
        return this.enclosureId;
    }

    public void setEnclosureId(int enclosureId){
        this.enclosureId = enclosureId;
    }

    public int getSpeciesTypeOrdinal(){
        return this.species.ordinal();
    }
}
