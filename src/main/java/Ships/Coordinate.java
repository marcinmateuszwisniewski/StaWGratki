package Ships;

public class Coordinate {
    public int row;
    public int column;

    private Coordinate(){}

    public Coordinate(int row,int column){
        this.row = row;
        this.column = column;
    }

    public Coordinate(Coordinate c) {
        this.row = c.row;
        this.column = c.column;
    }
}
