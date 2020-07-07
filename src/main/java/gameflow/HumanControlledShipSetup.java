package gameflow;

import boards.Board;
import boards.BoardDisplay;
import constants.PlayerEnum;
import constants.ShipRoster;
import gamestate.GameState;
import gamestate.GameStateService;
import org.apache.commons.collections4.Bag;
import ships.Ship;
import ships.ShipFactory;
import ships.ShipValidator;
import userinput.CommandLineInterface;
import userinput.ShipSetupResponse;

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
    public void setup(PlayerEnum playerEnum) {
        GameState gameState = gameStateService.getState();

        final Board currentPlayerBoardFromState = getCurrentPlayerBoardFromState(playerEnum, gameState);
        currentPlayerBoardFromState.setShips(getShips());

        gameStateService.updateState(gameState);
        System.out.println("Thank you! Now wait for your enemy to setup");
    }

    private Board getCurrentPlayerBoardFromState(PlayerEnum playerEnum, GameState gameState) {
        return gameState.getPlayer(playerEnum).getBoard();
    }


    private Set<Ship> getShips() {

        HashSet<Ship> ships = new HashSet<>();

        Bag<Integer> availableShips = shipRoster.value();

        while (!availableShips.isEmpty()) {
            Ship ship = getNextAvailableShip(availableShips);

            if (ShipValidator.validate(ship, ships)) {
                ships.add(ship);
                countDownShipFromAvailableShipsRoster(availableShips, ship);
                printAddedShipName(ship);
                boardDisplay.printShipsSetup(ships);

            } else {
                System.out.println("Ship cannot be placed in this position. Try again.");
            }

        }

        return ships;


    }

    private void printAddedShipName(Ship ship) {
        System.out.println("Ship added: " + ship.getName());
    }

    private void countDownShipFromAvailableShipsRoster(Bag<Integer> numberOfShips, Ship ship) {
        numberOfShips.remove(ship.getOriginalLength(), 1);
    }

    private Ship getNextAvailableShip(Bag<Integer> availableShips) {
        printNumberOfShipsLeft(availableShips);

        Ship newShip = null;
        while (newShip == null) {
            try {

                ShipSetupResponse response = getResponseFromCommandLine();

                if (!isShipAvailable(availableShips, response)) {
                    System.out.println("No ship of that length available. Please try again.");
                    continue;
                }

                newShip = shipFactory.launch(response.getShipName(), response.getFirstCoord(),
                        response.getSecondCoord(), response.getLength());
                printCreatedShip(response);

            } catch (IllegalArgumentException e) {
                System.out.println("Bad params: " + e.getMessage() + " Provide correct input");
            }


        }
        return newShip;
    }

    private ShipSetupResponse getResponseFromCommandLine() {
        return (ShipSetupResponse) commandLine.read();
    }

    private void printCreatedShip(ShipSetupResponse response) {
        System.out.println("ship:" + response.getShipName() + " created");
    }

    private boolean isShipAvailable(Bag<Integer> availableShips, ShipSetupResponse response) {
        return availableShips.getCount(response.getLength()) > 0;
    }

    private void printNumberOfShipsLeft(Bag<Integer> numberOfShips) {
        System.out.println("ships left to set on board:");
        numberOfShips.uniqueSet().forEach(x -> System.out.println(x + ": " + numberOfShips.getCount(x)));
    }
}
