package ships;

import java.util.Objects;

public class Coordinate {
    private int row;
    private int column;

    private Coordinate() {
    }

    public static Coordinate of(int row, int column) {
        return new Coordinate(row, column);
    }

    private Coordinate(int row, int column) {
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

    public boolean isNorthTo(Coordinate c) {
        return this.row == c.row - 1 && this.column == c.column;
    }

    public boolean isSouthTo(Coordinate c) {
        return this.row == c.row + 1 && this.column == c.column;
    }

    public boolean isWestTo(Coordinate c) {
        return this.row == c.row && this.column + 1 == c.column;
    }

    public boolean isEastTo(Coordinate c) {
        return this.row == c.row && this.column - 1 == c.column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row &&
                column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    public boolean isBy(Coordinate c) {
        return isEastTo(c) || isNorthTo(c) || isSouthTo(c) || isWestTo(c);
    }

    @Override
    public String toString() {
        return (char) (row + 65) +""+ column;
    }
}
