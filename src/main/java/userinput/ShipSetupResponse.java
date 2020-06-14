package userinput;

import ships.Coordinate;

public class ShipSetupResponse implements CommandLineResponse {

    private String shipName;
    private Coordinate firstCoord;
    private Coordinate secondCoord;
    private int length;

    ShipSetupResponse(String shipName, Coordinate firstCoord, Coordinate secondCoord, int length){
        this.shipName = shipName;
        this.firstCoord = firstCoord;
        this.secondCoord = secondCoord;
        this.length = length;
    }

    public String getShipName() {
        return shipName;
    }

    public Coordinate getFirstCoord() {
        return firstCoord;
    }

    public Coordinate getSecondCoord() {
        return secondCoord;
    }

    public int getLength() {
        return length;
    }
}
