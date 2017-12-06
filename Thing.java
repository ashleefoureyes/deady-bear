public abstract class Thing{

    protected String    name;

    protected String    description;

    protected int       healthvalue;

    protected double    x;

    protected double    y;


    public Thing(String name, String description, int healthvalue, double x, double y)

    {

        this.name = name;

        this.description = description;

        this.healthvalue = healthvalue;

        this.x = x;

        this.y = y;

    }



    public String       getName(){ return name; }

    public String       getDescription() { return description;  }

    public int          getHealthValue(){ return healthvalue; }

    public double       getX(){   return x;}

    public double       getY(){   return y;}

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



    public void interact(Player p){
        System.out.println(this.description);
        p.setHealth(this.healthvalue + p.getHealth());
        // allows for some interaction with a player
    }



    @Override

    public boolean equals(Object o){

        if( o instanceof Thing){

            return this.name.equals( ((Thing)o).name )

                    && this.description.equals( ((Thing)o).description )

                    && this.healthvalue == ((Thing)o).healthvalue

                    && this.x == ((Thing)o).x

                    && this.y == ((Thing)o).y;



        }else{

            return false;

        }

    }

}
