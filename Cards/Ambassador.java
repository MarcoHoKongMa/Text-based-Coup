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

public class Ambassador implements Card{
    private String name = "Ambassador";


    /**
     * This method allows the player to swap 2, 1, or no cards from his hand with the deck
     * depending on the number of cards he currently has that are alive.
     * @return Nothing.
     */
    public void use(Player user, Deck deck){
        // Two cards along with the number of cards the user has alive
        // will be part of the available choices.
        Card[] choices = new Card[4];
        choices[0] = deck.draw();
        choices[1] = deck.draw();
        int userChoice1 = 0;
        int userChoice2 = 0;

        // >> Check to how many cards Player has alive <<
        if (!((user.getCard1()).toString().equals("Dead")) && !((user.getCard2()).toString().equals("Dead"))) { 
            choices[2] = user.getCard1();
            choices[3] = user.getCard2();
        }
        else if (!((user.getCard1()).toString().equals("Dead"))) {
            choices[2] = user.getCard1();
        }
        else{
            choices[2] = user.getCard2(); 
        }

        // >> Displays the cards that the user can choose to keep <<
        for (int i=0; i<choices.length; i++){
            System.out.println("\nCard "+ (i+1) + ": "+ choices[i].toString());
        }

        Scanner input = new Scanner(System.in);
        
        // >> Player can pick 2 cards to keep <<
        if (choices.length == 4){
            while (!(userChoice1 >= 1 && userChoice1 <= choices.length)){
                try{
                    System.out.print("\nWhat is the first card you would like to keep? (Please enter an integer 1-" + choices.length + ") : ");
                    userChoice1 = Integer.parseInt(input.nextLine());
                }catch (NumberFormatException exception) {
                    // Do nothing, the try block will keep repeating until the user inputs a valid integer.
                }
            }
            user.setCard1(choices[userChoice1-1]);

            while (!(userChoice2 >= 1 && userChoice1 <= choices.length) || userChoice1 == userChoice2){
                try{
                    System.out.print("\nWhat is the first card you would like to keep? (Please enter an integer 1-" + choices.length + ") : ");
                    userChoice2 = Integer.parseInt(input.nextLine());
                }catch (NumberFormatException exception) {
                    // Do nothing, the try block will keep repeating until the user inputs a valid integer.
                }
                // Prints an error message when the user tries to pick the same card twice
                if (userChoice2 == userChoice1) {
                    System.out.println("You cannot pick the same card twice.");
                }
            }
            user.setCard2(choices[userChoice2-1]);
            System.out.println(user.getName() + " has swapped out 2 cards.");
        } 
        else{ // >> Player can only pick 1 card to keep <<
            while (!(userChoice1 >= 1 && userChoice1 <= choices.length)){
                try{
                    System.out.print("\nWhat is the first card you would like to keep? (Please enter an integer 1-" + choices.length + ") : ");
                    userChoice1 = Integer.parseInt(input.nextLine());
                }catch (NumberFormatException exception) {
                    // Do nothing, the try block will keep repeating until the user inputs a valid integer.
                }
            }
            user.setCard1(choices[userChoice1-1]);
            System.out.println(user.getName() + " has swapped out 1 card.");
        }
        input.close();
    }

    public void setName(String name){
        this.name=name;
    }

    public String toString() {
        return name;
    }
}
