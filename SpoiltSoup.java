public class SpoiltSoup extends Thing{

    public SpoiltSoup(String name, String description, int healthvalue, int x, int y) {
        super(name, description, healthvalue, x, y);
        this.name = "Spoilt soup";
        this.description = "You drank some spoilt soup. 25HP has been removed from your health.";
        this.healthvalue = 25;
    }

}
