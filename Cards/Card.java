package Cards;
import Players.Player;

public interface Card {
    public void use(Player user, Deck deck);
    public void setName(String name);
    public String toString();
}
