/**
 * Created by ashleefoureyes on 2017-12-05.
 */
public class Position{
    protected int x=0;
    protected int y=0;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object ob){
        if( ob instanceof Position){
            return this.x == ((Position) ob).x && this.y == ((Position) ob).y;
        }else{
            return false;
        }
    }

}

