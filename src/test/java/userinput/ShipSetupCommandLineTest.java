package userinput;

import constants.BoardSize;
import org.junit.jupiter.api.Test;
import ships.Coordinate;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ShipSetupCommandLineTest {

    @Test
    void testReadOneWordName() {
        Scanner scanner = new Scanner("b1 b2 4 aa");
        CoordinateParser coordinateParser = new CoordinateParser(BoardSize.STANDARD);
        ShipSetupCommandLine commandLine = new ShipSetupCommandLine(coordinateParser,scanner);

        ShipSetupResponse response = commandLine.read();

        assertEquals(response.getFirstCoord(), Coordinate.of(1,1));
        assertEquals(response.getSecondCoord(), Coordinate.of(1,2));

        assertEquals(response.getLength(),4);
        assertEquals(response.getShipName(),"aa");

    }

    @Test
    void testReadTwoWordName() {
        Scanner scanner = new Scanner("b1 b2 4 aa bb");
        CoordinateParser coordinateParser = new CoordinateParser(BoardSize.STANDARD);
        ShipSetupCommandLine commandLine = new ShipSetupCommandLine(coordinateParser,scanner);

        ShipSetupResponse response = commandLine.read();

        assertEquals(response.getFirstCoord(), Coordinate.of(1,1));
        assertEquals(response.getSecondCoord(), Coordinate.of(1,2));

        assertEquals(response.getLength(),4);
        assertEquals(response.getShipName(),"aa bb");

    }

    @Test
    void testReadTwoWordNameWithTrailingWhitespaces() {
        Scanner scanner = new Scanner("b1 b2 4 aa bb ");
        CoordinateParser coordinateParser = new CoordinateParser(BoardSize.STANDARD);
        ShipSetupCommandLine commandLine = new ShipSetupCommandLine(coordinateParser,scanner);

        ShipSetupResponse response = commandLine.read();

        assertEquals(response.getFirstCoord(), Coordinate.of(1,1));
        assertEquals(response.getSecondCoord(), Coordinate.of(1,2));

        assertEquals(response.getLength(),4);
        assertEquals(response.getShipName(),"aa bb");

    }

    @Test
    void testReadTwoWordNameWithEmptyNameShouldFail() {
        Scanner scanner = new Scanner("b1 b2 4");
        CoordinateParser coordinateParser = new CoordinateParser(BoardSize.STANDARD);
        ShipSetupCommandLine commandLine = new ShipSetupCommandLine(coordinateParser,scanner);

        assertThrows(IllegalArgumentException.class, commandLine::read);

    }

    @Test
    void testReadWithNoLengthShouldFail() {
        Scanner scanner = new Scanner("b1 b2 aa");
        CoordinateParser coordinateParser = new CoordinateParser(BoardSize.STANDARD);
        ShipSetupCommandLine commandLine = new ShipSetupCommandLine(coordinateParser,scanner);

        assertThrows(IllegalArgumentException.class, commandLine::read);

    }

    @Test
    void testReadWithOneCoordShouldFail() {
        Scanner scanner = new Scanner("b1 4 aa");
        CoordinateParser coordinateParser = new CoordinateParser(BoardSize.STANDARD);
        ShipSetupCommandLine commandLine = new ShipSetupCommandLine(coordinateParser,scanner);

        assertThrows(IllegalArgumentException.class, commandLine::read);

    }

    @Test
    void testReadWithThrashShouldFail() {
        Scanner scanner = new Scanner("aevrrsvrs");
        CoordinateParser coordinateParser = new CoordinateParser(BoardSize.STANDARD);
        ShipSetupCommandLine commandLine = new ShipSetupCommandLine(coordinateParser,scanner);

        assertThrows(IllegalArgumentException.class, commandLine::read);

    }
}