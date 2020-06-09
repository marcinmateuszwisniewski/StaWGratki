package GameFlow;

import Boards.Board;
import Boards.BoardDisplay;
import Boards.BoardValidator;
import GameState.GameState;
import GameState.GameStateService;
import Ships.Ship;
import Ships.ShipFactory;
import Ships.ShipValidator;
import UserInput.CommandLineInterface;
import UserInput.ShipSetupCommandLine;
import UserInput.ShipSetupResponse;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

import java.util.HashSet;

public class ShipSetup implements ShipSetupInterface {

    private CommandLineInterface commandLine;
    private GameStateService gameStateService;
    private ShipFactory shipFactory;
    private BoardDisplay boardDisplay;

    public ShipSetup(CommandLineInterface commandLine, GameStateService gameStateService, ShipFactory shipFactory, BoardDisplay bd) {
        this.commandLine = commandLine;
        this.gameStateService = gameStateService;
        this.shipFactory = shipFactory;
        this.boardDisplay = bd;
    }


    @Override
    public void setup() {

        HashSet<Ship> ships = new HashSet<>();
        GameState gameState = gameStateService.getState();

        Bag<Integer> numberOfShips = new HashBag<>();
        numberOfShips.add(5);
        numberOfShips.add(4);
        numberOfShips.add(3);
        numberOfShips.add(2, 2);

        while (!numberOfShips.isEmpty()) {

//TODO: Think about putting this into BoardDisplay or ShipSetupCommandLine
            printNumberOfShipsLeft(numberOfShips);

            Ship newShip = null;
            while (newShip == null) {
                try {

                    ShipSetupResponse response;
                    response = (ShipSetupResponse) commandLine.read();

                    newShip = shipFactory.launch(response.getShipName(), response.getFirstCoord(), response.getSecondCoord(), response.getLength());
                    System.out.println("ship:" + response.getShipName() + " created");

                    if (ShipValidator.validate(newShip, ships)) {
                        ships.add(newShip);
                        numberOfShips.remove(newShip.getOriginalLength(),1);
                        System.out.println("Ship added: " + newShip.getName());
                        boardDisplay.printShipsSetup(ships);

                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Bad params" + e.getMessage() + " Provide correct input");
                }


            }


        }

    }

    private void printNumberOfShipsLeft(Bag<Integer> numberOfShips) {
        System.out.println("Ships left to set on board:");
        numberOfShips.uniqueSet().forEach(x -> System.out.println(x + ": " + numberOfShips.getCount(x)));
    }
}
