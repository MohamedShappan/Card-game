/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

import java.util.Random;

public class Card {
    private final int suit;
    private final int rank;
    
    private final int value;

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    } 
    public Card(Card i){
        this.rank=i.getRank();
        this.suit=i.getSuit();
        this.value=i.getValue();
    }
    public int getSuit(){
        return suit;
    }
    public int getRank(){
        return rank;
    }   
    public int getValue(){
        if(this.value<10){
            return value;
        }
        else
           return 10;
    }
}
