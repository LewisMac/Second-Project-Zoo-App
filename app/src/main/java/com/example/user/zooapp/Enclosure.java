package com.example.user.zooapp;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class Enclosure {
    private EnclosureType enclosureType;
    private ArrayList<Animal> animalsContained;

    public Enclosure(EnclosureType enclosureType){
        this.enclosureType = enclosureType;
        animalsContained = new ArrayList<>();
    }

    public EnclosureType getEnclosureType() {
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

}
