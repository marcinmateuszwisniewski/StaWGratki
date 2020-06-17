package gameflow;

import boards.BoardDisplay;
import gamestate.GameState;
import gamestate.GameStateService;
import ships.Ship;
import ships.ShipFactory;
import ships.ShipValidator;
import userinput.CommandLineInterface;
import userinput.ShipSetupResponse;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

import java.util.HashSet;

public class ShipSetup implements ShipSetupInterface {

    private final CommandLineInterface commandLine;
    private final GameStateService gameStateService;
    private final ShipFactory shipFactory;
    private final BoardDisplay boardDisplay;

    public ShipSetup(CommandLineInterface commandLine, GameStateService gameStateService, ShipFactory shipFactory, BoardDisplay bd) {
        this.commandLine = commandLine;
        this.gameStateService = gameStateService;
        this.shipFactory = shipFactory;
        this.boardDisplay = bd;
    }


    @Override
    public void setup() {

        HashSet<Ship> ships = new HashSet<>();

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

        GameState gameState = gameStateService.getState();
        gameState.playerHumanBoard.setShips(ships);
        gameStateService.updateState(gameState);

        System.out.println("Thank you! Now wait for your enemy to setup");

        boardDisplay.printBothBoards();


    }

    private void printNumberOfShipsLeft(Bag<Integer> numberOfShips) {
        System.out.println("ships left to set on board:");
        numberOfShips.uniqueSet().forEach(x -> System.out.println(x + ": " + numberOfShips.getCount(x)));
    }
}
