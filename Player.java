/**
 * Created by ashleefoureyes on 2017-11-22.
 */

import java.util.List;
//add location method


public abstract class Player{
    protected int          x;
    protected int          y;
    protected int          health = 100;
    protected List<Thing>  inventory; //things player is carrying

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
    public Player(int x, int y, int health,
                  List<Thing>  inventory)
    {
        this.x = x;
        this.y = y;
        this.health = health;
        this.inventory = inventory;
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

    /** Plays a turn for this player
     *
     * For computer players will have the AI for that player.
     * For human player querie user for input and then react
     * appropriately for the input.
     */
    public abstract Location play();


    /** Moves a player from one location to a new location
     * @param cx is current x position
     * @param cy is current y position
     * @param nx is new x position
     * @param ny is new y position
     * @return true if the move was successful and false otherwise (e.g. when trying to move from one
     *         location to another that are not connected)
     */



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

    //checks if player is Rick or computer
    public abstract boolean isComputer();
}
