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

    
}
