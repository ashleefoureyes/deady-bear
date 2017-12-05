import java.util.List;
import java.util.Scanner;

/**
 * Created by ashleefoureyes on 2017-12-03.
 */

//first Rick edit


public class Rick extends Player {

    // set to false when going to submit code
    private static boolean verbose = true;

    public Rick(World world, String character, int x, int y, int health,
                List<Thing> inventory, Thing friend){
        super(world, character, x, y, health, inventory, friend);
    }

    @Override
    public void play(){
        if(verbose){System.err.println("the room as " + world.getRoom(getXPosition(), getYPosition()).getPlayers() + " players");}
        if(verbose){System.err.println("the room as " + world.getRoom(getXPosition(), getYPosition()).getThings() + " things");}
        Scanner in = new Scanner(System.in);
        System.out.print("What would you like to do? [type h <enter> for help] ");
        String action = in.nextLine();
        if(action.trim().equals("h") ){
            help();
        }else if(action.trim().equals("l") ){
            look();
        }else if(action.trim().charAt(0) == 'g'){
            switch( action.trim().charAt(action.trim().length()-1) ){
                case 'e' :
                    if(verbose){System.err.print("Rick was in " + this.getLocation());}
                    this.world.getRoom(this.getXPosition(),getYPosition()).removePlayer(this);
                    this.setLocation( this.getXPosition(),getYPosition());
                    this.world.getRoom(this.getXPosition(),getYPosition()).addPlayer(this);
                    if(verbose){System.err.print("Rick now in " + this.getXPosition(),getYPosition());}
                    break;
                case 'w' :
                    if(verbose){System.err.print("Rick was in " + this.(getXPosition(), getYPosition()));}
                    this.world.getRoom(this.getXPosition(),getYPosition()).removePlayer(this);
                    this.setLocation( this.getXPosition(),getYPosition());
                    this.world.getRoom(this.getXPosition(),getYPosition()).addPlayer(this);
                    if(verbose){System.err.print("Rick now in " + this.getXPosition(),getYPosition());}
                    break;
            }

        }
    }



    public void look(){
        String s = "You are currently at ";
        s += world.getRoom(getXPosition(), getYPosition()).toString();
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


