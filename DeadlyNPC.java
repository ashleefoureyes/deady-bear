/**
 * Created by ashleefoureyes on 2017-12-05.
 */

import java.util.List;

public class DeadlyNPC extends Player {
    public DeadlyNPC (World world, String character, int x, int y, int health, List<Thing> inventory, Thing friend){
        super(world, character, x, y, health, inventory, friend);
        this.character = "Deady Bear";
    }

    public void action () {
        System.out.println("You have been nearly devoured by Deady Bear." +
                "Your health has been decreased by 90HP!! ");

        int health = getHealth() - 90;
        setHealth(health);


    }
}
