package ships;

import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Ship.
 */
public class Ship {

    @Setter private Set<Coordinate> position;
    private final String name;
    private final int originalLength;

    private Ship(){
        name = "FAIL";
        originalLength = 0;
    }

    private Ship(String name, int originalLength){
        this.name = name;
        this.originalLength = originalLength;
    }

    /**
     * Instantiates a new Ship.
     *
     * @param name           the name
     * @param position       the position
     * @param originalLength the original length
     */
    Ship(String name, Set<Coordinate> position, int originalLength){
        this.name = name;
        this.position = new HashSet<>();
        position.forEach(coordinate -> this.position.add(new Coordinate(coordinate))); //skoro koordynaty są immutable?
        this.originalLength = originalLength;
    }

    /**
     * Instantiates a new Ship.
     *
     * @param ship the ship
     */
    public Ship(Ship ship){

        HashSet<Coordinate> newPos = new HashSet<>();
        ship.position.forEach(coordinate -> newPos.add(new Coordinate(coordinate))); //skoro koordynaty są immutable?
        this.position = newPos;
        this.name = ship.name;
        this.originalLength = ship.originalLength;

    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets original length.
     *
     * @return the original length
     */
    public int getOriginalLength() {
        return originalLength;
    }

    /**
     * Get position hash set.
     *
     * @return the hash set
     */
    public HashSet<Coordinate> getPosition(){
        return new HashSet<>(position);
    }





}
