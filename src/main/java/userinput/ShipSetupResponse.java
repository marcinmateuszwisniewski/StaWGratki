package userinput;

import ships.Coordinate;

/**
 * The type Ship setup response.
 */
public class ShipSetupResponse implements CommandLineResponse {

    private String shipName;
    private Coordinate firstCoord;
    private Coordinate secondCoord;
    private int length;

    /**
     * Instantiates a new Ship setup response.
     *
     * @param shipName    the ship name
     * @param firstCoord  the first coord
     * @param secondCoord the second coord
     * @param length      the length
     */
    ShipSetupResponse(String shipName, Coordinate firstCoord, Coordinate secondCoord, int length){
        this.shipName = shipName;
        this.firstCoord = firstCoord;
        this.secondCoord = secondCoord;
        this.length = length;
    }

    /**
     * Gets ship name.
     *
     * @return the ship name
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * Gets first coord.
     *
     * @return the first coord
     */
    public Coordinate getFirstCoord() {
        return firstCoord;
    }

    /**
     * Gets second coord.
     *
     * @return the second coord
     */
    public Coordinate getSecondCoord() {
        return secondCoord;
    }

    /**
     * Gets length.
     *
     * @return the length
     */
    public int getLength() {
        return length;
    }
}
