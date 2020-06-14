package ships;

import java.util.Objects;

/**
 * This is an immutable object holding coordinates.
 */
public class Coordinate {
    private int row;
    private int column;

    private Coordinate() {
    }

    /**
     * This is static factory method, releasing coordinates.
     *
     * @param row coordinate of row, zero-indexed
     * @param column coordinate of column, zero-indexed
     * @return new immutable coordinate
     */
    public static Coordinate of(int row, int column) {
        return new Coordinate(row, column);
    }

    private Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Copy contructor.
     * @param c coordinate to copy.
     */
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

    /**
     * @param c coordinate to proof
     * @return true, if this coordinates are "north" of c(ie. this coord touches c from above on grid), false otherwise
     */
    public boolean isNorthTo(Coordinate c) {
        return this.row == c.row - 1 && this.column == c.column;
    }
    /**
     * @param c coordinate to proof
     * @return true, if this coordinates are "south" of c(ie. this coord touches c from below on grid), false otherwise
     */
    public boolean isSouthTo(Coordinate c) {
        return this.row == c.row + 1 && this.column == c.column;
    }
    /**
     * @param c coordinate to proof
     * @return true, if this coordinates are "west" of c(ie. this coord touches left side of c on grid), false otherwise
     */
    public boolean isWestTo(Coordinate c) {
        return this.row == c.row && this.column + 1 == c.column;
    }
    /**
     * @param c coordinate to proof
     * @return true, if this coordinates are "east" of c(ie. this coord touches touches right side of c on grid), false otherwise
     */
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

    /**
     * @param c coordinate to proof
     * @return true if c and this coordinate are touching themselves from any side, false otherwise
     */
    public boolean isBy(Coordinate c) {
        return isEastTo(c) || isNorthTo(c) || isSouthTo(c) || isWestTo(c);
    }

    /**
     * This is toString() implementation.
     *
     * @return coordinates in format XY, where X= {A,B,C,D...}, and Y={0,1,2,3,...}.
     */
    @Override
    public String toString() {
        return (char) (row + 65) +""+ column;
    }
}
