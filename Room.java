import java.util.List;

public class Room {
    protected List <Player> people;
    protected List <Thing> things;
    protected int rows;
    protected int columns;
    protected boolean [] directions = new boolean[False, False, False, False];


    public Room (List <Player> people, List <Thing> things, int rows, int columns, boolean[] directions) {
        this.people = people;
        this.things = things;
        this.rows = rows;
        this.columns = columns;
        this.directions = directions;

    }
    public List <Player> getPlayers() {
        return people;
    }

    public List <Thing> getThings () {
        return things;
    }

    public int getRows () {
        return rows;
    }

    public int getColumns () {
        return columns;
    }

    public boolean[] getDirections() {
        return directions;
    }

    public void addPlayer (Player p) {
        this.people.add(p);
    }
    public void removePlayer (Player p) {
        this.people.remove (p);
    }

    public void addThings (Thing t) {
        this.things.add (t);
    }


}
