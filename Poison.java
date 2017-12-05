/**
 * Created by ashleefoureyes on 2017-12-05.
 */
public class Poison extends Thing{

    public Poison(String name, int healthvalue, double x, double y){
        super(name, healthvalue, x, y);
        this.name = "Poison";
        this.healthvalue = -15;
    }

    public void interact(){
        System.out.println("You ate poison! 15 HP have been subtracted from your health!");
    }

}
