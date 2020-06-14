import boards.BoardDisplay;
import gameflow.GameStart;
import gameflow.ShipSetup;
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
      BoardDisplay bd = new BoardDisplay(gs);
      bd.printBothBoards();
      ShipSetupInterface setup = new ShipSetup(new ShipSetupCommandLine(new CoordinateParser()),gs,new Dockyard(),bd);
      setup.setup();

        
    }
}
