/**
 * Created by ashleefoureyes on 2017-12-05.
 */

import java.util.List;

public class DeadlyNPC extends Player {
    public DeadlyNPC (int x, int y, int health, List<Thing> inventory){
        super(x, y, health, inventory);
    }

    public void action () {
        System.out.println("You have been nearly devoured by Deady Bear." +
                "Your health has been decreased by 90HP!! ");

        int health = getHealth() - 90;
        setHealth(health);


    }

	@Override
	public Location play() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isComputer() {
		// TODO Auto-generated method stub
		return false;
	}
}
