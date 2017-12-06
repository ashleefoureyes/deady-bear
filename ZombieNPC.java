import java.util.List;
import java.util.Scanner;

public class ZombieNPC extends Player {
    private String character;

	public ZombieNPC (World world, String character, int x, int y, int health, List<Thing> inventory, Thing friend){
        super(x, y, health, inventory);
        this.character = "Zombie";
    }

    public void action () {
        System.out.println("You have been bitten by me. Your health has been decreased by 50HP. ");

        int health = getHealth() - 50;
        setHealth(health);


    }

	@Override
	public Location play() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isComputer() {
		// TODO Auto-generated method stub
		return false;
	}
}