package gameflow;

import constants.BoardSize;
import constants.ShipRoster;
import ships.Dockyard;
import userinput.CoordinateParser;
import userinput.ShipSetupCommandLine;

import java.util.Scanner;

public class ShipSetupArgumentsProvider {

    public static ShipSetupArguments getStandardHumanArgs() {

        final Dockyard shipFactory = new Dockyard(BoardSize.STANDARD);
        final CoordinateParser parser = new CoordinateParser(BoardSize.STANDARD);
        final ShipSetupCommandLine commandLine = new ShipSetupCommandLine(parser, new Scanner(System.in));
        final ShipRoster shipRoster = ShipRoster.STANDARD;
        return new ShipSetupArguments(commandLine,shipFactory,shipRoster);
    }
}
