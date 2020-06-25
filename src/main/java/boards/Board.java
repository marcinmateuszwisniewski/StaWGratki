package boards;

import ships.Ship;
import ships.Coordinate;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents game board of one player.
 */
public class Board {

    /**
     * Ships on board.
     */
    Set<Ship> ships;
    /**
     * Confirmed hits.
     */
    Set<Coordinate> hits;
    /**
     * Confirmed miss.
     */
    Set<Coordinate> missed;


    /**
     * Instantiates a new Board.
     */
    Board(){
        ships = new HashSet<>();
        hits = new HashSet<>();
        missed = new HashSet<>();
    }

    /**
     * Copy board.
     *
     * @return the board
     */
    public Board copy() {
        Board copyBoard = new Board();
        copyBoard.ships = getShips();
        copyBoard.hits = getHits();
        copyBoard.missed = getMissed();
        return copyBoard;
    }

    /**
     * Gets hits.
     *
     * @return the hits
     */
    public Set<Coordinate> getHits() {
        return new HashSet<>(hits);
    }

    /**
     * Gets missed.
     *
     * @return the missed
     */
    public Set<Coordinate> getMissed() {
        return new HashSet<>(missed);

    }

    /**
     * Gets ships.
     *
     * @return the ships
     */
    public Set<Ship> getShips() {
        return new HashSet<>(ships);
    }

    /**
     * Sets ships.
     *
     * @param ships the ships
     */
    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }

    /**
     * Sets hits.
     *
     * @param hits the hits
     */
    public void setHits(Set<Coordinate> hits) {
        this.hits = hits;
    }

    /**
     * Sets missed.
     *
     * @param missed the missed
     */
    public void setMissed(Set<Coordinate> missed) {
        this.missed = missed;
    }
}
