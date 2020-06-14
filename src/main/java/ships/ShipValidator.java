package ships;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ShipValidator {
    public static boolean validate (Ship shipToPut, Set<Ship> shipSet){

        Set<Coordinate> allPosistions = shipSet.stream().map(ship -> ship.position).flatMap(Collection::stream).collect(Collectors.toSet());
        for(Coordinate c : shipToPut.getPosition()){
            if (allPosistions.contains(c)){
                return false;
            }
        }

        return true;
    }
}
