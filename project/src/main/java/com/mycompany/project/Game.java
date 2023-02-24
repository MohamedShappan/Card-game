/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mohamed shappan
 */
public class Game {
    static Card Deck[]=new Card[52];
    int winner;
    int high=0;
    Player players[]=new Player[4];
    public void setdeck(){
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
                if(j<=9){
                    Deck[(i*13)+j]=new Card(i,j,j+1);
                }
                else{
                    Deck[(i*13)+j]=new Card(i,j,10);
                }
            }
        }
    }
    public Card carddraw(int i){
        Random rand=new Random();
               int random=rand.nextInt(52);
                while(Deck[random]==null)
                    random=rand.nextInt(52);
                Card card=Deck[random];
                players[i].score+=card.getValue();
                Deck[random]=null;
                return card;
    }
    public void setinf(String s,int i){
        Player ply=new Player();
        ply.setName(s);
        players[i]=ply;
        players[i].playerHand[0]=carddraw(i);
        players[i].playerHand[1]=carddraw(i);
    }
    public Card getCard(int i) { 
    return Deck[i]; 
  }
  public void highscore(int score,int index){
      if(this.high<score){
          this.high=score;
          winner=index;
      }
      else if(this.high==score){
          winner=-1;
      }
  }
}

