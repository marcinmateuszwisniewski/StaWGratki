package Ships;

public class Coordinate {
    private int row;
    private int column;

    private Coordinate(){}

    public Coordinate(int row,int column){
        this.row = row;
        this.column = column;
    }

    public Coordinate(Coordinate c) {
        this.row = c.getRow();
        this.column = c.getColumn();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
