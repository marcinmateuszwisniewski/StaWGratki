package UserInput;

import Ships.Coordinate;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ShipSetupCommandLine implements CommandLineInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final CoordinateParser parser;

    public ShipSetupCommandLine(CoordinateParser parser) {
        this.parser = parser;
    }

    public ShipSetupResponse read() throws IllegalArgumentException{

        System.out.println("give ship info in format: nameOfShip c1 c2 3");
        System.out.println("nameOfShip - duh");
        System.out.println("c1 c2 - first two coordinates (their order matters!), must be side-by-side");
        System.out.println("3 - overall length of ship");
        String result = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(result);
        String shipName;
        String firstCoord;
        String secondCoord;
        int length;

        try {
            shipName = stringTokenizer.nextToken();
            firstCoord = stringTokenizer.nextToken();
            secondCoord = stringTokenizer.nextToken();
            length = Integer.parseInt(stringTokenizer.nextToken());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("your input lacks something", e);

        }

        Coordinate firstC;
        Coordinate secondC;

        firstC = parser.parseCoordinates(firstCoord);
        secondC = parser.parseCoordinates(secondCoord);


        return new ShipSetupResponse(shipName, firstC, secondC, length);

    }

}
