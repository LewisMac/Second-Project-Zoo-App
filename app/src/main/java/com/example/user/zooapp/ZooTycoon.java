package com.example.user.zooapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by user on 16/12/2016.
 */
public class ZooTycoon extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final DatabaseHandler db = ((MainApplication) getApplication()).db;
        db.addEnclosure(new Enclosure(EnclosureType.AQUARIUM.toString()));
        db.addEnclosure(new Enclosure(EnclosureType.ARCTIC.toString()));
        db.addEnclosure(new Enclosure(EnclosureType.AVIARY.toString()));
        db.addEnclosure(new Enclosure(EnclosureType.CAGE.toString()));
        db.addEnclosure(new Enclosure(EnclosureType.CAVE.toString()));
        db.addEnclosure(new Enclosure(EnclosureType.GHETTO.toString()));
        db.addEnclosure(new Enclosure(EnclosureType.PADDOCK.toString()));

        db.addAnimal(new Animal(SpeciesType.DRAGON.toString(), "Barnie"));
    }
}
