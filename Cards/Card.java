package Cards;
import Players.Player;
import main.Game;

public interface Card {
    public void use(Player user, Game game);
    public String toString();
}
