public class Room {
    protected List <Players> people;
    protected List <Things> things;
    protected int rows;
    protected int columns;

    public Room (List <Players> people, List <Things> things, int rows, int columns) {
        this.people = people;
        this.things = things;
        this.rows = rows;
        this.columns = columns;
    }

    public List<Players> getPeople() {
        return people;
    }

    public List<Things> getThings() {
        return things;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void addPlayers (Player p) {
        this.people.add(p);
    }

    public void addThing (things t) {
        this.things.add (t);
    }
}
