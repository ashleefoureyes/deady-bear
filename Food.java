public class Food extends Thing{

    public Food(String name, String description, int healthvalue, int x, int y) {
        super(name, description, healthvalue, x, y);
        this.name = "Hamburger";
        this.description = "You obtained a hamburger! 25HP added to your health!";
        this.healthvalue = 25;
    }

}

