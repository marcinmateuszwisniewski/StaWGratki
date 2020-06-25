package userinput;

import ships.Coordinate;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The type Ship setup command line.
 */
public class ShipSetupCommandLine implements CommandLineInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final CoordinateParser parser;

    /**
     * Instantiates a new Ship setup command line.
     *
     * @param parser the parser
     */
    public ShipSetupCommandLine(CoordinateParser parser) {
        this.parser = parser;
    }

    public ShipSetupResponse read() throws IllegalArgumentException{
        System.out.println("give ship info in format: c1 c2 3 name");
        System.out.println("c1 c2 - first two coordinates (their order matters!), must be side-by-side");
        System.out.println("3 - overall length of ship");
        System.out.println("name - duh");
        String result = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(result);
        String shipName;
        String firstCoord;
        String secondCoord;
        int length;

        try {
            firstCoord = stringTokenizer.nextToken();
            secondCoord = stringTokenizer.nextToken();
            length = Integer.parseInt(stringTokenizer.nextToken());
            shipName = stringTokenizer.nextToken("");
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
