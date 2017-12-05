/**
 * Created by ashleefoureyes on 2017-12-05.
 */

/**
 * TO DO: check if doors are connected
 * Double check ArrayIndexOutOfBoundsException
 */
public class Location {
    protected World world;  // the world that the location lives in
    protected int row=0;
    protected int col=0;

    /** Creates a new location in the world at the specified row and column */
    public Location(World w,int row, int col){
        this.world = w;
        this.row = row;
        this.col = col;
    }

    public World getWorld(){ return world;}
    public int getRow(){return row;}
    public int getCol(){return col;}

    /** Checks if another location is adjacent (connected with a door)
     * to this current location.
     *
     * @param other is another location
     * @return true if this location and the other location are adjacent to each other (connected with a door)
     */
    public boolean isConnected(Location other){
        // using the information in the world check is this location
        // and other are connected.
        return false;
    }

    /** Returns location to the west (left) of the current location
     *
     * TODO: This will throw an ArrayIndexOutOfBoundsException
     *       deal.
     */
    public Location west(){
        return new Location(world, row, col-1);


    }

    /** Returns location to the east (right) of the current location
     *
     * TODO: This will throw an ArrayIndexOutOfBoundsException
     *       deal.
     */
    public Location east(){
        return new Location(world, row, col+1);
    }

    /** Returns location to the north (up) of the current location
     *
     * TODO: This will throw an ArrayIndexOutOfBoundsException
     *       Deal.
     */
    public Location north(){
        return new Location(world, row-1, col);
    }

    /** Returns location to the south (down) of the current location
     *
     * TODO: This will throw an ArrayIndexOutOfBoundsException
     *       Deal with this.
     */
    public Location south(){
        return new Location(world, row+1, col);
    }

    @Override
    public String toString(){
        return "("+row+","+col+")";
    }

    /** Two locations are equal to each other if they are in the
     * same world, have the same row and column.
     */
    @Override
    public boolean equals(Object o){
        if( o instanceof Location){
            return this.row == ((Location)o).row &&
                    this.col == ((Location)o).col &&
                    this.world == (((Location)o).world);
        }else{
            return false;
        }
    }
}
