/**
 * Created by ashleefoureyes on 2017-12-05.
 */
public class Poison extends Thing{

    public Poison(String name, String description, int healthvalue, int x, int y){
        super(name, description, healthvalue, x, y);
        this.name = "Poison";
        this.healthvalue = -15;
        this.description = "You ate poison! 15 HP have been subtracted from your health!";
    }


}
