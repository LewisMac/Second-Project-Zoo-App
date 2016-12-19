package com.example.user.zooapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 16/12/2016.
 */
public class Enclosure {

    private EnclosureType enclosureType;
    private ArrayList<Animal> animalsContained;
    private int id;

    public Enclosure(int id, int enclosureType){
        this.id = id;
        this.enclosureType = EnclosureType.values()[enclosureType];
        animalsContained = new ArrayList<>();
    }

    public Enclosure(EnclosureType enclosureType){
        this.enclosureType = enclosureType;
        animalsContained = new ArrayList<>();

    }

    public String getEnclosureType() {
        return enclosureType.toString();
    }

    public Animal getAnimalByIndex(int index){
        return animalsContained.get(index);
    }

    public String addAnimalToEnclosure(Animal animal){
        String message = "That is not possible";
        AssignHabitats assignHabitats = new AssignHabitats();

        if (assignHabitats.animalCanLiveInEnclosureType(animal.getSpeciesType(), this.enclosureType.toString())){
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

    public int getEnclosureTypeOrdinal(){
        return this.enclosureType.ordinal();
    }


}
