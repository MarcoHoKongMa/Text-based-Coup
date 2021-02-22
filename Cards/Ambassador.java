/**
* An Ambassador object that implements the Card interface.
*
* @authors Ting Wu
* @version 1.0
* @since   2021-02-15
*/

package Cards;
import Players.Player;
import java.util.Scanner;
import java.util.ArrayList;

public class Ambassador implements Card{
    private String name = "Ambassador";


    /**
     * This method allows the player to swap 2, or 1 card from his hand with the deck
     * depending on the number of cards he currently has that are alive.
     * @param user A player object used to identify which player the card Ambassador effects.
     * @param deck Used to draw 2 cards from the deck.
     * @return Nothing.
     */
    public void use(Player user, Deck deck){
        // Two cards along with the number of cards the user has alive
        // will be part of the available choices.
        ArrayList<Card> choices = new ArrayList<Card>();
        choices.add(deck.draw());
        choices.add(deck.draw());
        int userChoice = 0;

        // >> Check to how many cards Player has alive <<
        if (!((user.getCard1()).toString().equals("Dead")) && !((user.getCard2()).toString().equals("Dead"))) { 
            choices.add(user.getCard1());
            choices.add(user.getCard2());
        }
        else if (!((user.getCard1()).toString().equals("Dead"))) {
            choices.add(user.getCard1());
        }
        else{
            choices.add(user.getCard2());
        }

        // >> Displays the cards that the user can choose to keep <<
        for (int i=0; i<choices.size(); i++){
            System.out.println("\nCard "+ (i+1) + ": "+ choices.get(i).toString());
        }

        Scanner input = new Scanner(System.in);
        
        // >> Player can pick 2 cards to keep <<
        if (choices.size() == 4){
            
            // >> Pick a card and remove it from the available choices <<
            userChoice = keepCard(choices, input);
            user.setCard1(choices.get(userChoice-1));
            choices.remove(userChoice);

            // >> Displays the cards that the user can choose to keep <<
            for (int i=0; i<choices.size(); i++){
                System.out.println("\nCard "+ (i+1) + ": "+ choices.get(i).toString());
            }

            // >> Pick a card and remove it from the available choices <<
            userChoice = keepCard(choices, input);
            user.setCard2(choices.get(userChoice-1));
            choices.remove(userChoice);

            // >> Output the players action <<
            System.out.println(user.getName() + " has swapped out 2 cards.");
        } 
        else{ // >> Player can only pick 1 card to keep <<
            
            // >> Pick a card and remove it from the available choices <<
            userChoice = keepCard(choices, input);
            user.setCard1(choices.get(userChoice-1));
            choices.remove(userChoice);
            
            // >> Output the players action <<
            System.out.println(user.getName() + " has swapped out 1 card.");
        }
        input.close();

        // >> Send remaining cards back to the deck <<
        for (int i=choices.size(); i>=0; i--){
            deck.addCard(choices.get(i));
        }
        choices.clear();
    }

    /**
     * A mutator used to change the name of a the card Ambassador.
     * @return Nothing.
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * Returns the string reprentation of class Ambassador.
     * @return String. Returns the name of the card.
     */
    public String toString() {
        return name;
    }

    /**
     * Function thats is asks the user to pick a card from an array of available choices.
     * @param choices An array of available cards that the user can pick from.
     * @param input Scanner Object.
     * @return Int. Returns an integer representing which card the user chose to keep.
     */
    public int keepCard(ArrayList<Card> choices, Scanner input){
        int userChoice = 0;
        while (!(userChoice >= 1 && userChoice <= choices.size())){
            try{
                System.out.print("\nWhat is the first card you would like to keep? (Please enter an integer 1-" + choices.size() + ") : ");
                userChoice = Integer.parseInt(input.nextLine());
            }catch (NumberFormatException exception) {
                // Do nothing, the try block will keep repeating until the user inputs a valid integer.
            }
        }
        return userChoice;
    }
}
