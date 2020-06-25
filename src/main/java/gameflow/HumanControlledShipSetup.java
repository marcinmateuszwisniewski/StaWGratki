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

/**
 * The type Human controlled ship setup.
 */
public class HumanControlledShipSetup implements ShipSetupInterface {

    private final CommandLineInterface commandLine;
    private final GameStateService gameStateService;
    private final ShipFactory shipFactory;
    private final BoardDisplay boardDisplay;
    private final ShipRoster shipRoster;

    /**
     * Instantiates a new Human controlled ship setup.
     *
     * @param shipSetupArguments the ship setup arguments
     * @param gs                 the gs
     * @param bd                 the bd
     */
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

//TODO: Think about putting this into BoardDisplay or ShipSetupCommandLine
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

                    if (ShipValidator.validate(newShip, ships)) {
                        ships.add(newShip);
                        numberOfShips.remove(newShip.getOriginalLength(), 1);
                        System.out.println("Ship added: " + newShip.getName());
                        boardDisplay.printShipsSetup(ships);

                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Bad params" + e.getMessage() + " Provide correct input");
                }


            }


        }

        return ships;





    }

    private void printNumberOfShipsLeft(Bag<Integer> numberOfShips) {
        System.out.println("ships left to set on board:");
        numberOfShips.uniqueSet().forEach(x -> System.out.println(x + ": " + numberOfShips.getCount(x)));
    }
}
