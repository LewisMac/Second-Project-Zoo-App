package com.example.user.zooapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 16/12/2016.
 */
public class Enclosure {
    
    private String enclosureTypeString;
    private String enclosureType;
    private ArrayList<Animal> animalsContained;
    private int id;

    public Enclosure(int id, String enclosureType){
        this.id = id;
        this.enclosureType = enclosureType;
        enclosureTypeString = enclosureType.toString();
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

    public String addAnimalToEnclosure(Animal animal){
        String message = "That is not possible";
        AssignHabitats assignHabitats = new AssignHabitats();

        if (assignHabitats.animalCanLiveInEnclosureType(animal.getSpecies(), this.enclosureType)){
            animalsContained.add(animal);
            message = "Animal added";
        }
        return message;
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
