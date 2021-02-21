/**
* A Player abstract class
*
* @author  Ting Wu
* @version 1.0
* @since   2020-02-15
*/

package Players;
import Cards.Card;

abstract public class Player {
    // >> Class Parameters <<
    private int numCoins;
    private Card card1, card2, fakeCard1, fakeCard2;
    private String name;
    private Boolean isAlive;
    private Boolean isHuman;

    // >> Constructor <<
    public Player(Card card1, Card card2, String name){
        this.numCoins = 2;
        this.card1 = card1;
        this.card2 = card2;
        this.name = name;
        this.isAlive = true;
        this.isHuman = false;
    }

    public int getNumCoins(){
        return this.numCoins;
    }

    public Card getCard1(){
        return this.card1;
    }

    public Card getCard2(){
        return this.card2;
    }

    public String getName(){
        return this.name;
    }

    public boolean getIsAlive(){
        return this.isAlive;
    }

    public boolean getIsHuman(){
        return this.isHuman;
    }

    public void setNumCoins(int coins){
        this.numCoins = coins;
    }

    public void setCard1(Card card){
        this.card1 = card;
    }

    public void setCard2(Card card){
        this.card2 = card;
    }

    public void setIsAlive(boolean result){
        this.isAlive = result;
    }
}
