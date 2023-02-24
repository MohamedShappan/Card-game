/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;
import java.util.Scanner;

/**
 *
 * @author mohamed shappan
 */
public class Blackjack {
    public static void main(String[] args){
        GUI gui=new GUI();
        Game game=new Game();
        game.setdeck();
        Scanner in=new Scanner(System.in);
        String name;
        for(int i=0;i<4;i++){
            System.out.println("Enter player Name :");
            name=in.next();
            game.setinf(name, i);
        }
        int check=0;
         gui.runGUI(game.Deck, game.players[0].playerHand, game.players[1].playerHand, game.players[2].playerHand, game.players[3].playerHand);
        for(int i=0;i<3;i++){
            System.out.println("Your score : "+game.players[i].score);
            System.out.println("\tChoose to hit or stay??");
            String state=in.next();
            while("hit".equals(state)){
                Card c=game.carddraw(i);
                game.players[i].hit(c);
                gui.updatePlayerHand(c, i);
                if(game.players[i].checkIfBlackJack()==true){
                    System.out.println("-----------"+game.players[i].getName()+" Win----------");
                    check++;
                    break;
                }
                if(game.players[i].lost==true){
                    game.players[i].score=0;
                    break;
                }
                state=in.next();
            }
            if(check>0){
                game.highscore(game.players[i].getScore(),i);
                break;
                }
            game.highscore(game.players[i].getScore(),i);
            if(game.players[i].score>0){
                    System.out.println(game.players[i].getName()+" score :"+game.players[i].getScore());
                }
        }
        while(game.players[3].lost==false){
             Card c=game.carddraw(3);
             game.players[3].hit(c);
              if(game.players[3].checkIfBlackJack()==true){
                    System.out.println("-----------"+game.players[3].getName()+" Win----------");
                    break;
                }
             gui.updateDealerHand(c, game.Deck);
             if((game.players[3].score>game.high)&& game.players[3].score<=21){
                 System.out.println("-----------"+game.players[3].getName()+" Win----------");
                 break;
             }
        }
        if(game.players[3].score>21){
            if(game.players[0].score==0&&game.players[1].score==0&&game.players[2].score==0){
                System.out.println("\t PUSH \t");
            }
            else if(game.winner<0){
                System.out.println("\t PUSH \t");
            }
            else{
                System.out.println("\tThe Winner is :"+game.players[game.winner].getName()+" with score : "+game.high);
            }
        }
    }
}