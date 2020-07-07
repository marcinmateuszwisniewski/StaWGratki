package gameflow;

import constants.ShipRoster;
import lombok.Data;
import ships.ShipFactory;
import userinput.CommandLineInterface;

@Data
public class ShipSetupArguments {
    private final CommandLineInterface commandLine;
    private final ShipFactory shipFactory;
    private final ShipRoster shipRoster;
    
}
