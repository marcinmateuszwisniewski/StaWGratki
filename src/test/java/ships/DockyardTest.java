package ships;

import constants.BoardSize;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DockyardTest {

    @Test
    void testShouldProduceShipHorizontal(){
        Dockyard dockyard = new Dockyard(BoardSize.STANDARD);

        String name = "test";
        Coordinate firstCoord = Coordinate.of(5,5);
        Coordinate secondCoord = Coordinate.of(5,6);
        int length = 4;

        Ship ship = dockyard.launch(name,firstCoord,secondCoord,length);

        assertEquals(ship.getName(), name);
        assertEquals(length,ship.getOriginalLength());
        assertEquals(length,ship.getPosition().size());
        assertTrue(ship.getPosition().contains(firstCoord));
        assertTrue(ship.getPosition().contains(secondCoord));
        assertTrue(ship.getPosition().contains(Coordinate.of(5,7)));
        assertTrue(ship.getPosition().contains(Coordinate.of(5,8)));


    }

    @Test
    void testShouldProduceShipVertical(){

        Dockyard dockyard = new Dockyard(BoardSize.STANDARD);

        String name = "test";
        Coordinate firstCoord = Coordinate.of(5,5);
        Coordinate secondCoord = Coordinate.of(6,5);
        int length = 4;

        Ship ship = dockyard.launch(name,firstCoord,secondCoord,length);

        assertEquals(ship.getName(), name);
        assertEquals(length,ship.getOriginalLength());
        assertEquals(length,ship.getPosition().size());
        assertTrue(ship.getPosition().contains(firstCoord));
        assertTrue(ship.getPosition().contains(secondCoord));
        assertTrue(ship.getPosition().contains(Coordinate.of(7,5)));
        assertTrue(ship.getPosition().contains(Coordinate.of(8,5)));

    }

    @Test
    void testShouldThrowExceptionShipDontFitIntoBoard(){

        Dockyard dockyard = new Dockyard(BoardSize.STANDARD);

        String name = "test";
        Coordinate firstCoord = Coordinate.of(8,5);
        Coordinate secondCoord = Coordinate.of(9,5);
        int length = 4;

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->dockyard.launch(name,firstCoord,secondCoord,length));
        assertTrue(ex.getMessage().contains("fit into the board"));

    }

    @Test
    void testShouldThrowExceptionCoordinatesNotOnBoard(){

        Dockyard dockyard = new Dockyard(BoardSize.STANDARD);

        String name = "test";
        Coordinate firstCoord = Coordinate.of(10,5);
        Coordinate secondCoord = Coordinate.of(11,5);
        int length = 4;

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->dockyard.launch(name,firstCoord,secondCoord,length));
        assertTrue(ex.getMessage().contains("fit into the board"));

    }

    @Test
    void testShouldThrowExceptionCoordinatesSeparated(){
        Dockyard dockyard = new Dockyard(BoardSize.STANDARD);

        String name = "test";
        Coordinate firstCoord = Coordinate.of(5,5);
        Coordinate secondCoord = Coordinate.of(7,5);
        int length = 4;

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->dockyard.launch(name,firstCoord,secondCoord,length));
        assertTrue(ex.getMessage().contains("side-by-side"));
    }


    void testShouldThrowExceptionCoordinatesDiagonally(){

    }
}