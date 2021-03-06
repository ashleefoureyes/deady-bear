/**
 * Created by Rishi on 11/28/2017.

 * This class holds non-player things in the world.
 *
 * This class should be abstract and team members should be
 * creating concrete subclasses.
 */

public abstract class Thing{
    protected String    name;
    protected int       healthvalue;
    protected double    x;
    protected double    y;


    public Thing(String name, int healthvalue, double x, double y)
    {
        this.name = name;
        this.healthvalue = healthvalue;
        this.x = x;
        this.y = y;
    }

    public String       getName(){ return name; }
    public int          getHealthValue(){ return healthvalue; }
    public double       getX(){   return x;}
    public double       getY(){   return y;}

    public void setHealthValue(int h){
        this.healthvalue = h;
    }

    public void setX(){ this.x = x;}

    public void setY(){ this.y = y;}

    /** Allows for a Thing to interact with the room it is in (including all of the players and things in that room)
     */

    public void interact(){
        // allows for some interaction with room (and players/things in it)
    }

    /** Allows for interaction with the current thing and a specified player
     *
     * @param p is a player that is interacting with this current thing
     */

    /*public void interact(Player p){
        // allows for some interaction with a player
    }*/

    @Override
    public boolean equals(Object o){
        if( o instanceof Thing){
            return this.name.equals( ((Thing)o).name )
                    && this.healthvalue == ((Thing)o).healthvalue
                    && this.x == ((Thing)o).x
                    && this.y == ((Thing)o).y;

        }else{
            return false;
        }
    }
}
