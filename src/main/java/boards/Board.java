package boards;

import ships.Ship;
import ships.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class Board {

    public static final int SIZE = 10;

    Set<Ship> ships;
    Set<Coordinate> hits;
    Set<Coordinate> missed;


    Board(){
        ships = new HashSet<>();
        hits = new HashSet<>();
        missed = new HashSet<>();
    }

    public Board copy() {
        Board copyBoard = new Board();
        copyBoard.ships = getShips();
        copyBoard.hits = getHits();
        copyBoard.missed = getMissed();
        return copyBoard;
    }

    public Set<Coordinate> getHits() {
        return new HashSet<>(hits);
    }

    public Set<Coordinate> getMissed() {
        return new HashSet<>(missed);

    }

    public Set<Ship> getShips() {
        return new HashSet<>(ships);
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }

    public void setHits(Set<Coordinate> hits) {
        this.hits = hits;
    }

    public void setMissed(Set<Coordinate> missed) {
        this.missed = missed;
    }
}
