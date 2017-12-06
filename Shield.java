//Created by Matthew Kaprielian-Seferian

public class Shield extends Thing
{
	public Shield(String name, int healthvalue, double x, double y) 
	{
		super(name, healthvalue, x, y);
		this.name = "Shield";
		this.healthvalue = 0;
	}
	
	public void interact()
	{
        System.out.println("You found a shield! The next zombie you encounter won't be able to attack you.");
    }
}
