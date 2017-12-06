import java.util.List;

//Created by Matthew Kaprielian-Seferian

public class LeftZombie extends Player
{

	public LeftZombie(int x, int y, int health, List<Thing> inventory) 
	{
		super(x, y, health, inventory);
	}
	//Getter for x
	public int getXPosition()
	{
        return x;
    }

    //Getter for y
    public int getYPosition()
    {
        return y;
    }
    
    //Getter for inventory
    public List<Thing> getInventory()
    {
        return inventory;
    }

    //Moves the zombie: moves according to the left hand rule
    @Override
	public Location play()
	{
    	Room[][] rooms = World.getRooms();
    	boolean[] doors = rooms[getXPosition()][getYPosition()].getDirections();
    	
    	if(doors[3])
    	{
    		setLocation(getXPosition()-1, getYPosition());
    		Location temp = new Location(getXPosition()-1, getYPosition());
    		return temp;
    	}
    	else if(doors[0])
    	{
    		setLocation(getXPosition(), getYPosition()+1);
    		Location temp = new Location(getXPosition(), getYPosition()+1);
    		return temp;
    	}
    	else if(doors[1])
    	{
    		setLocation(getXPosition()+1, getYPosition());
    		Location temp = new Location(getXPosition()+1, getYPosition());
    		return temp;
    	}
    	else
    	{
    		setLocation(getXPosition(), getYPosition()-1);
    		Location temp = new Location(getXPosition(), getYPosition()-1);
    		return temp;
    	}
	}

	//Adds an item to his inventory
	public void addThing(Thing t)
	{
	    this.inventory.add(t);
	}
	
	//Removes an item from his inventory
	public boolean removeThing(Thing t)
	{
	    return this.inventory.remove(t);
	}
	
	//Confirms that this is a bot and not a human player
	@Override
	public boolean isComputer()
	{
		return false;
	}
}
