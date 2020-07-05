package ships;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ShipValidator {
    public static boolean validate (Ship shipToPut, Set<Ship> shipSet){

        Set<Coordinate> allPosistions = shipSet.stream().map(Ship::getPosition).flatMap(Collection::stream).collect(Collectors.toSet());
        for(Coordinate c : shipToPut.getPosition()){
            if (allPosistions.contains(c) || allPosistions.stream().anyMatch(p -> p.isBy(c))){
                return false;
            }

        }

        return true;
    }
}
