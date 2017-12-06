import java.util.List;
import java.util.Scanner;

/**
 * Created by ashleefoureyes on 2017-12-03.
 */

//UNCOMMENT directionals when fixed


public class Rick extends Player {

    private static boolean verbose = true; // set false when submitted


    /** Creates a player in the game
     *
     * @param w is the world that the player lives in
     * @param name is the name of the player
     * @param location is where in the world the player is
     * @param health is the health of the player.
     * @param things the inventory
     * @param goal is the friend to be saved.
     */
    public Rick(World w, String name, Location location, int health,
                 List<Thing>  things, Thing goal){
        super(w, name, location, health, things, goal);
    }


    /** Plays a turn for this player
     *
     * For computer players will have the AI for that player.
     * For human player querie user for input and then react
     * appropriately for the input.
     */
    @Override
    public void play(){
        if(verbose){System.err.println("the room as " + world.getRoom(getLocation()).getPlayers() + " players");}
        if(verbose){System.err.println("the room as " + world.getRoom(getLocation()).getThings() + " things");}
        Scanner in = new Scanner(System.in);
        System.out.print("What would you like to do? [type h <enter> for help] ");
        String action = in.nextLine();
        if( action.trim().equals("h") ){
            help();
        }else if(action.trim().equals("l") ){
            look();
        }else if(action.trim().charAt(0) == 'g'){
            switch( action.trim().charAt(action.trim().length()-1) ){
                case 'e' :
                    if(verbose){System.err.print("human was in " + this.getLocation());}
                    this.world.getRoom(this.getLocation()).removePlayer(this);
                   // this.setLocation(this.getLocation().east());
                    this.world.getRoom(this.getLocation()).addPlayer(this);
                    if(verbose){System.err.print("human now in " + this.getLocation());}
                    break;
                case 'w' :
                    if(verbose){System.err.print("human was in " + this.getLocation());}
                    this.world.getRoom(this.getLocation()).removePlayer(this);
                   // this.setLocation(this.getLocation().west());
                    this.world.getRoom(this.getLocation()).addPlayer(this);
                    if(verbose){System.err.print("human now in " + this.getLocation());}
                    break;
            }

        }
    }



    public void look(){
        String s = "You are currently in ";
        s += world.getRoom(getLocation()).toString();
        System.out.println(s);
    }

    public void help(){
        String s = "Your options are:\n ";
        s += "'h' for help \n ";
        s += "'l' to look around the room \n ";
        s += "'g x' to go in direction x (x can be n,e,w,s) \n ";
        s += "'w' to list what you have \n ";
        System.out.println(s);
    }


}


