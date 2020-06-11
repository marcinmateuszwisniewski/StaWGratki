package Boards;

import Ships.Ship;
import Ships.Coordinate;

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
        ships.forEach(ship -> copyBoard.ships.add(new Ship(ship)));
        copyBoard.hits = getHits();
        copyBoard.missed = getMissed();
        return copyBoard;
    }

    public Set<Coordinate> getHits() {
        HashSet<Coordinate> coordinates = new HashSet<>();
        hits.forEach(h -> coordinates.add(new Coordinate(h)));
        return coordinates;
    }

    public Set<Coordinate> getMissed() {
        HashSet<Coordinate> coordinates = new HashSet<>();
        missed.forEach(h -> coordinates.add(new Coordinate(h)));
        return coordinates;
    }


    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }
}
