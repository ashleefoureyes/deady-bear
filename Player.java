/**
 * Created by ashleefoureyes on 2017-11-22.
 */

/**
 * TO DO:
 * • Have not included room references yet, will need to add.
 * • Dealing with Graphics. We could create a graphics class and storage class
 *   what are your thoughts? Used Graphix below temporarily.
 */

import java.awt.Rectangle;
import java.awt.Graphics;

public abstract class Player {

    // X position of player
    protected double x;

    // Y position of player
    protected double y;

    // Player X axis Speed - may combine X and Y depending on approach
    protected double sx;
    // Player Y axis Speed
    protected double sy;

    // Player knows which "world he is in"
    protected World world;

    // I dont know what graphics we are using, or if we are even making a graphics class/interface
    //so naming it Graphix for now.
    protected Graphix graphix;

    // Rectangle used to detect collision of current player
    protected Rectangle playerBounds = new Rectangle();
    // Rectangle used to detect collison with other teddy bear zombies or players
    protected Rectangle collisionBounds = new Rectangle();

    /**
     * @param pWorld The world where player is contained
     * @param px X Position
     * @param py Y Position
     */

    // have to add room to this constructor
    public Entity(World pWorld, double px, double py) {
        this.world = pWorld;
        this.x = px;
        this.y = py;
    }

    /**
     * @return player current x position 
     */
    protected double getX() {
        return x;
    }

    /**
     * @param x player new x position
     */
    protected void setX(double x) {
        this.x = x;
    }

    /**
     * @return player current y position
     */
    protected double getY() {
        return y;
    }

    /**
     * @param y player new y position
     */
    protected void setY(double y) {
        this.y = y;
    }

    /**
     * @return player x speed value
     */
    protected double getXSpeed() {
        return sx;
    }

    /**
     * @param dx new player x speed value
     */
    protected void setXSpeed(double dx) {
        this.sx = sx;
    }

    /**
     * @return player y speed value
     */
    protected double getYSpeed() {
        return sy;
    }

    /**
     * @param dy new player y speed value
     */
    protected void setYSpeed(double dy) {
        this.sy = sy;
    }

    /**
     * Moves the player regarding it's current position, speed and time elapsed since the last move
     * @param elapsed Time since the player was last updated
     */
    public void changePosition(double elapsed) {
        // update player location based on current position and speed
        // time is in milliseconds? so divide by 100 but idk so we can change this?
        this.x += (elapsed * this.sx) / 1000;
        this.y += (elapsed * this.sy) / 1000;
    }

    /**
     * @param gr The surface where player will be "drawn"
     */
    public void create(Graphics gr) {
        this.graphix.create(gr, (int) this.x, (int) this.y); //Graphix will have a create? can alter entire plan tho
    }

    /**
     * Checks if for player collision
     * @param other colliding object or player
     * @return True if collision occurred
     */
    public boolean collision(Player other) {
        this.playerBounds.setBounds((int) this.x, (int) this.y, this.graphix.getWidth(), this.graphix.getHeight());
        this.collisionBounds.setBounds((int) other.x, (int) other.y, other.graphix.getWidth(), other.graphix.getHeight());

        return playerBounds.intersects(collisionBounds);
    }

    /**
     * collision did happen, however the reaction is dependent on what the player
     * collided with, so it is abstract
     * @param other the collision object
     */
    public abstract void collided(Player other);
    public abstract void collisionReaction();
}