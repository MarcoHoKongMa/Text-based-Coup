/**
* A Game class where the text based coup game will be simulated.
*
* @authors Ting Wu
* @version 1.0
* @since   2021-02-22
*/

package main;
import Players.*;
import Cards.*;

public class Game {
    private Player[] players;
    private Deck deck;
    private int numCoins;
    
    public Game(){
        this.players = new Player[4]; //4 player game
        this.deck = new Deck(); // 15 card deck
        this.numCoins = 50;
    }


    public Deck getDeck() {
        return this.deck;
    }

    public int getNumCoins(){
        return this.numCoins;
    }

    public void setNumCoins(int coins){
        this.numCoins = coins;
    }   
}


