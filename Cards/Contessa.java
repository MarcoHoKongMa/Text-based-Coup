package Cards;
import Players.Player;
import main.Game;

public class Contessa implements Card{
    // >> Class Parameters <<
    private String name;
    
    public Contessa(){
        this.name = "Contessa";
    }
    
    public void use(Player user, Game game){
        System.out.println(user.getName() + " has called Contessa.");
    }

    public String toString(){
        return this.name;
    }
}
