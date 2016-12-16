package com.example.user.zooapp;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class Enclosure {

    private String enclosureType;
    private ArrayList<Animal> animalsContained;
    private int id;


    public Enclosure(int id, String enclosureType){
        this.id = id;
        this.enclosureType = enclosureType;
        animalsContained = new ArrayList<>();
    }

    public Enclosure(String enclosureType){
        this.enclosureType = enclosureType;
        animalsContained = new ArrayList<>();
    }

    public String getEnclosureType() {
        return enclosureType;
    }

    public Animal getAnimalByIndex(int index){
        return animalsContained.get(index);
    }

    public void addAnimalToEnclosure(Animal animal){
        animalsContained.add(animal);
    }

    public int getNumberOfAnimalsInEnclosure(){
        return animalsContained.size();
    }

    public void removeAnimalFromEnclosure(int index){
        animalsContained.remove(index);
    }

    public int getID(){
        return this.id;
    }

}
