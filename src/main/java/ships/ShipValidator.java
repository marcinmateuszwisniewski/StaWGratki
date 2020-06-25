package ships;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class checks, if constructed ship can be placed with other ships, ie. they dont lay side-by-side or overlap.
 *
 */
public class ShipValidator {
    /**
     * Validate position of new ship among the others.
     *
     * @param shipToPut the ship to put
     * @param shipSet   the ship set
     * @return the correctness of this ship
     */
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
