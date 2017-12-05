import java.util.List;
import java.util.Scanner;

public class ZombieNPC extends Player {
    public ZombieNPC (World world, String character, int x, int y, int health, List<Thing> inventory, Thing friend){
        super(world, character, x, y, health, inventory, friend);
        this.character = "Zombie";
    }

    public void action () {
        System.out.println("You have been bitten by me. Your health has been decreased by 50HP. ");

        int health = getHealth() - 50;
        setHealth(health);


    }
}