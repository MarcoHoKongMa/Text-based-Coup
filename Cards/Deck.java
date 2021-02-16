/**
* The class Deck is based on a card array that contains 15 card objects that can be
* manpulated with many different methods.
*
* @author  Ting Wu
* @version 1.0
* @since   2021-02-15
*/

package Cards;

import java.util.Random;

public class Deck {
    // >> Class Parameters <<
    private Card deck[];
    
    // >> Constructor <<
    public Deck(){
        Card deck[] = new Card[15];
        
        for (int i = 0; i < 3; i++) {
            deck[i * 5] = new Captain();
            deck[i * 5 + 1] = new Assassin();
            deck[i * 5 + 2] = new Contessa();
            deck[i * 5 + 3] = new Ambassador();
            deck[i * 5 + 4] = new Duke();
        }
    }

    /**
     * This methods shuffles the deck using Fisher-Yates shuffle Algorithm.
     * @return Nothing.
     */
    public void Shuffle(){
        // >> Creates a random object <<
        Random random = new Random();

        // >> Fisher-Yates Shuffle Algorithm <<
        for (int i=deck.length-1; i > 0; i--) {
            int newIndex = random.nextInt(i+1);
            Card temp = deck[newIndex];
            deck[newIndex] = deck[i];
            deck[i] = temp;
        }
    }


    /**
     * This methods draws a card from the deck.
     * @return Card This returns a card object from the top of the deck.
     */
    public Card draw(){
        Card drawnCard = deck[0];
        Card newDeck[] = new Card[14];

        for (int i=1; i<deck.length; i++){
            newDeck[i-1] = deck[i];
        }
        deck = newDeck;

        return drawnCard;
    }

    /**
     * This methods shuffles the deck using Fisher-Yates shuffle Algorithm.
     * @param card Takes in a card and adds it to the deck.
     * @return Nothing.
     */
    public void addCard(Card card){
        Card newDeck[] = new Card[deck.length + 1];
        for (int i=0; i<deck.length; i++){
            newDeck[i] = deck[i];
        }
        newDeck[deck.length] = card;
        deck = newDeck;
    }

    /**
     * This methods returns the deck.
     * @return Nothing.
     */
    public Card[] getDeck(){
        return deck;
    }
}