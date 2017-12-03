/**
 * Created by ashleefoureyes on 2017-11-22.
 */

import java.util.List;


public abstract class Player{
    protected World        world;    // world that player lives in
    protected String       character;
    protected int          x;
    protected int          y;
    protected int          health = 100;
    protected List<Thing>  inventory; //things player is carrying
    protected Thing        friend; //objective of the game: save friend

    /** Creates a player in the game
     *
     * @param world is the world that the player lives in
     * @param character is the name of the player
     * @param x is x position
     * @param y is y position
     * @param health is the health of the player (which may or may not be relevant in your game)
     * @param inventory is a list of Thing objects that the player initially possesses
     * @param friend is the Thing that the human player is trying to retrieve in the game
     */
    public Player(World world, String character, int x, int y, int health,
                  List<Thing>  inventory, Thing friend)
    {
        this.world = world;
        this.character = character;
        this.x = x;
        this.y = y;
        this.health = health;
        this.inventory = inventory;
        this.friend = friend;
    }

    /** Getter for a player's world */
    public World getWorld(){
        return world;
    }

    /** Getter for a player's name */
    public String getCharacter(){
        return character;
    }

    /** Getter for a player's x location */
    public int getXPosition(){
        return x;
    }

    /** Getter for a player's y location */
    public int getYPosition(){
        return y;
    }

    /** Getter for a player's health */
    public int getHealth(){
        return health;
    }

    /** Getter for a player's inventory  */
    public List<Thing>  getInventory(){
        return inventory;
    }

    /** Getter for a player's goal */
    public Thing getFriend(){
        return friend;
    }

    /** Plays a turn for this player
     *
     * For computer players will have the AI for that player.
     * For human player querie user for input and then react
     * appropriately for the input.
     */
    public void play(){}


    /** Moves a player from one location to a new location
     * @param cx is current x position
     * @param cy is current y position
     * @param nx is new x position
     * @param ny is new y position
     * @return true if the move was successful and false otherwise (e.g. when trying to move from one
     *         location to another that are not connected)
     */

    public boolean move(int cx, int cy, int nx, int ny){
        // move from current location to new location
        // should only be allowed to move if the locations are connected
        // (with a door that can opened)
        return false;
    }

    /** sets a player's current location
     */
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    /** Setter for a player's health
     * @param h is the new health of the player
     */
    public void setHealth(int h){
        this.health = h;
    }

    /** Adds a thing to the player's list of things
     *
     * @param t isa thing to add to the player's list of things
     */
    public void addThing(Thing t){
        this.inventory.add(t);
    }

    /** Remove a thing from a player's list of things
     *
     * @param t is a thing to be removed from the player's list of things
     * @return true if remove was successful and false otherwise (i.e., if the player
     *              does not have this thing in their list).
     */
    public boolean removeThing(Thing t){
        return this.inventory.remove(t);
    }

    //Set the player's goal in the game (setter for goal)
    public void setGoal(Thing friend){
        this.friend = friend;
    }


    /** Allows for interaction with this player and another player
     *
     * @param p is a player that is interacting with this player
     */
    public void interact(Player p){
        // allows for some interaction with a player
    }

    /** Allows for interaction with this player and some thing
     *
     * @param t is a thing that this player is interacting with
     */
    public void interact(Thing t){
        // allows for some interaction with a player
    }


    /** Allows for interaction with this player and the room it is in
     *
     */
    public void interact(){
        // allows for some interaction with anything in the room
    }

    //returns true if collision with another occured
    public boolean collision (Player player){
        if (this.x == player.getXPosition()
            && this.y == player.getYPosition()){
         return true;
        }
        else{
            return false;
        }

    }

    //returns true if collision with thing occured
    public boolean collision (Thing thing) {
        if (this.x == thing.getXPosition()
                && this.y == thing.getYPosition()) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString(){
        return character;
    }

    /** Two players are the same if they have the same name, location and health. */
    public boolean equals(Player pl){
        if(pl instanceof Player){
            return this.character.equals(((Player)pl).character)
                    && this.x == ((Player) pl).getXPosition()
                    && this.y == ((Player)pl).getYPosition()
                    && this.health == ((Player)pl).health;

        }
        else{
            return false;
        }
    }


}
