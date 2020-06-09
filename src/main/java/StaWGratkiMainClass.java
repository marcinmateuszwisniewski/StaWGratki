import Boards.BoardDisplay;
import GameFlow.GameStart;
import GameFlow.ShipSetup;
import GameFlow.ShipSetupInterface;
import GameState.GameStateService;
import Ships.Dockyard;
import UserInput.CoordinateParser;
import UserInput.ShipSetupCommandLine;
import UserInput.StartGameCommandLine;

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
      BoardDisplay bd = new BoardDisplay(gs);
      bd.printBothBoards();
      ShipSetupInterface setup = new ShipSetup(new ShipSetupCommandLine(new CoordinateParser()),gs,new Dockyard(),bd);
      setup.setup();

        
    }
}
