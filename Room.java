import java.util.List;

public class Room {
    protected List <Player> people;
    protected int rows;
    protected int columns;

    public Room (List <Player> people, int rows, int columns) {
        this.people = people;
        this.rows = rows;
        this.columns = columns;
    }
    public List <Player> getPlayers() {
        return people;
    }

    public int getRows () {
        return rows;
    }

    public int getColumns () {
        return columns;
    }

    public void addPlayer (Player p) {
        this.people.add(p);
    }
    public void removePlayer (Player p) {
        this.people.remove (p);
    }
}
