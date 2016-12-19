package com.example.user.zooapp;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by user on 19/12/2016.
 */
public class FundsTest {

    private Funds funds;

    @Before
    public void Before(){
        funds = new Funds();
    }

    @Test
    public void testPlayerStartsWith500(){
        assertEquals(500, funds.getFunds());
    }

    @Test
    public void testAddingRemovingFunds(){
        funds.addRemoveFunds(-150);
        assertEquals(350, funds.getFunds());
        funds.addRemoveFunds(300);
        assertEquals(650, funds.getFunds());
    }
}
