package GameFlow;

import GameState.GameStateService;
import Ships.ShipFactory;
import UserInput.ShipSetupCommandLine;

public class ShipSetup {

    private ShipSetupCommandLine commandLine;
    private GameStateService gameStateService;
    private ShipFactory shipFactory;
    public ShipSetup(ShipSetupCommandLine commandLine, GameStateService gameStateService, ShipFactory shipFactory){
        this.commandLine = commandLine;
        this.gameStateService = gameStateService;
        this.shipFactory = shipFactory;
    }

}
