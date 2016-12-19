package com.example.user.zooapp;

/**
 * Created by user on 16/12/2016.
 */
public class Funds {

    private int funds;

    public Funds(){
        funds = 500;
    }

    public int getFunds() {
        return funds;
    }

    public void addRemoveFunds(int funds) {
        this.funds += funds;
    }
}
