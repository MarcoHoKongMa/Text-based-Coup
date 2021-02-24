package Cards;
import Players.Player;
import main.Game;

public class Duke implements Card{
    // >> Class Parameters <<
    private String name;

    public Duke(){
        this.name = "Duke";
    }
    
    public void use(Player user, Game game){
        // >> Check to see if the game has enough coins <<
        if (game.getNumCoins() >=3){
            user.setNumCoins(user.getNumCoins()+3);
            game.setNumCoins(game.getNumCoins()-3);
        }
        else{ // >> If there are less than 3 coins we give the user the remaining coins <<
            user.setNumCoins(user.getNumCoins()+game.getNumCoins());
            game.setNumCoins(0);
        }
    }

    public String toString(){
        return this.name;
    }
}