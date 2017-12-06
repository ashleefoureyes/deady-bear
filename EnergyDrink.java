public class EnergyDrink extends Thing{

    public EnergyDrink(String name, String description, int healthvalue, int x, int y) {
        super(name, description, healthvalue, x, y);
        this.name = "Energy Drink";
        this.description = "You drank some energy drink. 75HP has been added from your health.";
        this.healthvalue = 75;
    }

}
