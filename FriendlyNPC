import java.util.List;
import java.util.Scanner;

public class FriendlyNPC extends Player{

    public FriendlyNPC(World world, String character, int x, int y, int health, List<Thing> inventory, Thing friend){
        super(world, character, x, y, health, inventory, friend);
        this.character = "Friendly NPC";
    }

    public void play(){
        System.out.println("Hello! I am a Friendly NPC here to help you! Answer my question correctly and I'll give you 50HP, else only 25HP.");
        System.out.println("What is 1+1? ");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        if (answer.equals("2")){
            System.out.println("That is correct! Here's 50HP for you!");
            int newHealth = getHealth()+50;
            setHealth(newHealth);
        }
        else{
            System.out.println("That is wrong! Here's 25HP for you!");
            int newHealth = getHealth()+25;
            setHealth(newHealth);
        }
    }

}
