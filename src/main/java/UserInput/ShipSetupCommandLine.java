package UserInput;

import Ships.Coordinate;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ShipSetupCommandLine implements CommandLineInterface{
    private final Scanner scanner = new Scanner(System.in);
    private final CoordinateParser parser;

    public ShipSetupCommandLine (CoordinateParser parser){
        this.parser = parser;
    }

    public ShipSetupResponse read(){

        System.out.println("give date in format: nameOfShip c1 c2 3");
        String result = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(result);
        String shipName = stringTokenizer.nextToken();
        String firstCoord = stringTokenizer.nextToken();
        String secondCoord = stringTokenizer.nextToken();

        Coordinate firstC;
        Coordinate secondC;
        int length;

        firstC = parser.parseCoordinates(firstCoord);
        secondC = parser.parseCoordinates(secondCoord);
        length = Integer.parseInt(stringTokenizer.nextToken());

        return new ShipSetupResponse(shipName,firstC,secondC,length);

    }

}
