package Boards;

import Ships.Ship;
import Ships.Coordinate;

import java.util.HashSet;

public class Board {

    public static final int SIZE = 10;

    HashSet<Ship> ships;
    HashSet<Coordinate> hits;
    HashSet<Coordinate> missed;


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

    public HashSet<Coordinate> getHits() {
        HashSet<Coordinate> coordinates = new HashSet<>();
        hits.forEach(h -> coordinates.add(new Coordinate(h)));
        return coordinates;
    }

    public HashSet<Coordinate> getMissed() {
        HashSet<Coordinate> coordinates = new HashSet<>();
        missed.forEach(h -> coordinates.add(new Coordinate(h)));
        return coordinates;
    }
}
