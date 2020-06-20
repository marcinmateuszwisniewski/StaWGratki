package ships;

import java.util.HashSet;
import java.util.Set;

// popraw sobie strukturę - zmienne do góry, metody na dół, a gettery i settery najlepiej lombok jak wspominałem (patrz @Data)
public class Ship {

    Set<Coordinate> position = new HashSet<>();

    public String getName() {
        return name;
    }

    public int getOriginalLength() {
        return originalLength;
    }

    private final String name;
    private final int originalLength;
    private Ship(String name, int originalLength){
        this.name = name;
        this.originalLength = originalLength;
    }

    Ship(String name, Set<Coordinate> position, int originalLength){
        this.name = name;
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

    public HashSet<Coordinate> getPosition(){
        return new HashSet<>(position);
    }

}
