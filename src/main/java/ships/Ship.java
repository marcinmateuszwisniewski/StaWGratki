package ships;

import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    Ship(String name, Set<Coordinate> position, int originalLength){
        this.name = name;
        this.position = new HashSet<>();
        position.forEach(coordinate -> this.position.add(new Coordinate(coordinate))); //skoro koordynaty są immutable?
        this.originalLength = originalLength;
    }

    public Ship(Ship ship){

        HashSet<Coordinate> newPos = new HashSet<>();
        ship.position.forEach(coordinate -> newPos.add(new Coordinate(coordinate))); //skoro koordynaty są immutable?
        this.position = newPos;
        this.name = ship.name;
        this.originalLength = ship.originalLength;

    }

    public String getName() {
        return name;
    }

    public int getOriginalLength() {
        return originalLength;
    }

    public HashSet<Coordinate> getPosition(){
        return new HashSet<>(position);
    }





}
