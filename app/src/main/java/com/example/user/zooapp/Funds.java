package com.example.user.zooapp;

import java.util.Random;

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

    public int assignBuyPrice(Animal animal){

        Random rand = new Random();

        int price = 0;

        switch (animal.getSpecies()){
            case HIPPOCAMPUS:

            case SELKIE:
                price = rand.nextInt(20) + 20;
                break;
            case SEAHORSE:
                price = rand.nextInt(10) + 5;
                break;
            case GRIFFIN:
                price = rand.nextInt(40) + 20;
                break;
            case HIPPOGRIFF:
                price = rand.nextInt(30) + 20;
                break;
            case YETI:
                price = rand.nextInt(50) + 50;
                break;
            case DRAGON:
                price = rand.nextInt(50) + 100;
                break;
            case UNICORN:
                price = rand.nextInt(50) + 50;
                break;
            case WEREWOLF:
                price = rand.nextInt(40) + 40;
                break;
            case GNOME:
                price = rand.nextInt(20) + 10;
                break;
            case LEPRECHAUN:
                price = rand.nextInt(20) + 20;
                break;
            case CENTAUR:
                price = rand.nextInt(30) + 20;
                break;
        }
        return price;
    }

    public int assignSellPrice(Animal animal){
        Random rand = new Random();

        int price = 0;

        switch (animal.getSpecies()){
            case HIPPOCAMPUS:

            case SELKIE:
                price = rand.nextInt(20) + 10;
                break;
            case SEAHORSE:
                price = rand.nextInt(10) + 0;
                break;
            case GRIFFIN:
                price = rand.nextInt(40) + 10;
                break;
            case HIPPOGRIFF:
                price = rand.nextInt(30) + 10;
                break;
            case YETI:
                price = rand.nextInt(50) + 20;
                break;
            case DRAGON:
                price = rand.nextInt(50) + 50;
                break;
            case UNICORN:
                price = rand.nextInt(50) + 20;
                break;
            case WEREWOLF:
                price = rand.nextInt(40) + 20;
                break;
            case GNOME:
                price = rand.nextInt(20) + 5;
                break;
            case LEPRECHAUN:
                price = rand.nextInt(20) + 5;
                break;
            case CENTAUR:
                price = rand.nextInt(30) + 10;
                break;
        }
        return price;
    }
}
