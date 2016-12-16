package com.example.user.zooapp;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by user on 16/12/2016.
 */
public class ZooTest {

    private Zoo zoo;
    private Enclosure enclosure;

    @Before
    public void Before(){
        zoo = new Zoo("My first Zoo");
        enclosure = new Enclosure(EnclosureType.GHETTO.toString());
    }

    @Test
    public void testZooHasName(){
        assertEquals("My first Zoo", zoo.getName());
    }

    @Test
    public void testCreateEnclosure(){
        zoo.addEnclosureToZoo(enclosure);
        assertEquals(enclosure, zoo.selectEnclosureByIndex(0));
    }



}
