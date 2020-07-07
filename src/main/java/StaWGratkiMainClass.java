import boards.BoardDisplay;
import constants.BoardSize;
import constants.PlayerEnum;
import gameflow.GameStart;
import gameflow.HumanControlledShipSetup;
import gameflow.ShipSetupArgumentsProvider;
import gameflow.ShipSetupInterface;
import gamestate.GameStateService;
import userinput.StartGameCommandLine;

import java.util.Scanner;

public class StaWGratkiMainClass {
    public static void main(String[] args) {
      System.out.println("srawg(t)atki");
      GameStateService gs = new GameStateService();
      Scanner scanner = new Scanner(System.in);
      GameStart gameStart = new GameStart(new StartGameCommandLine(scanner),gs);
      gameStart.init();
      final BoardDisplay bd = new BoardDisplay(gs, BoardSize.STANDARD);
      //TODO: too many arguments.
      final ShipSetupInterface setup = new HumanControlledShipSetup(ShipSetupArgumentsProvider.getStandardHumanArgs(), gs, bd);
      setup.setup(PlayerEnum.ONE);

        
    }
}
