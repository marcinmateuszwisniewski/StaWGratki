import boards.BoardDisplay;
import constants.BoardSize;
import constants.ShipRoster;
import gameflow.GameStart;
import gameflow.HumanControlledShipSetup;
import gameflow.ShipSetupInterface;
import gamestate.GameStateService;
import ships.Dockyard;
import userinput.CoordinateParser;
import userinput.ShipSetupCommandLine;
import userinput.StartGameCommandLine;

import java.util.Scanner;

/**
 *
 */
public class StaWGratkiMainClass {
    public static void main(String[] args) {
      System.out.println("srawg(t)atki");
      GameStateService gs = new GameStateService();
      Scanner scanner = new Scanner(System.in);
      GameStart gameStart = new GameStart(new StartGameCommandLine(scanner),gs);
      gameStart.init();
      final BoardDisplay bd = new BoardDisplay(gs,BoardSize.STANDARD);
      bd.printBothBoards();
      final Dockyard shipFactory = new Dockyard(BoardSize.STANDARD);
      final CoordinateParser parser = new CoordinateParser(BoardSize.STANDARD);
      final ShipSetupCommandLine commandLine = new ShipSetupCommandLine(parser);
      final ShipRoster shipRoster = ShipRoster.STANDARD;
      //TODO: too many arguments.
      final ShipSetupInterface setup = new HumanControlledShipSetup(commandLine,
              gs,
              shipFactory,
              bd,
              shipRoster);
      setup.setup();

        
    }
}
