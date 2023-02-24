/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

import java.util.Random;

/**
 *
 * @author mohamed shappan
 */
public class Player {
    String name;
    int i=2;
    int score=0;
    boolean youDone=false;
    boolean lost=false;
    Card[] playerHand = new Card[10];
    int num;
  
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
      public void hit(Card card){
		
		System.out.println("\tYou Choose to Hit.\n");
                playerHand[i]=card;
		System.out.printf("Your Score:%d\t", score);
		i+=1;
		if(score>21){
                    System.out.println();
                    System.out.println("\t\t\t\t#            #");
                    System.out.println("\t\t\t\t# YOU BUSTED #");
                    System.out.println("\t\t\t\t#            #");
                        lost=true;
                }
	}
      public void stay(){
		
		System.out.println("\tYou Choose to Stay.\n");
                System.out.println("\t your score is: "+score);
		youDone = true;
	}
    public boolean checkIfBlackJack(){
        boolean blackJack = false;
	if(score == 21){
            System.out.println("\t\t\t#################################");
            System.out.println("\t\t\t\t#                               #");
            System.out.println("\t\t\t\t# HURRAY!!...BLACKJACK, YOU WON #");
            System.out.println("\t\t\t\t#                               #");
            System.out.println("\t\t\t\t#################################\n");
            blackJack=true;
        }
        else{
            System.out.println("\tIt could have been a BlackJack for you...\n");
            blackJack = false;
        }
        return blackJack;
    }
}
