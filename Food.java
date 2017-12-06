public class Food extends Thing{

    public Food(String name, int healthvalue, double x, double y){
        super(name, healthvalue, x, y);
        this.name = "Hamburger";
        this.healthvalue = 25;
    }

    public void interact(){
        System.out.println("You obtained a hamburger! 25HP added to your health!");
    }

}
