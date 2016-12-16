package com.example.user.zooapp;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by user on 16/12/2016.
 */
public class AnimalTest {

    private Animal animal;

    @Before
    public void Before(){
        animal = new Animal(SpeciesType.GNOME, "Fred");
    }

    @Test
    public void testAnimalName(){
        assertEquals("Fred", animal.getName());
    }

    @Test
    public void testAnimalSpecies(){
        assertNotNull(animal.getSpecies());
        System.out.println(animal.getSpecies());
    }
}
