package ships;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShipValidatorTest {

    final Set<Ship> ships = prepareShips();

    @Test
    void testValidPosition() {

        Ship ship = produceTestShip(Coordinate.of(7,3),
                Coordinate.of(8,3), Coordinate.of(9,3));

        assertTrue(ShipValidator.validate(ship,ships));
    }

    @Test
    void testValidPositionTouchingDiagonally() {

        Ship ship = produceTestShip(Coordinate.of(6,9),Coordinate.of(7,9),Coordinate.of(8,9));

        assertTrue(ShipValidator.validate(ship,ships));
    }



    @Test
    void testInvalidPositionOverlappingPosition() {
        Ship ship = produceTestShip(Coordinate.of(5,5),Coordinate.of(6,5));

        assertFalse(ShipValidator.validate(ship,ships));
    }

    /**
     * validates two ships placed parallel to horizontal ship
     */
    @Test
    void testInvalidPositionSideBySideHorizontalParallel() {
        Ship ship = produceTestShip(Coordinate.of(6,5),
                Coordinate.of(6,6), Coordinate.of(6,7), Coordinate.of(6,8));
        assertFalse(ShipValidator.validate(ship,ships));
        ship = produceTestShip(Coordinate.of(4,5),Coordinate.of(4,6));
        assertFalse(ShipValidator.validate(ship,ships));
    }

    /**
     * validates two ships placed perpendicularly to horizontal ship
     */
    @Test
    void testInvalidPositionSideBySideHorizontalPerpendicular() {
        Ship ship = produceTestShip(Coordinate.of(3,6),
                Coordinate.of(4,6));
        assertFalse(ShipValidator.validate(ship,ships));
        ship = produceTestShip(Coordinate.of(6,6),Coordinate.of(7,6));
        assertFalse(ShipValidator.validate(ship,ships));
    }

    /**
     * validates two ships placed perpendicularly to vertical ship
     */
    @Test
    void testInvalidPositionSideBySideVerticalPerpendicular() {
        Ship ship = produceTestShip(Coordinate.of(2,3),
                Coordinate.of(2,4));
        assertFalse(ShipValidator.validate(ship,ships));
        ship = produceTestShip(Coordinate.of(2,6),Coordinate.of(2,7));
        assertFalse(ShipValidator.validate(ship,ships));
    }

    /**
     * validates two ships placed parallel to vertical ship
     */
    @Test
    void testInvalidPositionSideBySideVerticalParallel() {
        Ship ship = produceTestShip(Coordinate.of(2,4),
                Coordinate.of(3,4));
        assertFalse(ShipValidator.validate(ship,ships));
        ship = produceTestShip(Coordinate.of(2,6),Coordinate.of(3,6));
        assertFalse(ShipValidator.validate(ship,ships));
    }

    /**
     * @return set of ships:
     * <li>(5,5)(5,6)(5,7)(5,8) - horizontal</li>
     * <li>(1,5)(2,5)(3,5) - vertical</li>
     */
    private Set<Ship> prepareShips() {

        Ship ship = produceTestShip(Coordinate.of(5,5),
                Coordinate.of(5,6), Coordinate.of(5,7), Coordinate.of(5,8));

        Ship ship2 = produceTestShip(Coordinate.of(1,5),
                Coordinate.of(2,5), Coordinate.of(3,5));

        Set<Ship> ships = new HashSet<>();
        ships.add(ship);
        ships.add(ship2);
        return ships;


    }

    private Ship produceTestShip(Coordinate... coordinates){

        Set<Coordinate> set = new HashSet<>();

        Collections.addAll(set, coordinates);

        return new Ship("Debug",set,set.size());
    }




}