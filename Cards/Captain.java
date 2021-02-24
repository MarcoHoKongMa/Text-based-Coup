package Cards;
import Players.Player;
import main.Game;

public class Captain implements Card{
    // >> Class Parameters <<
    private String name;
    
    public Captain(){
        this.name="Captain";
    }

    public void use(Player user, Game game){
        
    }

    public void setName(String name){
        this.name=name;
    }
    
    public String toString(){
        return this.name;
    }
}
