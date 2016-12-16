package com.example.user.zooapp;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by user on 16/12/2016.
 */
public class EnclosureTest {

    private Enclosure enclosure;
    private Animal animal;

    @Before
    public void Before(){
        enclosure = new Enclosure(EnclosureType.AQUARIUM);
        animal = new Animal(SpeciesType.SEAHORSE, "Fred");
    }

    @Test
    public void testEnclosureHasType(){
        assertNotNull(enclosure.getEnclosureType());
    }

    @Test
    public void testEnclosureStartsEmpty(){
        assertEquals(0, enclosure.getNumberOfAnimalsInEnclosure());
    }

    @Test
    public void testCanAddAnimal(){
        enclosure.addAnimalToEnclosure(animal);
        assertEquals(1, enclosure.getNumberOfAnimalsInEnclosure());
        assertNotNull(enclosure.getAnimalByIndex(0));
    }

}
