package gameflow;

import boards.BoardDisplay;
import constants.ShipRoster;
import lombok.Data;
import ships.ShipFactory;
import userinput.CommandLineInterface;

/**
 * The type Ship setup arguments.
 */
@Data
public class ShipSetupArguments {
    private final CommandLineInterface commandLine;
    private final ShipFactory shipFactory;
    private final ShipRoster shipRoster;
    
}
