package gameflow;

import boards.BoardDisplay;
import constants.PlayerEnum;
import constants.ShipRoster;
import gamestate.GameState;
import gamestate.GameStateService;
import ships.Ship;
import ships.ShipFactory;
import ships.ShipValidator;
import userinput.CommandLineInterface;
import userinput.ShipSetupResponse;
import org.apache.commons.collections4.Bag;

import java.util.HashSet;
import java.util.Set;

public class HumanControlledShipSetup implements ShipSetupInterface {

    private final CommandLineInterface commandLine;
    private final GameStateService gameStateService;
    private final ShipFactory shipFactory;
    private final BoardDisplay boardDisplay;
    private final ShipRoster shipRoster;

    public HumanControlledShipSetup(ShipSetupArguments shipSetupArguments, GameStateService gs, BoardDisplay bd) {
        commandLine = shipSetupArguments.getCommandLine();
        shipFactory = shipSetupArguments.getShipFactory();
        shipRoster = shipSetupArguments.getShipRoster();
        gameStateService = gs;
        boardDisplay = bd;
    }

    @Override
    public void setup(PlayerEnum playerEnum){
        GameState gameState = gameStateService.getState();

        gameState.getPlayer(playerEnum).getBoard().setShips(getShips());

        gameStateService.updateState(gameState);
        System.out.println("Thank you! Now wait for your enemy to setup");
    }



    private Set<Ship> getShips() {

        HashSet<Ship> ships = new HashSet<>();

        Bag<Integer> numberOfShips = shipRoster.value();

        while (!numberOfShips.isEmpty()) {
            Ship ship = getNextAvailableShip(numberOfShips);

            if (ShipValidator.validate(ship, ships)) {
                ships.add(ship);
                numberOfShips.remove(ship.getOriginalLength(), 1);
                System.out.println("Ship added: " + ship.getName());
                boardDisplay.printShipsSetup(ships);

            }
            else {
                System.out.println("Ship cannot be placed in this position. Try again.");
            }

        }

        return ships;





    }

    private Ship getNextAvailableShip(Bag<Integer> numberOfShips) {
        printNumberOfShipsLeft(numberOfShips);

        Ship newShip = null;
        while (newShip == null) {
            try {

                ShipSetupResponse response;
                response = (ShipSetupResponse) commandLine.read();

                if(numberOfShips.getCount(response.getLength()) < 1){
                    System.out.println("No ship of that length available. Please try again.");
                    continue;
                }

                newShip = shipFactory.launch(response.getShipName(), response.getFirstCoord(), response.getSecondCoord(), response.getLength());
                System.out.println("ship:" + response.getShipName() + " created");

                return newShip;

            } catch (IllegalArgumentException e) {
                System.out.println("Bad params" + e.getMessage() + " Provide correct input");
            }


        }
        return newShip;
    }

    private void printNumberOfShipsLeft(Bag<Integer> numberOfShips) {
        System.out.println("ships left to set on board:");
        numberOfShips.uniqueSet().forEach(x -> System.out.println(x + ": " + numberOfShips.getCount(x)));
    }
}
