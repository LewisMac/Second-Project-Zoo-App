package com.example.user.zooapp;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class Zoo {

    private ArrayList<Enclosure> enclosures;
    private String name;

    public Zoo(String name){
        this.name = name;
        enclosures = new ArrayList<>();
    }

    public void addEnclosureToZoo(Enclosure enclosure){
        enclosures.add(enclosure);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Enclosure selectEnclosureByIndex(int index){
        return enclosures.get(index);
    }


}
